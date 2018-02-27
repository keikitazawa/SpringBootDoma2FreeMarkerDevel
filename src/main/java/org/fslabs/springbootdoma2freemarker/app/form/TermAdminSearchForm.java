/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.form;

import org.fslabs.springbootdoma2freemarker.core.form.BaseSearchForm;

/**
 * @author kitaz
 *
 */
public class TermAdminSearchForm extends BaseSearchForm {
	
	/**
	 * 削除・詳細画面出力用のid
	 */
	private String  id;
	/**
	 * version number
	 */
	private String version;
	/**
	 * 検索キーワード
	 */
	private String searchKeyword;
	/**
	 * 絞込機能での親ID
	 */
	private String parentId;
	/**
	 * 前画面へのクエリストリング
	 */
	private String previousParams;

	/** getter/setter **/
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @return searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
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
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param version セットする version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @param searchKeyword セットする searchKeyword
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
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
