package org.fslabs.springbootdoma2freemarker.app.dto;

import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.TermTreeTerm;

public class TermTreeDto {

	private List<TermTreeTerm> termTreesTerm;
	private long searchedCount;

	/**
	 * @return termTreesTerm
	 */
	public List<TermTreeTerm> getTermTreesTerm() {
		return termTreesTerm;
	}

	/**
	 * @param termTreesTerm セットする termTreesTerm
	 */
	public void setTermTreesTerm(List<TermTreeTerm> termTreesTerm) {
		this.termTreesTerm = termTreesTerm;
	}

	/**
	 * @return searchedCount
	 */
	public long getSearchedCount() {
		return searchedCount;
	}

	/**
	 * @param searchedCount セットする searchedCount
	 */
	public void setSearchedCount(long searchedCount) {
		this.searchedCount = searchedCount;
	}

	
	
}
