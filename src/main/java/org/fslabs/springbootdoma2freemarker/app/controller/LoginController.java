package org.fslabs.springbootdoma2freemarker.app.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.fslabs.springbootdoma2freemarker.core.controller.BaseController;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController extends BaseController {
	
	HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String main(String loginError, Model model, HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("topuri", "");
		map.put("username", "");
		map.put("password", "");
		map.put("loginError", loginError);
		map.put("default_password", BCrypt.hashpw("default_password", BCrypt.gensalt()));
		map.put("demo_password", BCrypt.hashpw("demo", BCrypt.gensalt()));
		
		// Controller～model一括挿入
		map = this.setAttributeToMap(map, request);
		model = super.setAttributesToModel(model, map);
		
		return "login";
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public String mainPost(String loginError, Model model, HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("topuri", "");
		map.put("username", "");
		map.put("password", "");
		map.put("loginError", loginError);
		map.put("default_password", BCrypt.hashpw("default_password", BCrypt.gensalt()));
		map.put("demo_password", BCrypt.hashpw("demo", BCrypt.gensalt()));
		
		// Controller～model一括挿入
		map = this.setAttributeToMap(map, request);
		model = super.setAttributesToModel(model, map);
		
		return "login";
	}
	
	/**
	 * Controller共通で使う設定値を格納する
	 *  →Controller共有するために第２引数以降は自由に設定する
	 * @param map
	 * @return
	 */
	private HashMap<String, Object> setAttributeToMap(
		HashMap<String, Object> map, 
		HttpServletRequest request) {
		
		map.put("siteTitle", "ログイン");
		
		String[] csss = {};
		String[] jss = {"/app/js/login.js"};
		
		map.put("csss", csss);
		map.put("jss", jss);

		return map;
	}
}
