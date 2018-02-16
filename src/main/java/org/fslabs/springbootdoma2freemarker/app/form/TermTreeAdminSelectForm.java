/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.form;

/**
 * @author kitaz
 *
 */
public class TermTreeAdminSelectForm extends TermTreeAdminSearchForm {
	
	private String parentId;

	/**
	 * @return parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId セットする parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	

}
