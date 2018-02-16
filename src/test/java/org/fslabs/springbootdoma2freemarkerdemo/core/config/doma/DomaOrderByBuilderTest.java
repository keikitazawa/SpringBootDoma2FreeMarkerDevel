/**
 * 
 */
package org.fslabs.springbootdoma2freemarkerdemo.core.config.doma;

import static org.junit.Assert.*;

import org.fslabs.springbootdoma2freemarker.core.util.OrderByBuildUtil;
import org.junit.Test;

/**
 * @author kitaz
 *
 */
public class DomaOrderByBuilderTest {

	@Test
	public final void test() {
		
		// single orderBy for ASC
		OrderByBuildUtil.setOrderBy("id", "asc");
		assertEquals("ORDER BY id ASC", OrderByBuildUtil.getOrderBy());
		
		// single orderBy for DESC
		OrderByBuildUtil.clear();
		OrderByBuildUtil.setOrderBy("id", "dEsc");
		assertEquals("ORDER BY id DESC", OrderByBuildUtil.getOrderBy());
		
		// no parameter
		OrderByBuildUtil.clear();
		assertEquals(null, OrderByBuildUtil.getOrderBy());
		
		// multiple condition
		OrderByBuildUtil.clear();
		OrderByBuildUtil.setOrderBy("id", "desc");
		OrderByBuildUtil.setOrderBy("name", "asc");
		assertEquals("ORDER BY id DESC, name ASC", OrderByBuildUtil.getOrderBy());
		
		// column name in blank
		OrderByBuildUtil.clear();
		OrderByBuildUtil.setOrderBy(";drop databese testdb;", "desc");
		OrderByBuildUtil.setOrderBy("name", "asc");
		assertEquals("ORDER BY name ASC", OrderByBuildUtil.getOrderBy());
	}

}
