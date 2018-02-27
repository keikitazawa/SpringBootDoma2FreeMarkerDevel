package org.fslabs.springbootdoma2freemarker.app.dao;


import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

@Dao
@ConfigAutowireable
public interface TaxonomyDao {
	
	/**
	 * id完全一致による１件取得処理
	 * @param id
	 * @return
	 */
	@Select
	public Taxonomy findById(String id);
	
	/**
	 * カテゴリー名部分一致による複数検索
	 * @param name
	 * @param id
	 * @return
	 */
	@Select
	public List<Taxonomy> selectByName(String name);

	/**
	 * キーワード検索による複数検索（ページネーション用）
	 * @param keyword
	 * @param options
	 * @param orderBy
	 * @return
	 */
	@Select
	public List<Taxonomy> findByKeyword(String keyword, SelectOptions options, String orderBy);
	
	/**
	 * 重複チェック用
	 * @param name
	 * @return
	 */
	@Select
	public Taxonomy findByName(String name, String id);
	
	
	@Insert(exclude={"modified", "deleted"})
	public int insert(Taxonomy taxonomy);
	
	@Update(ignoreVersion=false)
	public int update(Taxonomy taxonomy);
	
	@Delete
	public int delete(Taxonomy taxonomy);
}


