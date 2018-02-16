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
