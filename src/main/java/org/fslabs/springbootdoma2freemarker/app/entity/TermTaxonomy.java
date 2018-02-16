/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Version;

/**
 * @author kitaz
 *
 */
@Entity
public class TermTaxonomy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4876643029145192980L;

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
	private String parent_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="weight")
	private long weight;

	/** taxonomy **/
	@Column(name="parent_id")
	private String parentId;
	
	@Column(name="taxonomy_name")
	private String taxonomy_name;
	
	@Column(name="taxonomy_description")
	private String taxonomy_description;
	
	@Column(name="taxonomy_weight")
	private long taxonomy_weight;

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
	 * @return parent_id
	 */
	public String getParent_id() {
		return parent_id;
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
	 * @return parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @return taxonomy_name
	 */
	public String getTaxonomy_name() {
		return taxonomy_name;
	}

	/**
	 * @return taxonomy_description
	 */
	public String getTaxonomy_description() {
		return taxonomy_description;
	}

	/**
	 * @return taxonomy_weight
	 */
	public long getTaxonomy_weight() {
		return taxonomy_weight;
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
	 * @param parent_id セットする parent_id
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
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

	/**
	 * @param parentId セットする parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @param taxonomy_name セットする taxonomy_name
	 */
	public void setTaxonomy_name(String taxonomy_name) {
		this.taxonomy_name = taxonomy_name;
	}

	/**
	 * @param taxonomy_description セットする taxonomy_description
	 */
	public void setTaxonomy_description(String taxonomy_description) {
		this.taxonomy_description = taxonomy_description;
	}

	/**
	 * @param taxonomy_weight セットする taxonomy_weight
	 */
	public void setTaxonomy_weight(long taxonomy_weight) {
		this.taxonomy_weight = taxonomy_weight;
	}
	
}
