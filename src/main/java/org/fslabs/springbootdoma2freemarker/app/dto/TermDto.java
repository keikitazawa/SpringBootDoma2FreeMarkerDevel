/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fslabs.springbootdoma2freemarker.app.dto;

import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.TermTaxonomy;

/**
 * タクソノミーグループのエンティティ
 * @author kitaz
 */
public class TermDto {
	
	private List<TermTaxonomy> TaxonomyInfo;

	/**
	 * @return taxonomyInfo
	 */
	public List<TermTaxonomy> getTaxonomyInfo() {
		return TaxonomyInfo;
	}

	/**
	 * @param taxonomyInfo セットする taxonomyInfo
	 */
	public void setTaxonomyInfo(List<TermTaxonomy> taxonomyInfo) {
		TaxonomyInfo = taxonomyInfo;
	}
}
