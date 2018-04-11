package org.fslabs.springbootdoma2freemarker.app.dto;

import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.TermTreeListEntity;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTreeTerm;

public class TermTreeDto {

	private List<TermTreeTerm> termTreesTerm;
	private List<TermTreeListEntity> termTreeList;
	private long searchedCount;
	/**
	 * @return termTreesTerm
	 */
	public List<TermTreeTerm> getTermTreesTerm() {
		return termTreesTerm;
	}
	/**
	 * @return termTreeList
	 */
	public List<TermTreeListEntity> getTermTreeList() {
		return termTreeList;
	}
	/**
	 * @return searchedCount
	 */
	public long getSearchedCount() {
		return searchedCount;
	}
	/**
	 * @param termTreesTerm セットする termTreesTerm
	 */
	public void setTermTreesTerm(List<TermTreeTerm> termTreesTerm) {
		this.termTreesTerm = termTreesTerm;
	}
	/**
	 * @param termTreeList セットする termTreeList
	 */
	public void setTermTreeList(List<TermTreeListEntity> termTreeList) {
		this.termTreeList = termTreeList;
	}
	/**
	 * @param searchedCount セットする searchedCount
	 */
	public void setSearchedCount(long searchedCount) {
		this.searchedCount = searchedCount;
	}
}
