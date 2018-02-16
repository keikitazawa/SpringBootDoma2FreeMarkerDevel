/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.core.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.fslabs.springbootdoma2freemarker.core.entity.DomaPagerEntity;
import org.springframework.ui.Model;

/**
 * @author kitaz
 *
 */
public class BaseController {
	
	/** template側操作 **/
	/**
	 * pager情報の取り込み
	 * @param map model用のmap
	 * @param pageNumber 表示するページ数（０起点）
	 * @param totalCount 検索結果の件数
	 * @param limit １ページに表示する件数
	 * @param width ページャーのリンク数
	 * @param buffer ページャの余白
	 * @return
	 */
	@Deprecated
	protected HashMap<String, Object> setPagerConfigToMap(
			HashMap<String, Object> map, 
			int pageNumber,
			long totalCount,
			int limit,
			int width,
			int buffer
	){
		// map更新
		map.put("pager_pageNumber", pageNumber);
		map.put("pager_totalCount", totalCount);
		map.put("pager_limit", limit);
		map.put("pager_width", width);
		map.put("pager_buffer", buffer);
		return map;
	}
	/**
	 * 
	 * @param map
	 * @param domaPagerEntity
	 * @return
	 */
	protected HashMap<String, Object> setPagerConfigToMap(
			HashMap<String, Object> map, 
			DomaPagerEntity domaPagerEntity,
			long totalCount
			
	){
		// map更新
		map.put("pager_pageNumber", domaPagerEntity.getP());
		map.put("pager_totalCount", totalCount);
		map.put("pager_limit", domaPagerEntity.getL());
		map.put("pager_width", domaPagerEntity.getWidth());
		map.put("pager_buffer", domaPagerEntity.getBuffer());
		return map;
	}
	/**
	 * 共有jsの取り込み
	 * @return
	 */
	protected List<String> setJavaScripts() {
		List<String> ret = new ArrayList<String>(); 
		return ret;
	}
	
	/**
	 * 共有cssの取り込み
	 * @return
	 */
	protected List<String> setCsss(){
		List<String> ret = new ArrayList<String>(); 
		ret.add("/bootstrap/css/bootstrap.min.css");
		return ret;
	}
	
	/**
	 * modelにテンプレート用の属性を一括設置する
	 * @param model
	 * @param map
	 * @return
	 */
	protected Model setAttributesToModel(Model model, HashMap<String, Object> map) {
		model.addAllAttributes(map);
		return model;
	}
}
