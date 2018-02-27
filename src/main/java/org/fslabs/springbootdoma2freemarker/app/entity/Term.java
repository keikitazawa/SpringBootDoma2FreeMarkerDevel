package org.fslabs.springbootdoma2freemarker.app.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

@Entity
@Table(name="Terms")
public class Term implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1764104046776881026L;
	
	@Column(name="version")
	@Version
	private long version;
	
	@Column(name="modified")
	private Timestamp modified;
	
	@Column(name="deleted")
	private Timestamp deleted;
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="parent_id")
	private String parentId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="weight")
	private long weight;

	/**
	 * @return version
	 */
	public long getVersion() {
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
	public long getWeight() {
		return weight;
	}

	/**
	 * @param version セットする version
	 */
	public void setVersion(long version) {
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
	public void setWeight(long weight) {
		this.weight = weight;
	}
}

