package org.fslabs.springbootdoma2freemarker.app.service;

import java.util.ArrayList;
import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.dao.TermTreesDao;
import org.fslabs.springbootdoma2freemarker.app.dto.TermTreeDto;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTreeListEntity;
import org.fslabs.springbootdoma2freemarker.app.entity.TermTreeTerm;
import org.fslabs.springbootdoma2freemarker.core.config.AppConf;
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
	
	public TermTreeDto getAllTerms(String taxonomyId){
		List<TermTreeListEntity> ret = new ArrayList<>();
		String parentId = AppConf.Uuid.NoData;
		// 第１階層を取得
		int level = 1;
		List<TermTreeTerm> currentList = this.getChildTerms(taxonomyId, parentId);
		for (TermTreeTerm tl : currentList) {
			TermTreeListEntity t = new TermTreeListEntity();
			t.setId(tl.getId());
			t.setLevel(level);
			t.setTaxonomyId(taxonomyId);
			ret.add(t);
		}
		// 第２階層以降
		for (;;) {
			List<TermTreeListEntity> tmpRet = new ArrayList<>();
			level++;
			boolean isExist = false;
			
			for (TermTreeListEntity ttle : ret) {
				if (ttle.isSearch()) {
					TermTreeListEntity t = new TermTreeListEntity();
					t.setId(ttle.getId());
					t.setLevel(ttle.getLevel());
					t.setTaxonomyId(taxonomyId);
					t.setSearch(true);
					tmpRet.add(t);
				}else {
					isExist = true;
					
					TermTreeListEntity t = new TermTreeListEntity();
					t.setId(ttle.getId());
					t.setLevel(ttle.getLevel());
					t.setTaxonomyId(taxonomyId);
					t.setSearch(true);
					tmpRet.add(t);
					
					List<TermTreeTerm> tmp = this.getChildTerms(ttle.getTaxonomyId(), ttle.getId());
					for (TermTreeTerm ttt : tmp) {
						TermTreeListEntity t2 = new TermTreeListEntity();
						t2.setId(ttt.getId());
						t2.setLevel(level);
						t2.setTaxonomyId(taxonomyId);
						t2.setSearch(false);
						tmpRet.add(t2);
					}
				}
			}
			ret = tmpRet;
			if (!isExist) {
				break;
			}
		}
		TermTreeDto dto = new TermTreeDto();
		dto.setTermTreeList(ret);
		return dto;
	}	
	
	private List<TermTreeTerm> getChildTerms(String taxonomyId, String parentId){
		String orderBy = "ORDER BY tr.weight ASC";
		return _ttdao.findByParentId(taxonomyId, parentId, orderBy);
	}
}
