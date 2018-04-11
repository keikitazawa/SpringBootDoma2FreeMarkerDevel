package org.fslabs.springbootdoma2freemarker.app.controller;

import java.util.HashMap;
import java.util.List;

import org.fslabs.springbootdoma2freemarker.app.dto.TermTreeDto;
import org.fslabs.springbootdoma2freemarker.app.form.TermTreeAdminSearchForm;
import org.fslabs.springbootdoma2freemarker.app.service.TermTreeService;
import org.fslabs.springbootdoma2freemarker.core.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kitaz
 */
@Controller
@RequestMapping(value="/admin/termtree")
public class TermTreesController extends BaseController {
	
	private final String SELF_URI_LOCAL = "/admin/termtree";
	
	@Autowired
	private TermTreeService _tts;
	
	/**
	 * 初期表示
	 * @param pageable
	 * @param model
	 * @return
	 */
	@RequestMapping(value="", method = {RequestMethod.GET, RequestMethod.POST})
	public String index(
            @ModelAttribute(value="searchForm") TermTreeAdminSearchForm condition,
            Model model
	) {
		model = this.getData(condition, model);		
		return "admin_termtree";
	}
	
	
	
	/** private **/
	/**
	 * 検索結果の取得
	 * @param pageable
	 * @param form
	 * @return
	 */
	private Model getData(TermTreeAdminSearchForm condition, Model model){
		
		// Serviceに処理を渡す
//		TermTreeDto dto = _tts.selectTerms(condition.getTaxonomyId(), condition.getParentId());
		TermTreeDto dto = _tts.getAllTerms(condition.getTaxonomyId());
		
		// map更新
		HashMap<String, Object> map = new HashMap<String, Object>();

		// 条件とDTOを格納
		map.put("condition", condition);
//		map.put("taxonomies", dto.getTermTreesTerm());
		map.put("termTrees", dto.getTermTreeList());
		map = this.setAttributeToMap(map);
		// model挿入
		model = super.setAttributesToModel(model, map);
		
		return model;
	}
	

	
	/**
	 * Controller共通で使う設定値を格納する
	 *  →Controller共有するために第２引数以降は自由に設定する
	 * @param map
	 * @return
	 */
	private HashMap<String, Object> setAttributeToMap(HashMap<String, Object> map){
		
		map.put("siteTitle", "タクソノミー階層管理");
		
		List<String> csss = super.setCsss();
		csss.add("/app/css/taxonomy.css");
		map.put("csss", csss);
		
		List<String> jss = super.setJavaScripts();
		jss.add("/common/js/common.js");
		jss.add("/common/js/__pager.js");
		jss.add("/app/js/admin_termtree.js");
		map.put("jss", jss);
		
		// 自身のuri
		map.put("selfUri", SELF_URI_LOCAL);
				
		return map;
	}
	
	/**
	 * パラメータからソート順を取得する
	 * @param p チルダ区切りの番号
	 * @return チルダ区切りのカラム名
	 */
	public HashMap<String, String> getColumnNames() {
		HashMap<String, String> ret = new HashMap<String, String>();
		ret.put("0", "tr.weight");
		ret.put("1", "tx.name");
		return ret;
	}
}
