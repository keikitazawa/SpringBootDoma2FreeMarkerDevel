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
	
	private String taxonomyId;
	private String parentId;
	
	/**
	 * @return taxonomyId
	 */
	public String getTaxonomyId() {
		return taxonomyId;
	}
	/**
	 * @return parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param taxonomyId セットする taxonomyId
	 */
	public void setTaxonomyId(String taxonomyId) {
		this.taxonomyId = taxonomyId;
	}
	/**
	 * @param parentId セットする parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
