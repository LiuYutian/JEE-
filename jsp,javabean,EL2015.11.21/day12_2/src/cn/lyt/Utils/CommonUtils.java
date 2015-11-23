package cn.lyt.Utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {
	/*
	 * 生成不重复的32位长度的大小字符串
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/*
	 * 将map转换指定类型的javaBean对象
	 */
	public static <T>T toBean(Map map, Class<T> clazz) {
		try {
			// 创建指定对象
			T bean = clazz.newInstance();
			
			// 封装数据
			BeanUtils.populate(bean, map);
			return bean;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
