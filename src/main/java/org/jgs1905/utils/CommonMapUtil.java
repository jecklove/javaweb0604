package org.jgs1905.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建工具类实现一个map多个jsp共享
 * @author junki
 * @date 2020年5月28日
 */
public final class CommonMapUtil {

	private CommonMapUtil(){};
	
	// 所有用户公用该集合
	// 作用域：应用级别（application）
	public static Map<String, Object> map = new HashMap<>();;
	
}
