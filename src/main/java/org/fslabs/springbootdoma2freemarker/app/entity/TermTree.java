/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.entity;

import java.io.Serializable;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * @author kitaz
 *
 */
@Entity
@Table(name="TermTrees")
public class TermTree implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3473362484868930492L;

	@Version
	@Column(name="version")
	private long version;
	
	@Column(name="taxonomy_id")
	private String taxonomy_id;
	
	@Id
	@Column(name="parent_id")
	private String parent_id;
	
	@Id
	@Column(name="id")
	private String id;

	/**
	 * @return version
	 */
	public long getVersion() {
		return version;
	}

	/**
	 * @return taxonomy_id
	 */
	public String getTaxonomy_id() {
		return taxonomy_id;
	}

	/**
	 * @return parent_id
	 */
	public String getParent_id() {
		return parent_id;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param version セットする version
	 */
	public void setVersion(long version) {
		this.version = version;
	}

	/**
	 * @param taxonomy_id セットする taxonomy_id
	 */
	public void setTaxonomy_id(String taxonomy_id) {
		this.taxonomy_id = taxonomy_id;
	}

	/**
	 * @param parent_id セットする parent_id
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}
}
