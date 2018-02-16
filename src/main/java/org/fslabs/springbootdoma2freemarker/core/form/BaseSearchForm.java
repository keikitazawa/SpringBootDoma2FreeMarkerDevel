/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.core.form;

import org.fslabs.springbootdoma2freemarker.core.config.AppConf;

/**
 * @author kitaz
 * Order By 句を作成するための実装
 */
public class BaseSearchForm {
	
	// ソート
	/**
	 * カンマ区切りによるソート項目名
	 */
	private String c;
	/**
	 * カンマ区切りによるソート方向（ASC/DESC)
	 */
	private String d;
	
	// ページング
	/**
	 * offset:表示開始件数:ページ数-1
	 */
	private String p = "0";
	/**
	 * １ページの表示件数
	 */
	private int l = AppConf.Pager.Limit;
	/**
	 * 件数をカウントするか
	 */
	private boolean isPagerCalcCount = AppConf.Pager.IsCalcCount;
	/**
	 * リダイレクトされてきた場合はtrue
	 * リダイレクトされている場合はformオブジェクトにページャ情報があると判定させる
	 */
	private boolean isRedirect = false;
	
	/** getter/setter **/
	/**
	 * @return c
	 */
	public String getC() {
		return c;
	}
	/**
	 * @return d
	 */
	public String getD() {
		return d;
	}
	/**
	 * @return p
	 */
	public String getP() {
		return p;
	}
	/**
	 * @return l
	 */
	public int getL() {
		return l;
	}
	/**
	 * @return isPagerCalcCount
	 */
	public boolean isPagerCalcCount() {
		return isPagerCalcCount;
	}
	/**
	 * @return isRedirect
	 */
	public boolean isRedirect() {
		return isRedirect;
	}
	/**
	 * @param c セットする c
	 */
	public void setC(String c) {
		this.c = c;
	}
	/**
	 * @param d セットする d
	 */
	public void setD(String d) {
		this.d = d;
	}
	/**
	 * @param p セットする p
	 */
	public void setP(String p) {
		this.p = p;
	}
	/**
	 * @param l セットする l
	 */
	public void setL(int l) {
		this.l = l;
	}
	/**
	 * @param isPagerCalcCount セットする isPagerCalcCount
	 */
	public void setPagerCalcCount(boolean isPagerCalcCount) {
		this.isPagerCalcCount = isPagerCalcCount;
	}
	/**
	 * @param isRedirect セットする isRedirect
	 */
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
