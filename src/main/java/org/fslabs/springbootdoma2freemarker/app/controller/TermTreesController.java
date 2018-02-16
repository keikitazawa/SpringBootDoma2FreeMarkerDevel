/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fslabs.springbootdoma2freemarker.app.controller;

import java.util.HashMap;

import org.fslabs.springbootdoma2freemarker.app.dto.TermTreeDto;
import org.fslabs.springbootdoma2freemarker.app.form.TermTreeAdminSearchForm;
import org.fslabs.springbootdoma2freemarker.app.form.TermTreeAdminSelectForm;
import org.fslabs.springbootdoma2freemarker.app.service.TermTreeService;
import org.fslabs.springbootdoma2freemarker.core.config.AppConf;
import org.fslabs.springbootdoma2freemarker.core.controller.BaseController;
import org.fslabs.springbootdoma2freemarker.core.util.DomaSelectOptionsUtil;
import org.fslabs.springbootdoma2freemarker.core.util.OrderByBuildUtil;
import org.seasar.doma.jdbc.SelectOptions;
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
	
	/**
	 * 初期表示
	 * @param pageable
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/select", method = {RequestMethod.GET, RequestMethod.POST})
	public String select(
            @ModelAttribute(value="selectTermForm") TermTreeAdminSelectForm condition,
			Model model
	) {
		model = this.selectData(condition, model);
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
		
		// SelectOptionsの作成
		SelectOptions selectOptions = DomaSelectOptionsUtil.get(Integer.valueOf(condition.getP()), condition.getL());
		// Order Byの作成
		String orderBy = OrderByBuildUtil.buildOrderBy(condition.getC(), condition.getD());
		
		// Serviceに処理を渡す
		TermTreeDto dto = _tts.searchData(null, condition.getKeyword(), selectOptions, orderBy);
		
		// map更新
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 条件とDTOを格納
		map.put("condition", condition);
		map.put("taxonomies", dto.getTermTreesTerm());
		
		// pager設定
		map = super.setPagerConfigToMap(map, Integer.valueOf(condition.getP()), selectOptions.getCount(), condition.getL(), AppConf.Pager.Width,  AppConf.Pager.Buffer);
		// site情報の挿入
		map = this.setAttributeToMap(map);
		// model挿入
		model = super.setAttributesToModel(model, map);
		
		return model;
	}
	
	/**
	 * 検索結果の取得
	 * @param pageable
	 * @param form
	 * @return
	 */
	private Model selectData(TermTreeAdminSelectForm condition, Model model){
		
		
		// SelectOptionsの作成
		SelectOptions selectOptions = DomaSelectOptionsUtil.get(Integer.valueOf(condition.getP()), condition.getL());
		// Order Byの作成
		String orderBy = OrderByBuildUtil.buildOrderBy(condition.getC(), condition.getD());
		
		// Serviceに処理を渡す
		TermTreeDto dto = _tts.selectData(condition.getParentId(), selectOptions, orderBy);
		// -> daoを通すとoptions.getCount()が更新される
		
		// map更新
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 条件とdtoを格納
		map.put("condition", condition);
		map.put("taxonomies", dto.getTermTreesTerm());
		
		// pager設定
		map = super.setPagerConfigToMap(map, Integer.valueOf(condition.getP()), selectOptions.getCount(), AppConf.Pager.Limit, AppConf.Pager.Width, AppConf.Pager.Buffer);
		// site情報の挿入
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
		
		map.put("siteTitle", "タクソノミーターム管理");
		
		String[] csss = {};
		String[] jss = {"/app/js/admin_termtree.js"};
		
		map.put("csss", csss);
		map.put("jss", jss);
		
		// 自身のuri
		map.put("selfUri", SELF_URI_LOCAL);
				
		return map;
	}
}
