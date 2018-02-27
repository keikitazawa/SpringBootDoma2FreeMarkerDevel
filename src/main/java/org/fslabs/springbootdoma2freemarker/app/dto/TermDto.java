/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fslabs.springbootdoma2freemarker.app.dto;

import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.Term;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTaxonomy;

/**
 * タクソノミーグループのエンティティ
 * @author kitaz
 */
public class TermDto {
	
	private Term term;
	private List<TermTaxonomy> TaxonomyInfo;
	
	/**
	 * @return term
	 */
	public Term getTerm() {
		return term;
	}
	/**
	 * @return taxonomyInfo
	 */
	public List<TermTaxonomy> getTaxonomyInfo() {
		return TaxonomyInfo;
	}
	/**
	 * @param term セットする term
	 */
	public void setTerm(Term term) {
		this.term = term;
	}
	/**
	 * @param taxonomyInfo セットする taxonomyInfo
	 */
	public void setTaxonomyInfo(List<TermTaxonomy> taxonomyInfo) {
		TaxonomyInfo = taxonomyInfo;
	}
}
