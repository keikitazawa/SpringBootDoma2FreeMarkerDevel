/**
 * 
 */
package org.fslabs.springbootdoma2freemarkerdemo.core.util;

import static org.junit.Assert.*;

import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.dao.TaxonomyDao;
import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.fslabs.springbootdoma2freemarker.core.util.DomaSelectOptionsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kitaz
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DomaSelectOptionsUtilTest {

    /** ApplicationContext */
    @Autowired
    protected ApplicationContext context;
    
	@Autowired
	TaxonomyDao _td;

	@Test
	public final void test() {
		
		SelectOptions so1 = DomaSelectOptionsUtil.get(0, 2);
		SelectOptions so2 = DomaSelectOptionsUtil.get(20, 100);
		
		List<Taxonomy> list1 = _td.selectByName(null);
		assertEquals(2, list1.size());
	}
}
