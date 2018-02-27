/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.app.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.fslabs.springbootdoma2freemarker.app.dao.TaxonomyDao;
import org.fslabs.springbootdoma2freemarker.app.dto.TaxonomyDto;
import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.fslabs.springbootdoma2freemarker.app.form.TaxonomyAdminDetailRegistForm;
import org.fslabs.springbootdoma2freemarker.core.entity.ApiResultEntity;
import org.fslabs.springbootdoma2freemarker.core.exception.DuplicateException;
import org.fslabs.springbootdoma2freemarker.core.service.BaseService;
import org.seasar.doma.jdbc.SelectOptions;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

/**
 * @author kitaz
 *
 */
@Service
public class TaxonomyService extends BaseService {
	@Autowired
	private TaxonomyDao _tdao;
	
	/**
	 * キーワード検索 Pagerあり
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
	 * カテゴリー一覧を取得する
	 * @param keyword
	 * @param orderBy
	 * @return
	 */
	public TaxonomyDto searchAllData(String keyword){
		// like条件式の作成
		String paramKeyword = null;
		if (Objects.nonNull(keyword) && keyword.length() > 0) {
			StringBuilder sb = new StringBuilder();
			paramKeyword = sb.append("%").append(keyword).append("%").toString();
		}
		// SelectOoptinsとOrderByを作成
		
		// 検索処理
		List<Taxonomy> taxonomies = _tdao.selectByName(paramKeyword);
		// dto
		TaxonomyDto dto = new TaxonomyDto();
		dto.setTaxonomies(taxonomies);
		return dto;
	}
	
	/**
	 * 追加処理
	 * @param taxonomyHeader
	 * @return
	 */
	public void insert(Taxonomy taxonomy) {
		if (Objects.isNull(taxonomy.getId()) || taxonomy.getId().length() == 0) {
			String uuid = UUID.randomUUID().toString();
			taxonomy.setId(uuid);
		}
		_tdao.insert(taxonomy);
	}
	
	/**
	 * 削除処理
	 * @param taxonomyHeader
	 */
	public void delete(Taxonomy taxonomy) {
		// 削除対象のEntityを取得
		Taxonomy target = _tdao.findById(taxonomy.getId());
		_tdao.delete(target);
	}
	
	/**
	 * 更新
	 * @param taxonomyHeader
	 */
	public void update(Taxonomy taxonomy) {
		_tdao.update(taxonomy);
	}
	
	/** logic **/
	/**
	 * カテゴリー名が重複した場合に例外を出すヴァリデーション
	 * @param taxonomy
	 * @throws DuplicateException
	 */
	public void validate(Taxonomy taxonomy) throws DuplicateException {
		if (_tdao.findByName(taxonomy.getName(), taxonomy.getId()) != null) {
			throw new DuplicateException();
		}
	}
		
	/**
	 * トランザクション内での処理
	 */
	@Transactional
	public ApiResultEntity regist(ApiResultEntity ret, TaxonomyAdminDetailRegistForm condition, BindingResult bindingResult) {
		Taxonomy target = new Taxonomy();
		try {
			BeanUtils.copyProperties(target, condition);
			this.validate(target);
			if (target.getId().length() > 0) {
				this.update(target);
			}else {
				this.insert(target);				
			}
			ret.setResult(0);
		} catch (DuplicateException e) {
			String defaultMessage = super.getDefaultMessage("messages.valid.duplicate", new String[]{"記事カテゴリー"});
			bindingResult.rejectValue("name", null, defaultMessage);
    		ret.setErrors(bindingResult.getAllErrors());
		} catch (IllegalAccessException | InvocationTargetException | SqlExecutionException e) {
			e.printStackTrace();
    		ret.setErrors(bindingResult.getAllErrors());
   		}
		return ret;
	}
}
