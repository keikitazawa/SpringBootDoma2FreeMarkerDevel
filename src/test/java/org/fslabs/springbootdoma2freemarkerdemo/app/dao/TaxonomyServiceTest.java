package org.fslabs.springbootdoma2freemarkerdemo.app.dao;
import static org.junit.Assert.*;

import org.fslabs.springbootdoma2freemarker.app.dao.TaxonomyDao;
import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class TaxonomyServiceTest {

	@Autowired
	private TaxonomyDao _dao;


	@Test
	public final void testUpdate() {
		String id = "20180272-test-X000-0000-000000000000";
		
		// １件取得
		Taxonomy entity = new Taxonomy();
		entity.setId(id);
		entity.setName("JUnit_Taxonomy_Data");
		entity.setDescription("no fetch");
		_dao.insert(entity);
		
		Taxonomy firstfetch = new Taxonomy();
		Taxonomy updateFetch = new Taxonomy();
		
		// first fetch
		firstfetch = _dao.findById(id);
		firstfetch.setDescription("first fetch");
		
		// second fetch
		updateFetch = _dao.findById(id);
		updateFetch.setDescription("second fetch");
		try {
			_dao.update(updateFetch);
		} catch (Exception e) {
			fail("Update Error");
		}
		
		// 比較
		assertEquals(updateFetch.getDescription() , "second fetch");
		
		// firstfetchの更新は不可
		try {
			firstfetch.setDescription("first fetch");
			_dao.update(firstfetch);
		} catch (OptimisticLockingFailureException e) {
			System.out.println("### 楽観的排他制御によるエラーを確認 ###");
		}
	}

}
