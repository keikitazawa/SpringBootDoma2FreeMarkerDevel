package org.fslabs.springbootdoma2freemarker.core.valid.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.fslabs.springbootdoma2freemarker.core.valid.validation.NotEntryValidator;


/**
 * 入力チェック(String)
 *　@param target エラー時に表示する入力項目の名称
 */
@Documented
@Constraint(validatedBy = NotEntryValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEntry {

	String message() default "{messages.valid.empty}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	/**
	 * メッセージとして表示する名称
	 */
	String target() default "{0}";
}
