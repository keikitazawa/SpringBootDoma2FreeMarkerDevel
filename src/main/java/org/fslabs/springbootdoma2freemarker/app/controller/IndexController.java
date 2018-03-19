package org.fslabs.springbootdoma2freemarker.app.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.fslabs.springbootdoma2freemarker.core.controller.BaseController;
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
@RequestMapping(value = "/")
public class IndexController extends BaseController {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String main(Model model, HttpServletRequest request) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", 10);
		map.put("keyword", "a@a.com");
		map.put("password", "a@a.com");
		map.put("name", "(￣д￣)ｴｰ");
		map.put("teststring", "<!-- test -->");
		
		map.put("uuid", UUID.randomUUID());
		
		// Controller
		map = this.setAttributeToMap(map, request);
		// Controller～model一括挿入
		model = super.setAttributesToModel(model, map);
		
	    return "index";
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	private HashMap<String, Object> setAttributeToMap(
		HashMap<String, Object> map, 
		HttpServletRequest request) {
		
		map.put("siteTitle", "テスト用トップページ");
		
		map.put("sessionid", request.getSession().getId());
		map.put("lastaccessedtime", request.getSession().getLastAccessedTime());
		map.put("viewtime", sdf.format(request.getSession().getLastAccessedTime()));

		map.put("localurl", request.getRequestURL());
		map.put("localuri", request.getRequestURI());

		List<String> csss = super.setCsss();;
		map.put("csss", csss);
		
		List<String> jss = super.setJavaScripts();
		jss.add("/common/js/common.js");
		jss.add("/common/js/__pager.js");
		jss.add("/common/js/menu.js");
		map.put("jss", jss);
		
		
		map.put("ee", "(￣д￣)ｴｰ");
		return map;
	}
}
