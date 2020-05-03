package javax.core.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: String工具类
 * @Author: 樊高风
 * @Date: 18:11 2020/5/3
 */
public class StringUtils {

    private StringUtils() {
    }

    /**
     * 功能描述：是否为空 是则返回一个空字符
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/3 18:12
     * @return:
     */
    public static String notNull(String str) {
        return str == null ? "" : str;
    }

    /**
     * 功能描述：格式化字符
     *
     * @param str  传入的字符串
     * @param args 参数
     * @authorer: 樊高风
     * @date: 2020/5/3 18:17
     * @return:
     */
    public static String format(String str, Object... args) {
        String result = str;
        Pattern pattern = Pattern
                .compile("\\{(\\d+)\\}");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int index = Integer.parseInt(matcher.group(1));
            if (index < args.length) {
                result = result.replace(matcher.group(),
                        ObjectUtils.notNull(args[index], "").toString());
            }
        }
        return result;
    }

    /**
     * 功能描述：转换编码格式
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/3 22:37
     * @return:
     */
    public static String coding(String str) {
        return coding(str, "ISO-8859-1");
    }

    /**
     * 功能描述：将指定编码转换为UTF-8
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/3 22:38
     * @return:
     */
    public static String coding(String str, String charset) {
        return coding(str, charset, "UTF-8");
    }

    /**
     * 功能描述：转换成指定的编码格式
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/3 22:38
     * @return:
     */
    public static String coding(String str, String charset, String tocharset) {
        try {
            return str == null ? "" : new String(str.getBytes(charset), tocharset);
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 功能描述：Escape编码
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/3 22:46
     * @return:
     */
    public static String escape(String str) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(str.length() * 6);
        for (i = 0; i < str.length(); i++) {
            j = str.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j)
                    || Character.isUpperCase(j)) {
                tmp.append(j);
            } else if (j < 256) {
                tmp.append("%");
                if (j < 16) {
                    tmp.append("0");
                } else {
                    tmp.append(Integer.toString(j, 16));
                }
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

}
