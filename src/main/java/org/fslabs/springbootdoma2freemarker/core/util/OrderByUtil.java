package org.fslabs.springbootdoma2freemarker.core.util;

import java.util.ArrayList;
import java.util.HashMap;
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
public class OrderByUtil {
	/**
	 * ASC/DESC
	 */
	private HashMap<String, String> directions = new HashMap<String, String>(); 
	
	/**
	 * OrderBy句のためのLinkedHashMap
	 */
	private LinkedHashMap<String, String> orders = new LinkedHashMap<String, String>();
	/**
	 * OrderBｙ句における不正な文字
	 */
	private static final Pattern invalidPattern = Pattern.compile("\\s");
	
	/**
	 * コンストラクタ
	 */
	public OrderByUtil() {
		this.directions.put("0", "ASC");
		this.directions.put("1", "DESC");
	}
	
	/** for Pagination parameter **/
	/**
	 * パラメータのチルダ区切りから作成
	 * @param sortColumns
	 * @param sortDirection
	 * @return
	 */
	public String buildOrders(String sortColumns, String sortDirection, HashMap<String, String> targetColumns) {
		String[] columnsArray;
		String[] directionsArray;
		String orderBy = null;
		try {
			columnsArray = sortColumns.split("\\s{0,}~\\s{0,}", -1);
			directionsArray = sortDirection.split("\\s{0,}~\\s{0,}", -1);
			int minArray = columnsArray.length > directionsArray.length ? directionsArray.length : columnsArray.length;
			
			for (int i = 0; i < minArray; i++) {
				String column = targetColumns.get(columnsArray[i]);
				String direction = this.directions.get(directionsArray[i]);
				if (Objects.isNull(direction)) {
					direction = this.directions.get("0");
				}
				if (Objects.nonNull(column) && Objects.nonNull(direction)) {
					this.setOrderBy(column, direction);
				}
			}
			orderBy = this.getOrderBy();
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
	public void setOrderBy(String column, String direction) {
		// SQL Injection対策
		Matcher m = invalidPattern.matcher(column);
		// OrderBy句
		
		// 半角スペースが存在しない場合のみ許可
		if (!m.find()) {
			this.orders.put(column, direction);
		}
	}
	/**
	 * Serviceで作られたOrderBy文字列を返す
	 * @return
	 */
	public String getOrderBy(){
		return this.build();
	}
	
	/** private **/
	/**
	 * order by 句を返す（LinkedHashMapで順番を保持）
	 * @param LinkedHashMap orders<column, ASC or DESC>
	 * @return
	 */
	private String build() {
		
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
					sb.append(column);
					sb.append(AppConf.Strings.HalfSpace);
					sb.append(direction);
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
