/**
 * 
 */
package org.fslabs.springbootdoma2freemarker.core.config;

/**
 * @author kitaz
 *
 */
public final class AppConf {
	AppConf(){}
	
	/**
	 * ページャ設定
	 * @author kitaz
	 *
	 */
	public static class Pager {
		/**
		 * 件数取得の実施フラグ
		 */
		public static final boolean IsCalcCount = true;
		/**
		 * 表示件数
		 */
		public static final int Limit= 5;
		/**
		 * ページャの表示リンク数
		 */
		public static final int Width = 5;
		/**
		 * ページャの余白
		 */
		public static final int Buffer = 2;
    }
	
	public static class Download {
		
	}
	
	public static class Site {
		
		public static final String URI = "";
	}
	
	public static class Uuid {
		
		public static final String NoData = "00000000-0000-0000-0000-000000000000";
	}
	
	public static class Strings {
		public static final String HalfSpace = " ";
		
		public static final String Asc = "ASC";
		
		public static final String Desc = "DESC";
	}
}
