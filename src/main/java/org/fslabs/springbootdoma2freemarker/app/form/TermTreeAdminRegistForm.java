/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.form;

import java.sql.Timestamp;

/**
 * @author kitaz
 *
 */
public class TermTreeAdminRegistForm extends TermTreeAdminSearchForm {

	private Timestamp modified;
	private Timestamp deleted;
	private String id;
	private String name;
	private String description;
	private long weight;
	
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
	public long getWeight() {
		return weight;
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
	public void setWeight(long weight) {
		this.weight = weight;
	}
}
