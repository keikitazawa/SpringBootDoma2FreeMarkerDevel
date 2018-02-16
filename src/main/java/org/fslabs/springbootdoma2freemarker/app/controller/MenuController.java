package org.fslabs.springbootdoma2freemarker.app.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;

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
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
	@RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model, HttpServletRequest request) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// Controller
		map = this.setAttributeToMap(map, request);
		// Controller～model一括挿入
		model = super.setAttributesToModel(model, map);
		
		return "menu";
	}
	
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	private HashMap<String, Object> setAttributeToMap(
		HashMap<String, Object> map, 
		HttpServletRequest request) {
		
		map.put("siteTitle", "テスト用メニューページ");
		
		map.put("sessionid", request.getSession().getId());
		map.put("lastaccessedtime", request.getSession().getLastAccessedTime());
		map.put("viewtime", sdf.format(request.getSession().getLastAccessedTime()));

		map.put("localurl", request.getRequestURL());
		map.put("localuri", request.getRequestURI());
		
		String[] csss = {"/app/css/hoge.css", "/app/css/fuga.css"};
		String[] jss = {"/app/js/are.js", "/app/js/k0ore.js"};
		
		map.put("csss", csss);
		map.put("jss", jss);
		
		return map;
	}
}
