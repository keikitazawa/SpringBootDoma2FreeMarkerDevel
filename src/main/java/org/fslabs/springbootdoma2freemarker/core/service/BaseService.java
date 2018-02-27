/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.core.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * @author kitaz
 *
 */
public class BaseService {
	@Autowired
	private MessageSource messageSource;
	/**
	 * errorCodeをキーとしてメッセージソースからメッセージを取得
	 * @param errorCode キー
	 * @param params {0}などのプレースホルダーに入れる値
	 * @return
	 */
	public String getDefaultMessage(String errorCode, Object[] params) {
		return messageSource.getMessage(errorCode, params, Locale.getDefault());
	}
}
