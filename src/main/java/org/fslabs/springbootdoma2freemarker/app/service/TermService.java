package org.fslabs.springbootdoma2freemarker.app.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.fslabs.springbootdoma2freemarker.app.dao.TermDao;
import org.fslabs.springbootdoma2freemarker.app.dto.TermDto;
import org.fslabs.springbootdoma2freemarker.app.entity.Term;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTaxonomy;
import org.fslabs.springbootdoma2freemarker.app.form.TermAdminDetailRegistForm;
import org.fslabs.springbootdoma2freemarker.core.entity.ApiResultEntity;
import org.fslabs.springbootdoma2freemarker.core.exception.DuplicateException;
import org.fslabs.springbootdoma2freemarker.core.service.BaseService;
import org.seasar.doma.jdbc.SelectOptions;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
public class TermService extends BaseService {
	
	@Autowired
	private TermDao _tdao;
	
	public TermDto searchData(String parentId, String keyword, SelectOptions options, String orderBy){
		
		// like条件式の作成
		String paramKeyword = null;
		if (Objects.nonNull(keyword) && keyword.length() > 0) {
			StringBuilder sb = new StringBuilder();
			paramKeyword = sb.append("%").append(keyword).append("%").toString();
		}
		
		List<TermTaxonomy> termsTaxonomy = _tdao.findByKeywordForInfo(parentId, paramKeyword, options, orderBy);
		// DTO
		TermDto dto = new TermDto();
		dto.setTaxonomyInfo(termsTaxonomy);
		return dto;
	}
	
	/**
	 * １件取得
	 * @param id
	 * @return
	 */
	public TermDto searchOne(String id) {
		
		Term term = _tdao.findById(id);
		// dto
		TermDto dto = new TermDto();
		dto.setTerm(term);
		return dto;
	}
	
	/**
	 * 追加処理
	 * @param taxonomyHeader
	 * @return
	 */
	public void insert(Term term) {
		if (Objects.isNull(term.getId()) || term.getId().length() == 0) {
			String uuid = UUID.randomUUID().toString();
			term.setId(uuid);
		}
		_tdao.insert(term);
	}
	
	/**
	 * 削除処理
	 * @param taxonomyHeader
	 */
	@Transactional
	public void delete(Term term) throws IllegalAccessException, InvocationTargetException, SqlExecutionException {
		Term target = new Term();
		BeanUtils.copyProperties(target, term);
		_tdao.delete(target);
	}
	
	/**
	 * 更新
	 * @param taxonomyHeader
	 */
	public void update(Term term) {
		_tdao.update(term);
	}
	
	/** logic **/
	/**
	 * カテゴリー名＋名称が重複した場合に例外を出すヴァリデーション
	 * @param taxonomy
	 * @throws DuplicateException
	 */
	public void validate(Term term) throws DuplicateException {
		if (_tdao.findByName(term.getParentId(), term.getName(), term.getId()) != null) {
			throw new DuplicateException();
		}
	}
		
	/**
	 * トランザクション内での処理
	 */
	@Transactional
	public ApiResultEntity regist(ApiResultEntity ret, TermAdminDetailRegistForm condition, BindingResult bindingResult) {
		// リターンコードの指定
//		ret.setResult(-1);
		Term target = new Term();
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
			String defaultMessage = super.getDefaultMessage("messages.valid.duplicate", new String[]{"名称"});
			bindingResult.rejectValue("name", null, defaultMessage);
    		ret.setErrors(bindingResult.getAllErrors());
		} catch (IllegalAccessException | InvocationTargetException | SqlExecutionException e) {
			e.printStackTrace();
    		ret.setErrors(bindingResult.getAllErrors());
   		}
		return ret;
	}
}
