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
	private String previousParams;
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
	 * @return previousParams
	 */
	public String getPreviousParams() {
		return previousParams;
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
	/**
	 * @param previousParams セットする previousParams
	 */
	public void setPreviousParams(String previousParams) {
		this.previousParams = previousParams;
	}
}
