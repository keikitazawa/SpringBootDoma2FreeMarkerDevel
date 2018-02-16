/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.fslabs.springbootdoma2freemarker.app.dao.TaxonomyDao;
import org.fslabs.springbootdoma2freemarker.app.dto.TaxonomyDto;
import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.fslabs.springbootdoma2freemarker.core.service.BaseService;
import org.seasar.doma.jdbc.SelectOptions;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kitaz
 *
 */
@Service
public class TaxonomyService extends BaseService {
	@Autowired
	private TaxonomyDao _tdao;
	
	/**
	 * キーワード検索
	 * @param keyword
	 * @param options
	 * @return
	 */
	public TaxonomyDto searchData(String keyword, SelectOptions options, String orderBy){
		
		// like条件式の作成
		String paramKeyword = null;
		if (Objects.nonNull(keyword) && keyword.length() > 0) {
			StringBuilder sb = new StringBuilder();
			paramKeyword = sb.append("%").append(keyword).append("%").toString();
		}
		// SelectOoptinsとOrderByを作成
		
		// 検索処理
		List<Taxonomy> taxonomies = _tdao.findByKeyword(paramKeyword, options, orderBy);
		
		// dto
		TaxonomyDto dto = new TaxonomyDto();
		dto.setTaxonomies(taxonomies);
		return dto;
	}
	
	/**
	 * １件取得
	 * @param id
	 * @return
	 */
	public TaxonomyDto searchOne(String id) {
		
		Taxonomy taxonomy = _tdao.findById(id);
		// dto
		TaxonomyDto dto = new TaxonomyDto();
		dto.setTaxonomy(taxonomy);
		return dto;
	}
	
	/**
	 * 追加処理
	 * @param taxonomyHeader
	 * @return
	 */
	@Transactional
	public void insert(Taxonomy taxonomy) throws SqlExecutionException, RuntimeException {
		
		if (Objects.isNull(taxonomy.getId()) || taxonomy.getId().length() == 0) {
			String uuid = UUID.randomUUID().toString();
			taxonomy.setId(uuid);
		}
		
//		taxonomyHeader.setModified(new Timestamp(System.currentTimeMillis()));
//		try {
			_tdao.insert(taxonomy);
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 削除処理
	 * @param taxonomyHeader
	 */
	@Transactional
	public void delete(Taxonomy taxonomyHeader) /*throws SqlExecutionException, RuntimeException*/ {
		// 削除対象のEntityを取得
		Taxonomy target = _tdao.findById(taxonomyHeader.getId());
		try {
			_tdao.delete(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新
	 * @param taxonomyHeader
	 */
	public void update(Taxonomy taxonomyHeader) {
		
		_tdao.update(taxonomyHeader);
	}
}
