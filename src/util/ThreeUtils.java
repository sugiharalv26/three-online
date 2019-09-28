package util;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeUtils {

	/**
	 * 全角/半角ごとにキーワード分割、リストで返却
	 * @param keyword キーワード
	 * @return リスト
	 */
	public static List<String> createKeyword(String keyword) {
		if (keyword == null || "".equals(keyword)) {
			return Collections.emptyList();
		}
		keyword = keyword.replaceAll("　", " ");
		List<String> keywords = Arrays.asList(keyword.split(" "));
		return keywords.stream()
				.filter(word -> !isEmpty(word))
				.collect(Collectors.toList());
	}

	/**
	 * 文字列の空チェック
	 * @param str チェック対象文字列
	 * @return チェック結果 true:空
	 */
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str));
	}

	/**
	 * リストの空チェック
	 * @param list チェック対象リスト
	 * @return チェック結果 true:空
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List list) {
		return (list == null || list.size() < 1);
	}

	/**
	 * model毎の比較
	 * @param model1 比較対象1
	 * @param model2 比較対象2
	 * @return チェック結果 true:一致
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean modelMatch(Object model1, Object model2) {
		if (model1 == null || model2 == null) {
			return false;
		}

		Class clazz1 = model1.getClass();
		Class clazz2 = model2.getClass();

		if (!clazz1.getName().equals(clazz2.getName())) {
			return false;
		}
		boolean flg = true;
		try {

			Field[] fields = clazz1.getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				String getterName = createGetterName(fieldName);
				Object val1 = clazz1.getMethod(getterName).invoke(model1);
				Object val2 = clazz2.getMethod(getterName).invoke(model2);
				if (val1 instanceof String) {
					String str1 = (String)val1;
					String str2 = (String)val2;
					if (!str1.equals(str2)) {
						flg = false;
						System.out.println("◆MisMatchItem：" + fieldName);
					}
				} else if (val1 instanceof Integer) {
					Integer int1 = (Integer)val1;
					Integer int2 = (Integer)val2;
					if (int1 != int2) {
						flg = false;
						System.out.println("◆MisMatchItem：" + fieldName);
					}
				} else if (val1 instanceof Date) {
					Date date1 = (Date)val1;
					Date date2 = (Date)val2;
					if (date1.getTime() != date2.getTime()) {
						flg = false;
						System.out.println("◆MisMatchItem：" + fieldName);
					}
				} else {
					if (!val1.equals(val2)) {
						flg = false;
						System.out.println("◆MisMatchItem：" + fieldName);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return flg;
	}

	/**
	 * list毎の比較
	 * @param list1 比較対象1
	 * @param list2 比較対象2
	 * @return チェック結果 true:一致
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean modelMatch(List list1, List list2) {
		if (isEmpty(list1) || isEmpty(list2)) {
			return false;
		}

		if (list1.size() != list2.size()) {
			return false;
		}

		boolean flg = true;
		for (int i=0; i<list1.size() ; i++) {
			if (!modelMatch(list1.get(i), list2.get(i))) {
				flg = false;
			}
		}
		return flg;
	}

	private static String createGetterName(String fieldName) {
		return "get"
				+ fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
	}

	public static Date createDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			return new Date();
		}
	}

	public static java.sql.Date convUtilDateToSqlDate(Date date){
		return new java.sql.Date(date.getTime());
	}

}
