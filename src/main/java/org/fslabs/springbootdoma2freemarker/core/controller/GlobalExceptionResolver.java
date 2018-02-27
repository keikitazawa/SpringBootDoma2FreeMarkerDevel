/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * グローバルレベルのエラー出力（error.ftlhに出力する）
 * 
 * @author kitaz
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    
//	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object object,
            Exception ex
    ) {
//        logger.error("例外をキャッチしました。", ex);
        
        ModelAndView mav = new ModelAndView();
 
        // JSPに表示するメッセージをセットします。
        mav.addObject("message", "予期せぬエラーが発生しました。" +
                        " 詳細：【" + ex + "】");
 
        mav.setViewName("error");
        return mav;
	}

}
