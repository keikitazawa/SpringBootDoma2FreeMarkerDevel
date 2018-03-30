package org.fslabs.springbootdoma2freemarker.core.util;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedList;
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
		List<FieldError> ret = new LinkedList<>();
		
		// field単位で取得
		Field[] f = validateForm.getDeclaredFields();
		for (Field l : f) {
			System.out.println("Target Field is :" + l.getName());
			
    		Annotation[] a;
			a = l.getAnnotations();
			// アノテーションを順番に取得
	    	for(Annotation aa : a) {
	    		System.out.println("Annotation is :" + aa.annotationType().getName());
	    		
	    		// すべてのエラーから指定フィールド～指定アノテーションを取得
	    		for (FieldError fe : this.fieldErrors) {
	    			for (String code : fe.getCodes()) {
	    				System.out.println(aa.annotationType().getName() + "=" + code);
	    				System.out.println(l.getName() + "=" + fe.getField());
		    			if (aa.annotationType().getName().endsWith(code) && l.getName().equals(fe.getField())) {
		    				ret.add(fe);
		    			}
	    			}
	    		}
    		}
		}
		// 逆順になるため
		Collections.reverse(ret);
		return ret;
	}
}
