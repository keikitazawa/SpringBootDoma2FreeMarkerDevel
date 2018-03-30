package org.fslabs.springbootdoma2freemarker.core.util;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class SortedBindingResult {
	
	private List<FieldError> fieldErrors;
	private Class<?> validateForm;
	
	public SortedBindingResult(List<FieldError> fieldErrors, Class<?> validateForm) {
		this.fieldErrors = fieldErrors;
		this.validateForm = validateForm;
	}
	
	public List<FieldError> getErrors(){
		List<FieldError> ret = new ArrayList<FieldError>();
		
		// field単位で取得
		Field[] fs = validateForm.getDeclaredFields();
		for (Field f : fs) {
//			System.out.println("Target Field is :" + f.getName());
			
    		Annotation[] aa = f.getAnnotations();
			// アノテーションを順番に取得
	    	for (Annotation a : aa) {
//	    		System.out.println("Annotation is :" + a.annotationType().getName());
	    		
	    		// すべてのエラーから指定フィールド～指定アノテーションを取得
	    		for (FieldError fe : this.fieldErrors) {
//	    			System.out.println(a.annotationType().getName() + "=" + fe.getCode());
//    				System.out.println(f.getName() + "=" + fe.getField());
	    			if (a.annotationType().getName().endsWith(fe.getCode()) && f.getName().equals(fe.getField())) {
	    				ret.add(fe);
	    			}
	    		}
    		}
		}
		return ret;
	}
}
