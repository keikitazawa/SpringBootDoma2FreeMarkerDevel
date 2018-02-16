package org.fslabs.springbootdoma2freemarker.app.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.fslabs.springbootdoma2freemarker.app.dto.TaxonomyDto;
import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.fslabs.springbootdoma2freemarker.app.form.TaxonomyAdminSearchForm;
import org.fslabs.springbootdoma2freemarker.app.service.TaxonomyService;
import org.fslabs.springbootdoma2freemarker.core.controller.BaseController;
import org.fslabs.springbootdoma2freemarker.core.controller.BaseControllerInterface;
import org.fslabs.springbootdoma2freemarker.core.entity.DomaPagerEntity;
import org.fslabs.springbootdoma2freemarker.core.util.DomaSelectOptionsUtil;
import org.fslabs.springbootdoma2freemarker.core.util.OrderByUtil;
import org.fslabs.springbootdoma2freemarker.core.valid.group.ValidationSequence;
import org.seasar.doma.jdbc.SelectOptions;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
public class TaxonomyController extends BaseController implements BaseControllerInterface {
	
	private final String SELF_URI_LOCAL = "/admin/taxonomy";
	
	@Autowired
	private TaxonomyService _ths;

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
			@RequestParam Map<String, String> q,
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
	 * 登録してから表示処理へリダイレクト
	 * @param condition
	 * @param reginput
	 * @param redirectAttributes
	 * @param model
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	public String regist(
			@ModelAttribute(value="registForm") @Validated(ValidationSequence.class) TaxonomyAdminSearchForm condition,
            BindingResult bindingResult,
			RedirectAttributes redirectAttributes, 
			Model model
	) {
		
		condition.setRedirect(true);
		redirectAttributes.addFlashAttribute("searchForm", condition);
		
		// validation
        if (bindingResult.hasErrors()) {
    	    redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
    		return "redirect:" + SELF_URI_LOCAL;
        }
        
        // regist
		Taxonomy target = new Taxonomy();
		try {
			BeanUtils.copyProperties(target, condition);
			_ths.insert(target);
		} catch (IllegalAccessException | InvocationTargetException | SqlExecutionException e) {
			e.printStackTrace();
    	    redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
    		return "redirect:" + SELF_URI_LOCAL;
		}
		
		// 正常終了は入力項目を消す
		condition.setName("");
		condition.setDescription("");
		condition.setWeight("");
		redirectAttributes.addFlashAttribute("searchForm", condition);
		return "redirect:" + SELF_URI_LOCAL;
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
            @ModelAttribute(value="removeForm") TaxonomyAdminSearchForm condition,
			RedirectAttributes redirectAttributes, 
			Model model
	) {
		
		condition.setRedirect(true);
		
		Taxonomy target = new Taxonomy();
		target.setId(condition.getId());
		try {
			_ths.delete(target);
		} catch (SqlExecutionException e) {
			System.out.println("SqlExecutionException");
			e.printStackTrace();
			System.out.println("/SqlExecutionException");
		} catch (RuntimeException e) {
			System.out.println("Exeption");
		}
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
		TaxonomyDto dto = _ths.searchData(condition.getSearchKeyword(), selectOptions, orderBy);
		
		// map更新
		HashMap<String, Object> map = new HashMap<String, Object>();
		// pager設定
		map = super.setPagerConfigToMap(map, domaPagerEntity, selectOptions.getCount());
		// 条件とDTOを格納
		map.put("condition", condition);
		map.put("taxonomyHeaders", dto.getTaxonomies());
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
	public HashMap<String, Object> setAttributeToMap(HashMap<String, Object> map){
		
		map.put("siteTitle", "タクソノミー管理");
		
		List<String> csss = new ArrayList<String>();
		csss.add("/app/css/taxonomy.css");
		map.put("csss", csss);
		
		List<String> jss = new ArrayList<String>();
		jss.add("/common/js/common.js");
		jss.add("/common/js/__pager.js");
		jss.add("/app/js/taxonomy.js");		
		map.put("jss", jss);
		
		// 自身のURI
		map.put("selfUri", SELF_URI_LOCAL);
				
		return map;
	}
	
	/**
	 * パラメータからソート順を取得する
	 * @param p カンマ区切りの番号
	 * @return カンマ区切りのカラム名
	 */
	public HashMap<String, String> getColumnNames() {
		HashMap<String, String> ret = new HashMap<String, String>();
		ret.put("0", "weight");
		ret.put("1", "name");
		ret.put("2", "description");
		return ret;
	}
}
