package org.fslabs.springbootdoma2freemarker.core.dao;
import org.fslabs.springbootdoma2freemarker.core.entity.AuthenticationEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface AuthenticationDao {

	@Select
    AuthenticationEntity findOneByEmailAndDeletedIsNull(String email);
}
