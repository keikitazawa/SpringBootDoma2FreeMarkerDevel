/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.entity;

import java.io.Serializable;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

/**
 * @author kitaz
 *
 */
@Entity
public class TermTreeTerm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3473362484868930492L;

	@Id
	@Column(name="id")
	private String id;

	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="weight")
	private long weight;

	@Column(name="taxonomy_name")
	private String taxonomyName;

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
	 * @return taxonomyName
	 */
	public String getTaxonomyName() {
		return taxonomyName;
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

	/**
	 * @param taxonomyName セットする taxonomyName
	 */
	public void setTaxonomyName(String taxonomyName) {
		this.taxonomyName = taxonomyName;
	}
}
