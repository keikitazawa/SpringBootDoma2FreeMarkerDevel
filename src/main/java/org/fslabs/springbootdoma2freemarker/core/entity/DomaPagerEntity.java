package org.fslabs.springbootdoma2freemarker.core.entity;

import org.fslabs.springbootdoma2freemarker.core.config.AppConf;

/**
 * ページネーションに必要な情報（型変換後）
 * @author kitaz
 *
 */
public class DomaPagerEntity {
	
	// ページング
	/**
	 * offset:表示開始件数:ページ数-1
	 */
	private int p = 0;
	/**
	 * 検索結果の件数
	 */
	private long totalCount = 0;
	/**
	 * １ページの表示件数
	 */
	private int l = AppConf.Pager.Limit;
	/**
	 * ページャの表示リンク数
	 */
	private int width = AppConf.Pager.Width;
	/**
	 * ページャの先頭とカレントページのページ間の余白
	 */
	private int buffer = AppConf.Pager.Buffer;
	/**
	 * 件数をカウントするか
	 */
	private boolean isPagerCalcCount = AppConf.Pager.IsCalcCount;

	/** getter/setter **/
	/**
	 * @return p
	 */
	public int getP() {
		return p;
	}
	/**
	 * @return totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}
	/**
	 * @return l
	 */
	public int getL() {
		return l;
	}
	/**
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @return buffer
	 */
	public int getBuffer() {
		return buffer;
	}
	/**
	 * @return isPagerCalcCount
	 */
	public boolean isPagerCalcCount() {
		return isPagerCalcCount;
	}
	/**
	 * @param p セットする p
	 */
	public void setP(int p) {
		this.p = p;
	}
	/**
	 * @param totalCount セットする totalCount
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @param l セットする l
	 */
	public void setLimit(int l) {
		this.l = l;
	}
	/**
	 * @param width セットする width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @param buffer セットする buffer
	 */
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}
	/**
	 * @param isPagerCalcCount セットする isPagerCalcCount
	 */
	public void setPagerCalcCount(boolean isPagerCalcCount) {
		this.isPagerCalcCount = isPagerCalcCount;
	}
}