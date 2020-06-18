package javax.core.common.utils;

import java.util.regex.Pattern;


/**
 * 常用正则表达式
 * @author Tanyongde
 *
 * @date Oct 22, 2010, 12:40:51 PM
 *
 */
public class RegexUtils {
	
	private RegexUtils(){}

	/**
	 * 整数
	 */
	public static final String intege = "^-?[1-9]\\d*$/";					//整数
	/**
	 * 正整数
	 */
	public static final String intege1 = "^[1-9]\\d*$/";					//正整数
	/**
	 * 负整数
	 */
	public static final String intege2 = "^-[1-9]\\d*$/";					//负整数
	/**
	 * 数字
	 */
	public static final String num = "^([+-]?)\\d*\\.?\\d+$/";			//数字
	/**
	 * 正数（正整数 + 0）
	 */
	public static final String num1 = "^[1-9]\\d*|0$/";					//正数（正整数 + 0）
	/**
	 * 负数（负整数 + 0）
	 */
	public static final String num2 = "^-[1-9]\\d*|0$/";					//负数（负整数 + 0）
	/**
	 * 浮点数
	 */
	public static final String decmal = "^([+-]?)\\d*\\.\\d+$/";			//浮点数
	/**
	 * 正浮点数
	 */
	public static final String decmal1 = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$"; //正浮点数
	/**
	 * 负浮点数
	 */
	public static final String decmal2 = "^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$"; //负浮点数
	/**
	 * 浮点数
	 */
	public static final String decmal3 = "^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$";//浮点数
	/**
	 * 非负浮点数（正浮点数 + 0）
	 */
	public static final String decmal4 = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$";  //非负浮点数（正浮点数 + 0）
	/**
	 * 非正浮点数（负浮点数 + 0）
	 */
	public static final String decmal5 = "^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$"; //非正浮点数（负浮点数 + 0）

	/**
	 * 邮件
	 */
	public static final String email = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$"; //邮件
	/**
	 * 颜色
	 */
	public static final String color = "^[a-fA-F0-9]{6}$";				//颜色
	/**
	 * url
	 */
	public static final String url = "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-.\\/?%&=]*)?$";	//url
	/**
	 * 仅中文
	 */
	public static final String chinese = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";					//仅中文
	/**
	 * 仅ACSII字符
	 */
	public static final String ascii = "^[\\x00-\\xFF]+$";				//仅ACSII字符
	/**
	 * 邮编
	 */
	public static final String zipcode = "^\\d{6}$";						//邮编
	/**
	 * 手机
	 */
	public static final String mobile = "^(13|15|16|18)[0-9]{9}$";				//手机
	/**
	 * ip地址
	 */
	public static final String ip4 = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";	//ip地址
	/**
	 * 非空
	 */
	public static final String notempty = "^\\S+$";						//非空
	/**
	 * 图片
	 */
	public static final String picture = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga|JPG|BMP|GIF|ICO|PCX|JPEG|TIF|PNG|RAW|TGA)$";	//图片
	
	/**
	 * 音频
	 */
	public static final String audio = "(.*)\\.(mp3|wma|mid|midi|wav|vqf|MP3|WMA|MID|MIDI|WAV|VQF)$";	//音频
	
	/**
	 * 视频
	 */
	public static final String video = "(.*)\\.(rm|3gp|mp4|rmvb|avi|wmv|flv|vob|exe|mkv|swf|RM|3GP|MP4|RMVB|AVI|WMV|FLV|VOB|EXE|MKV|SWF)$"; // 视频格式
	
	/**
	 * 压缩文件
	 */
	public static final String rar = "(.*)\\.(rar|zip|7zip|tgz|RAR|ZIP|7ZIP|TGZ)$";	//压缩文件
	/**
	 * 日期
	 */
	public static final String date = "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$";	//日期
	/**
	 * 日期时间
	 */
	public static final String datetime = "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}(\\s\\d{2}:)?(\\d{2}:)?(\\d{2})?$";	//日期和时间
	/**
	 * QQ号码
	 */
	public static final String qq = "^[1-9]*[1-9][0-9]*$";		//QQ号码
	/**
	 * 电话号码的函数(包括验证国内区号,国际区号,分机号)
	 */
	public static final String tel = "^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$";	//电话号码的函数(包括验证国内区号,国际区号,分机号)
	/**
	 * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
	 */
	public static final String username = "^[A-Za-z]\\w{5,}$";	//用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
	/**
	 * 字母数字组合
	 */
	public static final String allstring = "^\\w+$"; //字母数字组合
	/**
	 * 字母
	 */
	public static final String letter = "^[A-Za-z]+$";					//字母
	/**
	 * 大写字母
	 */
	public static final String letter_u = "^[A-Z]+$";					//大写字母
	/**
	 * 小写字母
	 */
	public static final String letter_l = "^[a-z]+$";					//小写字母
	/**
	 * 第二代身份证
	 */
	public static final String idcard = "^[1-9]([0-9]{14}|[0-9]{17})$";	//身份证
	
	/**
	 * 数字或字母
	 */
	public static final String numOrStr = "^[A-Za-z0-9]+$";//数字或字母
	/**
	 * 匹配字符是否符合要求
	 * @return
	 */
	public static boolean test(String input,String regx)
	{
		return Pattern.matches(regx, input);
	}
	
}
