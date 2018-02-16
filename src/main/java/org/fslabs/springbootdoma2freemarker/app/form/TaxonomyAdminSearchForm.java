package org.fslabs.springbootdoma2freemarker.app.form;

import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.fslabs.springbootdoma2freemarker.core.form.BaseSearchForm;
import org.fslabs.springbootdoma2freemarker.core.valid.annotation.NotEntry;
import org.fslabs.springbootdoma2freemarker.core.valid.annotation.NotNumber;
import org.fslabs.springbootdoma2freemarker.core.valid.group.EntryValidation;
import org.fslabs.springbootdoma2freemarker.core.valid.group.StyleValidation;

public class TaxonomyAdminSearchForm extends BaseSearchForm {
	
	private Timestamp modified;
	private Timestamp deleted;
	private String id;
	@NotEntry(target="カテゴリー名", message="{messages.valid.empty}", groups=EntryValidation.class)
	@Size(max=128, groups=StyleValidation.class)
	private String name;
	private String description;
	@NotEntry(target="重さ", message="{messages.valid.empty}", groups=EntryValidation.class)
	@NotNumber(groups=StyleValidation.class)
	@Min(value=0, groups=StyleValidation.class)
	private String weight;
	private String searchKeyword;
	/**
	 * @return modified
	 */
	public Timestamp getModified() {
		return modified;
	}
	/**
	 * @return deleted
	 */
	public Timestamp getDeleted() {
		return deleted;
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
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @return searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}
	/**
	 * @param modified セットする modified
	 */
	public void setModified(Timestamp modified) {
		this.modified = modified;
	}
	/**
	 * @param deleted セットする deleted
	 */
	public void setDeleted(Timestamp deleted) {
		this.deleted = deleted;
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
	 * @param description セットする description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param weight セットする weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * @param searchKeyword セットする searchKeyword
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}
