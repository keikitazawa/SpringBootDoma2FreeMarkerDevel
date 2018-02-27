package org.fslabs.springbootdoma2freemarker.app.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.fslabs.springbootdoma2freemarker.core.controller.BaseController;
import org.fslabs.springbootdoma2freemarker.core.controller.BaseControllerInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author kitaz
 *
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController implements BaseControllerInterface {
	
	private final String SELF_URI_LOCAL = "/menu";
	
	@RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model, HttpServletRequest request) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// Controller
//		map = this.setAttributeToMap(map, request);
		map = this.setAttributeToMap(map);
		// Controller～model一括挿入
		model = super.setAttributesToModel(model, map);
		
		return "menu";
	}
	
//	/**
//	 * 
//	 * @param map
//	 * @return
//	 */
//	private HashMap<String, Object> setAttributeToMap(
//		HashMap<String, Object> map, 
//		HttpServletRequest request
//	) {
//		
//		map.put("siteTitle", "テスト用メニューページ");
//		
//		map.put("sessionid", request.getSession().getId());
//		map.put("lastaccessedtime", request.getSession().getLastAccessedTime());
//		map.put("viewtime", sdf.format(request.getSession().getLastAccessedTime()));
//
//		map.put("localurl", request.getRequestURL());
//		map.put("localuri", request.getRequestURI());
//		
//		return map;
//	}


	@Override
	public HashMap<String, Object> setAttributeToMap(HashMap<String, Object> map) {
		map.put("siteTitle", "タクソノミー管理");
		
		List<String> csss = super.setCsss();
		map.put("csss", csss);
		
		List<String> jss = super.setJavaScripts();
		jss.add("/common/js/common.js");
		map.put("jss", jss);
		
		// 自身のURI
		map.put("selfUri", SELF_URI_LOCAL);
				
		return map;
	}


	@Override
	public HashMap<String, String> getColumnNames() {
		HashMap<String, String> ret = new HashMap<String, String>();
		return ret;
	}
}
