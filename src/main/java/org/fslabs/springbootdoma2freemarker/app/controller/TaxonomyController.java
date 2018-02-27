package org.fslabs.springbootdoma2freemarker.app.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.fslabs.springbootdoma2freemarker.app.dto.TaxonomyDto;
import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.fslabs.springbootdoma2freemarker.app.form.TaxonomyAdminSearchForm;
import org.fslabs.springbootdoma2freemarker.app.service.TaxonomyService;
import org.fslabs.springbootdoma2freemarker.core.controller.BaseController;
import org.fslabs.springbootdoma2freemarker.core.entity.DomaPagerEntity;
import org.fslabs.springbootdoma2freemarker.core.util.DomaSelectOptionsUtil;
import org.fslabs.springbootdoma2freemarker.core.util.OrderByUtil;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author kitaz
 */
@Controller
@RequestMapping(value="/admin/taxonomy")
public class TaxonomyController extends BaseController {
	
	private final String SELF_URI_LOCAL = "/admin/taxonomy";
	private final String TERM_URI_LOCAL = "/admin/term";
	
	@Autowired
	private TaxonomyService _ts;

	/**
	 * 表示処理
	 * @param condition
	 * @param model
	 * @return
	 *  ソート設定がある場合のキーワード検索
	 */
	@RequestMapping(value="", method = {RequestMethod.GET, RequestMethod.POST})
	public String index(
			// for Get 他サイトから来た時＆処理後のリダイレクト
//			@RequestParam Map<String, String> q,
			@RequestParam(defaultValue="0") String p,
			@RequestParam(defaultValue="0") String c,
			@RequestParam(defaultValue="0") String d,
			@RequestParam(defaultValue="") String searchKeyword,
			// for Post (キーワード検索(Getでやってる))
			@ModelAttribute(value="searchForm") TaxonomyAdminSearchForm condition,
			Model model
	) {
		/**
		 * 初期表示：デフォルト設定
		 * 検索：クエリストリング
		 * 登録・削除：フォーム（フォームから渡されているか判定する必要がある）
		 */
		// リダイレクトされていない場合はパラメータから取得
		if (!condition.isRedirect()) {
			condition.setP(p);
			condition.setC(c);
			condition.setD(d);
			condition.setSearchKeyword(searchKeyword);
		}
		model = this.getData(condition, model);
		return "admin_taxonomy";
	}
	
	/**
	 * 削除してから表示処理へリダイレクト
	 * @param pageable
	 * @param condition
	 * @param reginput
	 * @param redirectAttributes
	 * @param model
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove(
            @ModelAttribute TaxonomyAdminSearchForm condition,
			RedirectAttributes redirectAttributes, 
			Model model
	) {
		
		condition.setRedirect(true);
		
		Taxonomy target = new Taxonomy();
		target.setId(condition.getId());
		target.setVersion(Long.parseLong(condition.getVersion()));
		_ts.delete(target);
		// redirect
		redirectAttributes.addFlashAttribute("searchForm", condition);
		return "redirect:" + SELF_URI_LOCAL;
	}
	
	/** private **/
	/**
	 * 検索結果の取得
	 * @param pageable
	 * @param form
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private Model getData(TaxonomyAdminSearchForm condition, Model model) {
		// PagerEntity
		DomaPagerEntity domaPagerEntity = new DomaPagerEntity();
		try {
			BeanUtils.copyProperties(domaPagerEntity, condition);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// SelectOptionsの作成
		SelectOptions selectOptions = DomaSelectOptionsUtil.get(domaPagerEntity.getP(), domaPagerEntity.getL());
		// Order Byの作成
		OrderByUtil orderByUtil = new OrderByUtil();
		orderByUtil.buildOrders(condition.getC(), condition.getD(), this.getColumnNames());
		String orderBy = orderByUtil.getOrderBy();
		
		// Serviceに処理を渡す
		TaxonomyDto dto = _ts.searchData(condition.getSearchKeyword(), selectOptions, orderBy);
		
		// map更新
		HashMap<String, Object> map = new HashMap<String, Object>();
		// pager設定
		map = super.setPagerConfigToMap(map, domaPagerEntity, selectOptions.getCount());
		// 条件とDTOを格納
		map.put("condition", condition);
		map.put("taxonomies", dto.getTaxonomies());
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
	public HashMap<String, Object> setAttributeToMap(HashMap<String, Object> map) {
		
		map.put("siteTitle", "タクソノミー管理");
		
		List<String> csss = super.setCsss();
		csss.add("/app/css/taxonomy.css");
		map.put("csss", csss);
		
		List<String> jss = super.setJavaScripts();
		jss.add("/common/js/common.js");
		jss.add("/common/js/__pager.js");
		jss.add("/app/js/admin_taxonomy.js");
		map.put("jss", jss);
		
		// 自身のURI
		map.put("selfUri", SELF_URI_LOCAL);
		map.put("termUri", TERM_URI_LOCAL);
				
		return map;
	}
	
	/**
	 * パラメータからソート順を取得する
	 * @param p チルダ区切りの番号
	 * @return チルダ区切りのカラム名
	 */
	public HashMap<String, String> getColumnNames() {
		HashMap<String, String> ret = new HashMap<String, String>();
		ret.put("0", "weight");
		ret.put("1", "name");
		ret.put("2", "description");
		return ret;
	}
}
