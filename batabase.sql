
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;



CREATE TABLE public.answer (
    id integer NOT NULL,
    questionid integer,
    value character varying(150),
    index character varying(1)
);


ALTER TABLE public.answer OWNER TO postgres;

ALTER TABLE public.answer ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.answer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);

CREATE TABLE public.exam (
    id integer NOT NULL,
    name character varying(150)
);


ALTER TABLE public.exam OWNER TO postgres;



ALTER TABLE public.exam ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.exam_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


CREATE TABLE public.question (
    id integer NOT NULL,
    examid integer,
    query character varying(150),
    score numeric,
    correctanswer character varying(150)
);


ALTER TABLE public.question OWNER TO postgres;


ALTER TABLE public.question ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.question_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);



CREATE TABLE public.student (
    id integer NOT NULL,
    name character varying(150),
    age numeric,
    city character varying(150),
    timezone character varying(150)
);


ALTER TABLE public.student OWNER TO postgres;


ALTER TABLE public.student ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.student_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);



CREATE TABLE public.studentexam (
    id integer NOT NULL,
    studentid integer,
    examid integer,
    "time" time with time zone,
    date date
);


ALTER TABLE public.studentexam OWNER TO postgres;


ALTER TABLE public.studentexam ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.studentexam_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);

CREATE TABLE public.studentresponse (
    id integer NOT NULL,
    studentexamid integer,
    answerid integer NOT NULL,
    questionid integer
);


ALTER TABLE public.studentresponse OWNER TO postgres;


ALTER TABLE public.studentresponse ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.studentresponse_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.studentexam
    ADD CONSTRAINT studentexam_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.studentresponse
    ADD CONSTRAINT fk_answer_answerid FOREIGN KEY (answerid) REFERENCES public.answer(id);


ALTER TABLE ONLY public.studentexam
    ADD CONSTRAINT fk_exam_examid FOREIGN KEY (examid) REFERENCES public.exam(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


ALTER TABLE ONLY public.question
    ADD CONSTRAINT fk_exam_id FOREIGN KEY (examid) REFERENCES public.exam(id) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE ONLY public.answer
    ADD CONSTRAINT fk_question_answerid FOREIGN KEY (questionid) REFERENCES public.question(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


ALTER TABLE ONLY public.studentresponse
    ADD CONSTRAINT fk_question_questionid FOREIGN KEY (questionid) REFERENCES public.question(id);


ALTER TABLE ONLY public.studentexam
    ADD CONSTRAINT fk_student_studentid FOREIGN KEY (studentid) REFERENCES public.student(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


ALTER TABLE ONLY public.studentresponse
    ADD CONSTRAINT fk_studentexam_studentexamid FOREIGN KEY (studentexamid) REFERENCES public.studentexam(id) NOT VALID;
