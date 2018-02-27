package org.fslabs.springbootdoma2freemarker.core.valid.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.fslabs.springbootdoma2freemarker.core.valid.annotation.NotNumber;
import org.springframework.util.StringUtils;

/**
 * 自然数チェック
 * @author kitaz
 *
 */
public class NotNumberValidator implements ConstraintValidator<NotNumber, Object> {

	private Pattern p = Pattern.compile("^[1-9]{0,}[0-9]{1,}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public void initialize(NotNumber constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object in, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(in)) {
			return true;
		}
		return p.matcher(in.toString()).matches();
	}

}
