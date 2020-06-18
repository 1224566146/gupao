package javax.core.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Cookie管理
 * 
 * @createDate 2011-5-20
 */
public class CookiesUtil {
	public static final int MAXAGE = 60 * 60 * 24;
	
	private CookiesUtil(){}

	/**
	 * 取Cookie值
	 * 
	 * @param key
	 * @param req
	 * @return
	 */
	public static String loadCookie(String key, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for ( int i = 0; i < cookies.length; i++ ) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals(key)) { return cookie.getValue(); }
			}
		}
		return null;
	}

	public static void write(String domain, String name, String value, String path, int maxage, HttpServletResponse response, HttpServletRequest request){
		if (loadCookie(name, request) != null) remove(name, null, response, request);
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxage);
		response.addCookie(cookie);
	}
	
	public static void write(String domain, String name, String value, String path, HttpServletResponse response, HttpServletRequest request){
		if (loadCookie(name, request) != null) remove(name, null, response, request);
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(domain);
		cookie.setPath(path);
		response.addCookie(cookie);
	}
	
	/**
	 * 添加带会话时长的Cookie对象
	 * @param domain
	 * @param name
	 * @param value
	 * @param maxage
	 * @param response
	 * @param request
	 */
	public static void write(String name, String value, int maxage, HttpServletResponse response, HttpServletRequest request){
		if (loadCookie(name, request) != null) remove(name, null, response, request);
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(getDomain(request));
		cookie.setPath("/");
		cookie.setMaxAge(maxage);
		response.addCookie(cookie);
	}
	
	public static void write(String domain, String name, String value, HttpServletResponse response, HttpServletRequest request){
		if (loadCookie(name, request) != null) remove(name, null, response, request);
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(domain);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	/**
	 * Cookie 简单方法，会话周期
	 * @param name	属性名
	 * @param value	属性值
	 * @param response
	 * @param request
	 */
	public static void write(String name, String value, HttpServletResponse response, HttpServletRequest request){
		if (loadCookie(name, request) != null) remove(name, null, response, request);
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(getDomain(request));
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	/**
	 * 移除Cookie
	 * 
	 * @param key
	 * @param domain
	 * @param resp
	 * @param req
	 */
	public static void remove(String key, String domain, HttpServletResponse resp, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for ( int i = 0; i < cookies.length; i++ ) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals(key)) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					resp.addCookie(cookie);
				}
			}
		}
	}

	/**
	 * 移除所有Cookie
	 * 
	 * @param key
	 * @param domain
	 * @param resp
	 * @param req
	 */
	public static void removeAll(String domain, HttpServletResponse resp, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for ( int i = 0; i < cookies.length; i++ ) {
				Cookie cookie = cookies[i];
				if (cookie != null) {
					cookie.setDomain(domain);
					cookie.setMaxAge(0);
					cookie.setPath("/");
					resp.addCookie(cookie);
				}
			}
		}
	}
	
	/**
	 * 移除当前域下所有Cookie
	 * @param resp
	 * @param req
	 */
	public static void removeAll(HttpServletResponse resp, HttpServletRequest req){
		removeAll(getDomain(req), resp, req);
	}
	/**
	 * 取根域名
	 * 
	 * @param req
	 * @return
	 */
	public static String getDomain(HttpServletRequest req) {
		return req.getServerName().replaceAll("^([^.]+\\.)+", "$1");
	}
}
