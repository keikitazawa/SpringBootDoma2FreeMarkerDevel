package org.fslabs.springbootdoma2freemarker.app.form;

import org.fslabs.springbootdoma2freemarker.core.form.BaseSearchForm;

public class TaxonomyAdminSearchForm extends BaseSearchForm {
	
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
}
