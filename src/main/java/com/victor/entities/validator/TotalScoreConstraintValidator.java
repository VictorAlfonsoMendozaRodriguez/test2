package com.victor.entities.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.victor.dto.QuestionDTO;


public class TotalScoreConstraintValidator implements ConstraintValidator<TotalScoreConstrait, List<QuestionDTO>>  {
	
	private int maxScore;
	
	@Override
    public void initialize(TotalScoreConstrait constraintAnnotation) {
        this.maxScore = constraintAnnotation.customField();
    }

	@Override
	public boolean isValid(List<QuestionDTO> value, ConstraintValidatorContext context) {
		return value != null && value.stream().mapToInt(QuestionDTO::getScore).sum()<=maxScore;
	}
	
}
