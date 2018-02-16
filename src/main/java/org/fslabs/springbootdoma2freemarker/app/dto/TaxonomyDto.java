/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.dto;

import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;


/**
 * @author kitaz
 *
 */
public class TaxonomyDto {

	private Taxonomy taxonomy;
	private List<Taxonomy> taxonomies;
	
	/**
	 * @return taxonomy
	 */
	public Taxonomy getTaxonomy() {
		return taxonomy;
	}
	/**
	 * @return taxonomies
	 */
	public List<Taxonomy> getTaxonomies() {
		return taxonomies;
	}
	/**
	 * @param taxonomy セットする taxonomy
	 */
	public void setTaxonomy(Taxonomy taxonomy) {
		this.taxonomy = taxonomy;
	}
	/**
	 * @param taxonomies セットする taxonomies
	 */
	public void setTaxonomies(List<Taxonomy> taxonomies) {
		this.taxonomies = taxonomies;
	}
}
