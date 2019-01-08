package org.fslabs.springbootdoma2freemarker.core.util;

import org.fslabs.springbootdoma2freemarker.core.config.AppConf;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.data.domain.Pageable;

public class DomaSelectOptionsUtil {

	private static final int defaultPageNumber = 0;
	private static final int defualtLimit = AppConf.Pager.Limit;
	private static final boolean defaultIsCount = AppConf.Pager.IsCalcCount;

//	@Deprecated
    public static SelectOptions get(Pageable pageable, boolean countFlg) {
		return getOptions(pageable.getPageNumber(), pageable.getPageSize(), defaultIsCount);
    }

	/**
	 * ページ数0としてDoma2向けページングオプションを返す
	 * @param count
	 * @return
	 */
	public static  SelectOptions get() {
		return getOptions(defaultPageNumber, defualtLimit, defaultIsCount);
	}

	/**
	 * ページ数から表示件数を規定値のDoma2向けページングオプションを返す
	 * @param count
	 * @return
	 */
	public static  SelectOptions get(int count) {
		return getOptions(count, defualtLimit, defaultIsCount);
	}

	/**
	 * ページ数（0起点)と1ページの表示件数からDoma2向けページングオプションを返す
	 * @param count ページ数
	 * @param limit 1ページの表示件数
	 * @return
	 */
	public static SelectOptions get(int count, int limit) {
		return getOptions(count, limit, defaultIsCount);
	}

    /**
     * ページ数（0起点)と1ページの表示件数・カウント数指定からDoma2向けページングオプションを返す
     * @param count
     * @param limit
     * @param isCount
     * @return
     */
	public static SelectOptions get(int count, int limit, boolean isCount) {
		return getOptions(count, limit, isCount);
	}

    /** private **/
	/**
	 * Doma2のSelectOptionsを作成
	 * @param count
	 * @param limit
	 * @return
	 */
    private static SelectOptions getOptions(int count, int limit, boolean isCount) {
        int offset = count * limit;
   	 	SelectOptions selectOptions;
        if (isCount) {
        	// 全体の件数を取得する：「options.getCount();」でDAO実行後の総件数が取れる
            selectOptions = SelectOptions.get().offset(offset).limit(limit).count();
        }
        else {
            selectOptions = SelectOptions.get().offset(offset).limit(limit);
        }
    	return selectOptions;
    }
}
