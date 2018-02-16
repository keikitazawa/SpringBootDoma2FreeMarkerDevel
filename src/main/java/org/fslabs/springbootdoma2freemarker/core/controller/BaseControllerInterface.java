package org.fslabs.springbootdoma2freemarker.core.controller;

import java.util.HashMap;

public interface BaseControllerInterface {

	 HashMap<String, Object> setAttributeToMap(HashMap<String, Object> map);
	 
	 HashMap<String, String> getColumnNames();
}
