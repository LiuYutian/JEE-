package cn.lyt.Utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {
	/*
	 * ���ɲ��ظ���32λ���ȵĴ�С�ַ���
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/*
	 * ��mapת��ָ�����͵�javaBean����
	 */
	public static <T>T toBean(Map map, Class<T> clazz) {
		try {
			// ����ָ������
			T bean = clazz.newInstance();
			
			// ��װ����
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
