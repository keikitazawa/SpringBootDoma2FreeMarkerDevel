package org.fslabs.springbootdoma2freemarker.app.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.apache.commons.beanutils.BeanUtils;
import org.fslabs.springbootdoma2freemarker.app.dto.TaxonomyDto;
import org.fslabs.springbootdoma2freemarker.app.entity.Taxonomy;
import org.fslabs.springbootdoma2freemarker.app.form.TaxonomyAdminDetailRegistForm;
import org.fslabs.springbootdoma2freemarker.app.form.TaxonomyAdminSearchForm;
import org.fslabs.springbootdoma2freemarker.app.service.TaxonomyService;
import org.fslabs.springbootdoma2freemarker.core.controller.BaseController;
import org.fslabs.springbootdoma2freemarker.core.controller.BaseControllerInterface;
import org.fslabs.springbootdoma2freemarker.core.entity.ApiResultEntity;
import org.fslabs.springbootdoma2freemarker.core.valid.group.ValidationSequence;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kitaz
 */
@Controller
@RequestMapping(value="/admin/taxonomy_detail")
public class TaxonomyDetailController extends BaseController implements BaseControllerInterface {
	
	private final String SELF_URI_LOCAL = "/admin/taxonomy_detail";
	
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
			@ModelAttribute(value="searchForm") TaxonomyAdminSearchForm condition,
			Model model
	) {
		model = this.getOne(condition, model);
		return "admin_taxonomy_detail";
	}
	
	@RequestMapping(value="/regist", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ApiResultEntity regist(
			@ModelAttribute(value="modalRegistForm") @Validated(ValidationSequence.class) TaxonomyAdminDetailRegistForm condition,
            BindingResult bindingResult,
			Model model
	) {
		
		ApiResultEntity ret = new ApiResultEntity();
		ret.setResult(-1);
		
		// validation
        if (bindingResult.hasErrors()) {
    		ret.setErrors(bindingResult.getAllErrors());
    		return ret;
        }
        
        // regist
		Taxonomy target = new Taxonomy();
		try {
			BeanUtils.copyProperties(target, condition);
			if (target.getId().length() > 0) {
				_ts.update(target);
			}else {
				_ts.insert(target);				
			}
		} catch (IllegalAccessException | InvocationTargetException | SqlExecutionException e) {
			e.printStackTrace();
    		ret.setErrors(bindingResult.getAllErrors());
    		return ret;
   		}
		ret.setResult(0);
		
		return ret;
	}
	

	@RequestMapping(value="/modify", method = RequestMethod.POST)
	@ResponseBody
	public ApiResultEntity modify(
			@ModelAttribute(value="modalRegistForm") @Validated(ValidationSequence.class) TaxonomyAdminDetailRegistForm condition,
            BindingResult bindingResult,
			Model model
	) {
		
		ApiResultEntity ret = new ApiResultEntity();
		ret.setResult(-1);
		
		// validation
        if (bindingResult.hasErrors()) {
    		ret.setErrors(bindingResult.getAllErrors());
    		return ret;
        }
        
        // regist
		Taxonomy target = new Taxonomy();
		try {
			BeanUtils.copyProperties(target, condition);
			_ts.update(target);
		} catch (IllegalAccessException | InvocationTargetException | SqlExecutionException e) {
			e.printStackTrace();
    		ret.setErrors(bindingResult.getAllErrors());
    		return ret;
   		}
		ret.setResult(0);
		
		return ret;
	}
	
//	/**
//	 * 削除してから表示処理へリダイレクト
//	 * @param pageable
//	 * @param condition
//	 * @param reginput
//	 * @param redirectAttributes
//	 * @param model
//	 * @return
//	 * @throws InvocationTargetException 
//	 * @throws IllegalAccessException 
//	 */
//	@RequestMapping(value="/remove", method = RequestMethod.POST)
//	public String remove(
//            @ModelAttribute(value="removeForm") TaxonomyAdminSearchForm condition,
//			RedirectAttributes redirectAttributes, 
//			Model model
//	) {
//		
//		condition.setRedirect(true);
//		
//		Taxonomy target = new Taxonomy();
//		target.setId(condition.getId());
//		try {
//			_ths.delete(target);
//		} catch (SqlExecutionException e) {
//			System.out.println("SqlExecutionException");
//			e.printStackTrace();
//			System.out.println("/SqlExecutionException");
//		} catch (RuntimeException e) {
//			System.out.println("Exeption");
//		}
//		// redirect
//		redirectAttributes.addFlashAttribute("searchForm", condition);
//		return "redirect:" + SELF_URI_LOCAL;
//	}
	
	/** private **/
	/**
	 * １件取得
	 * @param condition
	 * @param model
	 * @return
	 */
	private Model getOne(TaxonomyAdminSearchForm condition, Model model) {
		
		TaxonomyDto dto= new TaxonomyDto();
		// １件検索
		if (Objects.nonNull(condition.getId()) && (condition.getId().trim().length() > 0)) {
			dto = _ts.searchOne(condition.getId());
		}else {
			dto.setTaxonomy(new Taxonomy());
		}
		
		// map更新
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 条件とDTOを格納
		map.put("condition", condition);
		map.put("taxonomy", dto.getTaxonomy());
		map = this.setAttributeToMap(map);
		// model挿入
		model = super.setAttributesToModel(model, map);
		
		return model;
	}
	
	/**
	 * Controller共通で使う設定値を格納する
	 *  →Controller共有するために第２引数以降は自由に設定する
	 *  TODO スーパークラスに持っていけるか検討
	 * @param map
	 * @return
	 */
	public HashMap<String, Object> setAttributeToMap(HashMap<String, Object> map){
		
		map.put("siteTitle", "タクソノミー詳細");
		
		List<String> csss = super.setCsss();
		map.put("csss", csss);
		
		List<String> jss = super.setJavaScripts();
		jss.add("/common/js/common.js");
		jss.add("/app/js/admin_taxonomy_detail.js");
		map.put("jss", jss);
		
		// 自身のURI
		map.put("selfUri", SELF_URI_LOCAL);
				
		return map;
	}
	
	/**
	 * パラメータからソート順を取得する
	 * TODO スーパークラスに持っていけるか検討
	 * @param p カンマ区切りの番号
	 * @return カンマ区切りのカラム名
	 */
	public HashMap<String, String> getColumnNames() {
		HashMap<String, String> ret = new HashMap<String, String>();
		return ret;
	}
}
