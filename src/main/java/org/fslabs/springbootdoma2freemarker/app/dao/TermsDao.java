package org.fslabs.springbootdoma2freemarker.app.dao;


import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
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

	@Select
	public List<Taxonomy> findAll(SelectOptions options, String orderBy);
	
	@Select
	public List<Taxonomy> findByParentId(String parentId, SelectOptions options, String orderBy);
	
	@Select
	public List<Taxonomy> findByKeyword(String parentId, String keyword, SelectOptions options, String orderBy);
	
	@Select
	public List<TermTaxonomy> findByKeywordForInfo(String parentId, String keyword, SelectOptions options, String orderBy);

	@Insert(exclude={"modified", "deleted"})
	public int insert(Taxonomy taxonomy);
	
	@Update
	public int update(Taxonomy taxonomy);
	
	@Delete
	public int delete(Taxonomy taxonomy);
}


