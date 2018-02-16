package org.fslabs.springbootdoma2freemarker.core.valid.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.fslabs.springbootdoma2freemarker.core.valid.annotation.NotEntry;
import org.springframework.util.StringUtils;

/**
 * 
 * @author kitaz
 *
 */
public class NotEntryValidator implements ConstraintValidator<NotEntry, String> {

	@Override
	public void initialize(NotEntry constraintAnnotation) {
	}

	@Override
	public boolean isValid(String in, ConstraintValidatorContext context) {
		return !StringUtils.isEmpty(in);
	}

}
