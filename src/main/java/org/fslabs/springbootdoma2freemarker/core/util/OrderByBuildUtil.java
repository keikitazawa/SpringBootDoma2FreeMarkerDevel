package org.fslabs.springbootdoma2freemarker.core.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fslabs.springbootdoma2freemarker.core.config.AppConf;


/**
 * OrderBy句の作成
 * @author kitaz
 *
 */
@Deprecated
public class OrderByBuildUtil {
	/**
	 * DESCの正規表現
	 */
	private static final String DIRECTION_REGEXP = "^DESC$";
	private static final Pattern pattern = Pattern.compile(DIRECTION_REGEXP, Pattern.CASE_INSENSITIVE);
	/**
	 * OrderBy句のためのLinkedHashMap
	 */
	private static LinkedHashMap<String, String> orders = new LinkedHashMap<String, String>();
	/**
	 * OrderBｙ句における不正な文字
	 */
	private static final Pattern invalidPattern = Pattern.compile("\\s");
	
	/** for Pagination parameter **/
	/**
	 * パラメータのカンマ区切りから作成
	 * @param sortColumns
	 * @param sortDirection
	 * @return
	 */
	public static String buildOrderBy(String sortColumns, String sortDirection) {
		String[] columnsArray;
		String[] directionsArray;
		String orderBy = null;
		try {
			columnsArray = sortColumns.split("\\s{0,}~\\s{0,}", -1);
			directionsArray = sortDirection.split("\\s{0,}~\\s{0,}", -1);
			int minArray = columnsArray.length > directionsArray.length ? directionsArray.length : columnsArray.length;
			
			for (int i = 0; i < minArray; i++) {
				setOrderBy(columnsArray[i], directionsArray[i]);
			}
			orderBy = getOrderBy();
		} catch (Exception e) {
			// 文字列がnullの場合はNullPointerExceptionを吐くのでnullのまま（Doma2としてnullはwhere文字自身を非生成扱い）
			e.printStackTrace();
		}
		return orderBy;
	}
	
	/**
	 * 順番にOrderByを作成する
	 * @param column
	 * @param direction
	 */
	public static void setOrderBy(String column, String direction) {
		// SQL Injection対策
		Matcher m = invalidPattern.matcher(column);
		// 半角スペースが存在しない場合のみ許可
		if (m.find() == false) {
			orders.put(column, direction);
		}
	}
	/**
	 * Serviceで作られたOrderBy文字列を返す
	 * @return
	 */
	public static String getOrderBy(){
		return build();
	}
	
	public static void clear() {
		orders = new LinkedHashMap<String, String>();
	}
	/** private **/
	/**
	 * order by 句を返す（LinkedHashMapで順番を保持）
	 * @param LinkedHashMap orders<column, asc or desc>
	 * @return
	 */
	private static String build() {
		
		String ret = null;
		
		// LinkedHashMapが存在する場合は無条件でOrderByを作る
		if (Objects.nonNull(orders) && orders.size() > 0) {
			
			List<String> orderBy = new ArrayList<String>();
			
			for (Map.Entry<String, String> a : orders.entrySet()) {
				
				String column = a.getKey();
				String direction = a.getValue();
				
				// columnが存在する場合はOrderBy句の対象とみなす
				if (column.length() > 0) {
					StringBuilder sb = new StringBuilder();
					
					// 明示的にDESC宣言のみDESC扱い
					if (pattern.matcher(direction).matches()) {
						sb.append(column);
						sb.append(AppConf.Strings.HalfSpace);
						sb.append(AppConf.Strings.Desc);
					// それ以外はASC
					}else {
						sb.append(column);
						sb.append(AppConf.Strings.HalfSpace);
						sb.append(AppConf.Strings.Asc);
					}
					orderBy.add(sb.toString());
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("ORDER BY ");
			sb.append(String.join(", ", orderBy));
			ret = sb.toString();
		}
		return ret;
	}
}
