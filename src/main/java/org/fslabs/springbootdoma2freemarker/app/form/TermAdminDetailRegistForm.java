/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.form;

import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.fslabs.springbootdoma2freemarker.core.form.BaseSearchForm;
import org.fslabs.springbootdoma2freemarker.core.valid.group.EntryValidation;
import org.fslabs.springbootdoma2freemarker.core.valid.group.StyleValidation;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author kitaz
 *
 */
public class TermAdminDetailRegistForm extends BaseSearchForm {
	
	private String version;
	private Timestamp modified;
	private Timestamp deleted;
	private String id;
	
	// TODO 変数はcamelcase、tableはsnakecase
	@NotEmpty(groups=EntryValidation.class)
	private String parentId;
	@NotEmpty(groups=EntryValidation.class)
	@Size(max=128, groups=StyleValidation.class)
	private String name;
	private String description;
	@NotEmpty(groups=EntryValidation.class)
	@Min(value=0, groups=StyleValidation.class)
	private String weight;
	// 親画面の検索条件
	private String searchKeyword;
	private String searchParentId;

	/** getter/setter **/
	/**
	 * @return version
	 */
	public String getVersion() {
		return version;
	}
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
	 * @return parentId
	 */
	public String getParentId() {
		return parentId;
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
	 * @return searchParentId
	 */
	public String getSearchParentId() {
		return searchParentId;
	}
	/**
	 * @param version セットする version
	 */
	public void setVersion(String version) {
		this.version = version;
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
	 * @param parentId セットする parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	/**
	 * @param searchParentId セットする searchParentId
	 */
	public void setSearchParentId(String searchParentId) {
		this.searchParentId = searchParentId;
	}
}
