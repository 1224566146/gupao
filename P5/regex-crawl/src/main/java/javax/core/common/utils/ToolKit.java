package javax.core.common.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * 从Request对象中获取内容的工具包
 * @author Tanyongde
 *
 */
public class ToolKit {
	
	private ToolKit(){}
	
	/**
	 * 从request中获取一个值并转换为long
	 * @param request
	 * @param key
	 * @return
	 */
	public static long getLong(HttpServletRequest request,String key){
		return getLong(request,key,0);
	}
	
	/**
	 * 从request中获取一个值并转换为long,如果获取结果为null则赋值为指定的默认值
	 * @param request
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static long getLong(HttpServletRequest request,String key,long defaultValue){
		long res = defaultValue;
		String p = request.getParameter(key);
		try{
			if(StringUtils.isNotBlank(p)){
				res = Long.parseLong(p);
			}
		}catch (NumberFormatException e) {
		}
		return res;
	}
	
	/**
	 * 从request中获取一个值并转换为String
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getString(HttpServletRequest request,String key){
		return getString(request,key,"");
	}
	
	/**
	 * 从request中获取一个值并转换为String,如果获取结果为null，则赋值为指定的默认值
	 * @param request
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(HttpServletRequest request,String key,String defaultValue){
		String res = defaultValue;
		String p = request.getParameter(key);
		try{
			if(StringUtils.isNotBlank(p)){
				res = p;
			}
		}catch (NumberFormatException e) {
		}
		return res;
	}
	
	/**
	 * 从request中获取一个值并转换为int
	 * @param request
	 * @param key
	 * @return
	 */
	public static int getInt(HttpServletRequest request,String key){
		return getInt(request,key,0);
	}
	
	/**
	 * 从request中获取一个值并转换为int,如果获取结果为null，则赋值为指定的默认值
	 * @param request
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getInt(HttpServletRequest request,String key,int defaultValue){
		int res = defaultValue;
		String p = request.getParameter(key);
		try{
			if(StringUtils.isNotBlank(p)){
				res = Integer.parseInt(p);
			}
		}catch (NumberFormatException e) {
		}
		return res;
	}
}
