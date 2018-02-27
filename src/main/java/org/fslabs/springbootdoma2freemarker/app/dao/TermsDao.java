package org.fslabs.springbootdoma2freemarker.app.dao;


import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.fslabs.springbootdoma2freemarker.app.entity.Term;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTaxonomy;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

@Dao
@ConfigAutowireable
public interface TermsDao {
	
	/**
	 * id完全一致による１件検索
	 * @param id
	 * @return
	 */
	@Select
	public Term findById(String id);
	
	/**
	 * 名称部分一致による複数検索
	 * @param name
	 * @return
	 */
	@Select
	public List<Term> selectByName(String name);
	
	/**
	 * 親ID・キーワード検索（親IDを持たない）（ページネーション用）
	 * TODO 必要性を検討
	 * @param parentId
	 * @param keyword
	 * @param options
	 * @param orderBy
	 * @return
	 */
	@Select
	public List<Term> findByKeyword(String parentId, String keyword, SelectOptions options, String orderBy);
	
	/**
	 * 親ID・キーワード検索（Taxonomy情報を含む）（ページネーション用）
	 * @param parentId
	 * @param keyword
	 * @param options
	 * @param orderBy
	 * @return
	 */
	@Select
	public List<TermTaxonomy> findByKeywordForInfo(String parentId, String keyword, SelectOptions options, String orderBy);
	
	/**
	 * 重複チェック用
	 * @param name
	 * @return
	 */
	@Select
	public Term findByName(String parentId, String name, String id);

	@Insert(exclude={"modified", "deleted"})
	public int insert(Term term);
	
	@Update
	public int update(Term term);
	
	@Delete
	public int delete(Term term);
}


