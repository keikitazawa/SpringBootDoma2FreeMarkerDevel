/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.dao;

import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.entity.TermTree;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTreeTerm;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

/**
 * @author kitaz
 *
 */
@Dao
@ConfigAutowireable
public interface TermTreesDao {
	
	@Select
	public List<TermTreeTerm> findByKeyword(String parentId, String keyword, SelectOptions options, String orderBy);
	
	@Select
	public List<TermTreeTerm> findByParentId(String parentId, SelectOptions options, String orderBy);

	@Insert
	public int insert(TermTree termTree);
	
	@Update
	public int update(TermTree termTree);
	
	@Delete
	public int delete(TermTree termTree);
}
