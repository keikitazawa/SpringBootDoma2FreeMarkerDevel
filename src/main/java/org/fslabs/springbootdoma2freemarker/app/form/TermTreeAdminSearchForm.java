/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.form;

import org.fslabs.springbootdoma2freemarker.core.form.BaseSearchForm;

/**
 * @author kitaz
 *
 */
public class TermTreeAdminSearchForm extends BaseSearchForm {
	
	private String keyword;
	
	/**
	 * @return keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword セットする keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
