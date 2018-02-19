package org.fslabs.springbootdoma2freemarker.core.entity;

import java.util.List;

public class ApiResultEntity {
	
	/**
	 * エラーコード等を返す
	 */
	private int result;
	/**
	 * API出力用
	 */
	private List<?> lists;
	/**
	 * エラー出力用
	 */
	private List<?> errors;
	/**
	 * @return result
	 */
	public int getResult() {
		return result;
	}
	/**
	 * @return lists
	 */
	public List<?> getLists() {
		return lists;
	}
	/**
	 * @return errors
	 */
	public List<?> getErrors() {
		return errors;
	}
	/**
	 * @param result セットする result
	 */
	public void setResult(int result) {
		this.result = result;
	}
	/**
	 * @param lists セットする lists
	 */
	public void setLists(List<?> lists) {
		this.lists = lists;
	}
	/**
	 * @param errors セットする errors
	 */
	public void setErrors(List<?> errors) {
		this.errors = errors;
	}
	

}
