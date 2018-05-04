package org.fslabs.springbootdoma2freemarker.app.entity;

public class TermTreeListEntity {

	private String taxonomyId;
	private String id;
	private String name;
	private int level;
	private boolean isSearch = false;
	/**
	 * @return taxonomyId
	 */
	public String getTaxonomyId() {
		return taxonomyId;
	}
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @return isSearch
	 */
	public boolean isSearch() {
		return isSearch;
	}
	/**
	 * @param taxonomyId セットする taxonomyId
	 */
	public void setTaxonomyId(String taxonomyId) {
		this.taxonomyId = taxonomyId;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param level セットする level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @param isSearch セットする isSearch
	 */
	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}

}
