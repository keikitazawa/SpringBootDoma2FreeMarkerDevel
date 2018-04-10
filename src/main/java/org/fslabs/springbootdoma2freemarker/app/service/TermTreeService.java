package org.fslabs.springbootdoma2freemarker.app.service;

import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.dao.TermTreesDao;
import org.fslabs.springbootdoma2freemarker.app.dto.TermTreeDto;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTreeTerm;
import org.fslabs.springbootdoma2freemarker.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermTreeService extends BaseService {

	@Autowired
	private TermTreesDao _ttdao;
	
	/**
	 * 親idから従属タームを取得する
	 * @param id
	 * @param options
	 * @return
	 */
	public TermTreeDto selectTerms(String taxonomyId, String parentId){
		String orderBy = "ORDER BY tr.weight ASC";
		List<TermTreeTerm> termTreesTerm = _ttdao.findByParentId(taxonomyId, parentId, orderBy);
		// dto
		TermTreeDto dto = new TermTreeDto();
		dto.setTermTreesTerm(termTreesTerm);
		return dto;
	}
}
