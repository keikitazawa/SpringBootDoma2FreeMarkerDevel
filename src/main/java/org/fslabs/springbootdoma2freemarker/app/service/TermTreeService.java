package org.fslabs.springbootdoma2freemarker.app.service;

import java.util.List;
import java.util.Objects;

import org.fslabs.springbootdoma2freemarker.app.dao.TermTreesDao;
import org.fslabs.springbootdoma2freemarker.app.dto.TermTreeDto;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTreeTerm;
import org.fslabs.springbootdoma2freemarker.core.config.AppConf;
import org.fslabs.springbootdoma2freemarker.core.service.BaseService;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermTreeService extends BaseService {

	@Autowired
	private TermTreesDao _ttdao;
	
	public TermTreeDto searchData(String parentId, String keyword, SelectOptions options, String orderBy){
		// like条件式の作成
		String parentUuid = AppConf.Uuid.NoData;
		if (Objects.nonNull(parentId) && parentId.length() > 0) {
			parentUuid = parentId;
		}
		String paramKeyword = null;
		if (Objects.nonNull(keyword) && keyword.length() > 0) {
			StringBuilder sb = new StringBuilder();
			paramKeyword = sb.append("%").append(keyword).append("%").toString();
		}

		List<TermTreeTerm> termTreesTerm = _ttdao.findByKeyword(parentUuid, paramKeyword, options, orderBy);
		
		System.out.println("options.getCount(): " + options.getCount());
		
		// DTO
		TermTreeDto dto = new TermTreeDto();
		dto.setTermTreesTerm(termTreesTerm);
		return dto;
	}
	
	public TermTreeDto selectData(String parentId, SelectOptions options, String orderBy){
		// like条件式の作成
		String parentUuid = AppConf.Uuid.NoData;
		if (Objects.nonNull(parentId) && parentId.length() > 0) {
			parentUuid = parentId;
		}
		
		List<TermTreeTerm> termTreesTerm = _ttdao.findByParentId(parentUuid, options, orderBy);
		// dto
		TermTreeDto dto = new TermTreeDto();
		dto.setTermTreesTerm(termTreesTerm);
		return dto;
	}
}
