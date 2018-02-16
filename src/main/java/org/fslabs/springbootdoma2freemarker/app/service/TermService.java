package org.fslabs.springbootdoma2freemarker.app.service;

import java.util.List;
import java.util.Objects;

import org.fslabs.springbootdoma2freemarker.app.dao.TermsDao;
import org.fslabs.springbootdoma2freemarker.app.dto.TermDto;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTaxonomy;
import org.fslabs.springbootdoma2freemarker.core.service.BaseService;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermService extends BaseService {
	
	@Autowired
	private TermsDao _tdao;
	
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
}
