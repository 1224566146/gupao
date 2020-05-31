package javax.core.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
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

    /**
     * 功能描述：截取字符串
     *
     * @param src    传入的字符串
     * @param start  开始
     * @param length 长度
     * @param ov
     * @authorer: 樊高风
     * @date: 2020/5/4 22:14
     * @return:
     */
    public static String subString(String src, int start, int length, String ov) {
        if (src != null && length(src) > length) {
            try {
                byte[] rc = src.getBytes("GBK");
                short charlen = 2;
                int count = 0;
                if (!new String(rc).equals(src)) {
                    rc = src.getBytes("UTF-8");
                    charlen = 3;
                }
                length = Math.max(Math.min(length - start, rc.length), 1);
                byte[] bs = new byte[length];
                System.arraycopy(rc, start, bs, 0, length);
                for (byte c : bs) {
                    if (c < 0) {
                        count++;
                    }
                    if (count % charlen != 0) {
                        return subString(src, start, length - (count % charlen), ov);
                    }
                    return new String(bs) + ov;
                }
            } catch (Exception e) {
                return src.substring(start, length - ov.length()) + ov;
            }
        }
        return src;
    }

    /**
     * 功能描述：bytes to hex string
     *
     * @param bytes
     * @authorer: 樊高风
     * @date: 2020/5/4 22:18
     * @return:
     */
    public static String bytes2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            int i = b & 0xFF;
            if (i <= 0xF) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    //	public static final List<Character> HEX_CHAR_LIST;
//	static {
//		HEX_CHAR_LIST = new ArrayList<Character>();
//		HEX_CHAR_LIST.add(new Character('0'));
//		HEX_CHAR_LIST.add(new Character('1'));
//		HEX_CHAR_LIST.add(new Character('2'));
//		HEX_CHAR_LIST.add(new Character('3'));
//		HEX_CHAR_LIST.add(new Character('4'));
//		HEX_CHAR_LIST.add(new Character('5'));
//		HEX_CHAR_LIST.add(new Character('6'));
//		HEX_CHAR_LIST.add(new Character('7'));
//		HEX_CHAR_LIST.add(new Character('8'));
//		HEX_CHAR_LIST.add(new Character('9'));
//		HEX_CHAR_LIST.add(new Character('a'));
//		HEX_CHAR_LIST.add(new Character('b'));
//		HEX_CHAR_LIST.add(new Character('c'));
//		HEX_CHAR_LIST.add(new Character('d'));
//		HEX_CHAR_LIST.add(new Character('e'));
//		HEX_CHAR_LIST.add(new Character('f'));
//	}

//	private static byte hex2Byte(String s) {
//		int high = HEX_CHAR_LIST.indexOf(new Character(s.charAt(0))) << 4;
//		int low = HEX_CHAR_LIST.indexOf(new Character(s.charAt(1)));
//
//		return (byte) (high + low);
//	}

    /**
     * 功能描述：hex string to bytes
     *
     * @param input 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/4 22:48
     * @return:
     */
    public static byte[] hex2Bytes(String input) {
        byte[] res = new byte[input.length() / 2];
        char[] chs = input.toCharArray();
        for (int i = 0, c = 0; i < chs.length; i += 2, c++) {
            res[c] = (byte) (Integer.parseInt(new String(chs, i, 2), 16));
        }
        return res;
    }

    /**
     * 功能描述：获取匹配的前缀
     *
     * @param content 传入的字符串
     * @param regex   匹配字符串
     * @authorer: 樊高风
     * @date: 2020/5/4 22:52
     * @return:
     */
    public static String getPrefix(String content, String regex) {
        int _index = content.indexOf(regex);
        if (_index >= 0) {
            return content.substring(0, _index);
        }
        return content;
    }

    /**
     * 功能描述：将指定位置的字符转换为小写
     *
     * @param str        传入的字符串
     * @param beginIndex 开始下标
     * @param endIndex   结束下标
     * @authorer: 樊高风
     * @date: 2020/5/4 22:58
     * @return:
     */
    public static String lowerCase(String str, int beginIndex, int endIndex) {
        StringBuilder builder = new StringBuilder();
        builder.append(str.substring(0, beginIndex));
        builder.append(str.substring(beginIndex, endIndex).toLowerCase());
        builder.append(str.substring(endIndex));
        return builder.toString();
    }

    /**
     * 功能描述：将指定位置的字符转换为大写
     *
     * @param str        传入的字符串
     * @param beginIndex 开始下标
     * @param endIndex   结束下标
     * @authorer: 樊高风
     * @date: 2020/5/4 22:58
     * @return:
     */
    public static String upperCase(String str, int beginIndex, int endIndex) {
        StringBuilder builder = new StringBuilder();
        builder.append(str.substring(0, beginIndex));
        builder.append(str.substring(beginIndex, endIndex).toUpperCase());
        builder.append(str.substring(endIndex));
        return builder.toString();
    }

    /**
     * 功能描述：将首字母小写
     *
     * @param isString 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 14:29
     * @return:
     */
    public static String lowerCaseFirstChar(String isString) {
        StringBuilder sb = new StringBuilder();
        sb.append(isString.substring(0, 1).toLowerCase());
        sb.append(isString.substring(1));
        return sb.toString();
    }

    /**
     * 功能描述：将首字母大写
     *
     * @param isString 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 14:29
     * @return:
     */
    public static String upperCaseFirstChar(String isString) {
        StringBuilder sb = new StringBuilder();
        sb.append(isString.substring(0, 1).toUpperCase());
        sb.append(isString.substring(1));
        return sb.toString();
    }

    /**
     * 功能描述：检查子字符串出现过几次
     *
     * @param str    源字符串
     * @param subStr 子字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 19:26
     * @return:
     */
    public static int timesOf(String str, String subStr) {
        int foundCount = 0;
        if (subStr.equals("")) {
            return 0;
        }
        int fromIndex = str.indexOf(subStr);
        while (fromIndex != -1) {
            ++foundCount;
            fromIndex = str.indexOf(subStr, fromIndex + subStr.length());
        }
        return foundCount;
    }

    /**
     * 功能描述：去除两边空格(包括全角空格)，null值以空字符代替
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 19:27
     * @return:
     */
    public static String trim(String str) {
        if (str == null) {
            return "";
        } else {
            return str.trim();
        }
    }

    /**
     * 功能描述：去除右边空格
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 19:30
     * @return:
     */
    public static String rightTrim(String str) {
        if (null == str) {
            return "";
        }
        int length = str.length();
        for (int i = length - 1; i >= 0; --i) {
            if (str.charAt(i) != ' ') {
                break;
            }
            --length;
        }
        return str.substring(0, length);
    }

    /**
     * 功能描述：去除左边的空格
     *
     * @authorer: 樊高风
     * @date: 2020/5/5 19:33
     * @param:
     * @return:
     */
    public static String leftTrim(String str) {
        if (null == str) {
            return "";
        }
        int start = 0;
        int i = 0;
        for (int n = str.length(); i < n; ++i) {
            if (str.charAt(i) != ' ') {
                break;
            }
            ++start;
        }
        return str.substring(start);
    }

    /**
     * 功能描述：将字符串分割后，并去除其中的空值
     *
     * @param originalString  源字符串
     * @param delimiterString 分割符
     * @authorer: 樊高风
     * @date: 2020/5/5 19:40
     * @return:
     */
    public static String[] split(String originalString, String delimiterString) {
        int index = 0;
        String[] returnArray = null;
        int length = 0;

        if ((null == originalString) || (null == delimiterString)
                || ("".equals(originalString))) {
            return new String[0];
        }

        if (("".equals(originalString)) || ("".equals(delimiterString))
                || (originalString.length() < delimiterString.length())) {
            return new String[]{originalString};
        }

        String strTemp = originalString;
        while ((strTemp != null && (!("".equals(strTemp))))) {
            index = strTemp.indexOf(delimiterString);
            if (index == -1) {
                break;
            }
            ++length;
            strTemp = strTemp.substring(index + delimiterString.length());
        }
        returnArray = new String[++length];

        for (int i = 0; i < length - 1; ++i) {
            index = originalString.indexOf(delimiterString);
            returnArray[i] = originalString.substring(0, index);
            originalString = originalString.substring(index + delimiterString.length());
        }
        returnArray[(length - 1)] = originalString;
        return returnArray;
    }

    /**
     * 功能描述：字符串转Map
     *
     * @param str         字符串
     * @param splitString 拆分字符
     * @authorer: 樊高风
     * @date: 2020/5/5 19:52
     * @return:
     */
    public static Map<String, String> toMap(String str, String splitString) {
        return strToMap(str, splitString, "=");
    }

    /**
     * 功能描述：Json字符串转换为Map
     *
     * @param jsonStr  json字符串
     * @param splitStr 拆分字符
     * @authorer: 樊高风
     * @date: 2020/5/5 19:51
     * @return:
     */
    public static Map<String, String> jsonToMap(String jsonStr, String splitStr) {
        jsonStr = jsonStr.startsWith("{") ? jsonStr.substring(1) : jsonStr;
        jsonStr = jsonStr.endsWith("}") ? jsonStr.substring(0, jsonStr.length() - 1) : jsonStr;
        return strToMap(jsonStr, splitStr, ":");
    }

    /**
     * 功能描述：将字符串拆分成Map "str1=1,str2=abc,..."
     *
     * @param str      待拆分字符串
     * @param splitStr 拆分字符 ","
     * @param linkStr  连接字符 "="
     * @authorer: 樊高风
     * @date: 2020/5/5 19:50
     * @return:
     */
    public static Map<String, String> strToMap(String str, String splitStr, String linkStr) {
        Map<String, String> map = Collections.synchronizedSortedMap(new TreeMap<>());
        String[] values = split(str, splitStr);
        for (int i = 0; i < values.length; ++i) {
            String tempValue = values[i];
            int pos = tempValue.indexOf(linkStr);
            String key = "", value = "";
            if (pos > -1) {
                key = tempValue.substring(0, pos);
                value = tempValue.substring(pos + splitStr.length());
            } else {
                key = tempValue;
            }
            map.put(key.replace("\"", ""), value.replaceAll("\"", ""));
        }
        return map;
    }

    /**
     * 功能描述：ISO-8859-1编码格式转换成GBK
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 19:58
     * @return:
     */
    public static String isoTogbk(String str) {
        if (null == str) {
            return "";
        }
        try {
            return new String(str.getBytes("ISO-8859-1"), "GBK").trim();
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 功能描述：GBK编码格式转换成ISO-8859-1
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 19:58
     * @return:
     */
    public static String gbkToiso(String str) {
        if (null == str) {
            return "";
        }
        try {
            return new String(str.getBytes("GBK"), "ISO-8859-1").trim();
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 功能描述：将编码格式转换成UTF-8
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 19:58
     * @return:
     */
    public static String utfToiso(String str) {
        if (null == str) {
            return "";
        }
        try {
            return new String(str.getBytes(), "UTF-8").trim();
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 功能描述：判断字符串是否不为空,如果为空则指定一个字符串代替
     *
     * @param str  要判断的字符串
     * @param str1 用来替换的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 20:00
     * @return:
     */
    public static String notNull(String str, String str1) {
        return (str == null || "".equals(str)) ? str1 : str;
    }

    /**
     * 功能描述：判断字符串是否真空
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 20:02
     * @return:
     */
    public static boolean isNull(String str) {
        return null == str ? true : false;
    }

    /**
     * 功能描述：判断字符是否为空或者空字符串
     *
     * @param str 多个字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 20:04
     * @return:
     */
    public static boolean isEmpty(String... str) {
        for (String s : str) {
            if (isNull(s) || notNull(s).trim().length() < 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 功能描述：返回字符长度
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 20:06
     * @return:
     */
    public static int length(String str) {
        try {
            return str.getBytes("GBK").length;
        } catch (UnsupportedEncodingException e) {
            return str.length();
        }
    }

    /**
     * 功能描述：Escape SQL tags, ' to ''; \ to \\
     *
     * @authorer: 樊高风
     * @date: 2020/5/5 20:11
     * @param:
     * @return:
     */
    public static String escapeSQLTags(String input) {
        if (null == input || input.length() == 0) {
            return input;
        }
        StringBuffer buf = new StringBuffer();
        char ch = ' ';
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (ch == '\\') {
                buf.append("\\");
            } else if (ch == '\'') {
                buf.append("\'");
            } else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    /**
     * 功能描述：unescape
     *
     * @authorer: 樊高风
     * @date: 2020/5/5 20:18
     * @param:
     * @return:
     */
    public static String unescape(String str) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(str.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < str.length()) {
            pos = str.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (str.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(str.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(str.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(str.substring(lastPos));
                    lastPos = str.length();
                } else {
                    tmp.append(str.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    /**
     * 功能描述：将指定字符转换为 Unicode 编码
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 20:25
     * @return:
     */
    public static String nativeToascii(String str) {
        char[] ca = str.toCharArray();
        StringBuffer buffer = new StringBuffer(ca.length * 6);
        for (int i = 0; i < ca.length; ++i) {
            char a = ca[i];
            if (a > 255) {
                buffer.append("\\u").append(Integer.toHexString(a));
            } else {
                buffer.append(a);
            }
        }
        return buffer.toString();
    }

    /**
     * 功能描述：将指定长度的字符串用指定字符代替
     *
     * @param str     传入的字符串
     * @param len     指定长度
     * @param showStr 替换的字符串
     * @authorer: 樊高风
     * @date: 2020/5/5 20:47
     * @return:
     */
    public static String getPartString(String str, int len, String showStr) throws UnsupportedEncodingException {
        byte b[];
        int counterOfDoubleByte = 0;
        b = str.getBytes("UTF-8");
        if (b.length <= len) {
            return str;
        }
        for (int i = 0; i < len; i++) {
            if (b[i] < 0) {
                counterOfDoubleByte++;
            }
        }
        if (counterOfDoubleByte % 2 == 0) {
            return new String(b, 0, len, "UTF-8") + showStr;
        } else {
            return new String(b, 0, len - 1, "UTF-8") + showStr;
        }
    }

    /**
     * 功能描述：将指定的字符进行分页
     *
     * @param text      传入的字符串
     * @param pageIndex 当前页索引,从 1 开始
     * @param pageSize  规定每页固定输出的字符总长度
     * @authorer: 樊高风
     * @date: 2020/5/5 20:49
     * @return:
     */
    public static String pageination(String text, int pageIndex, int pageSize) {
        if (isEmpty(text)) {
            return text;
        }
        return pageination(text, pageIndex, pageSize, text.length());
    }

    /**
     * 功能描述：将指定的字符进行分页
     *
     * @param text       传入的字符串
     * @param pageIndex  当前页索引,从 1 开始
     * @param pageSize   规定每页固定输出的字符总长度
     * @param lineLength 规定每行显示多少个字符,这个变量用于控制显示效果
     * @authorer: 樊高风
     * @date: 2020/5/5 20:59
     * @return:
     */
    public static String pageination(String text, int pageIndex, int pageSize, int lineLength) {
        if (isEmpty(text)) {
            return text;
        }
        StringBuffer sb = new StringBuffer();
        // 计算总页数
        Integer totalPage = ((text.length() % pageSize == 0) ? text.length() / pageSize : (text.length() / pageSize + 1));
        if (pageIndex > totalPage) {
            return sb.append("页码无效").toString();
        }
        String result = text.toString().
                substring(
                        (pageIndex - 1) * pageSize,
                        (((pageIndex - 1) * pageSize + pageSize) >= text
                                .length() - 1) ? text.length()
                                : ((pageIndex - 1) * pageSize + pageSize));
        char[] chars = result.toCharArray();
        int length = lineLength;
        for (int i = 0; i < chars.length; i++) {
            if (length == 0) {
                length = lineLength;
                sb.append("\n");
            }
            length--;
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    /**
     * 功能描述：返回字符串Byte数组长度. <br>
     * <br>
     * <b>示例: </b> <br>
     * StringUtils.getBytesLength(&quot;幕课网&quot;) 返回值： 6
     * StringUtils.getBytesLength(&quot;chaoxing.com&quot;) 返回值：12
     * StringUtils.getBytesLength(&quot;&quot;) 返回值： 0
     * StringUtils.getBytesLength(null) 返回值： -1
     *
     * @param str 中文字符串或者英文字符串，或者null
     * @authorer: 樊高风
     * @date: 2020/5/5 21:01
     * @return: 返回字符串byte数组长度，如果是空字符串则返回0，如果是null则返回-1.
     */
    public static int getBytesLength(String str) {
        if (null == str) {
            return -1;
        }
        return str.getBytes().length;
    }

    /**
     * 功能描述：字符串查找，根据条件字符串在目标字符串中匹配，返回匹配索引 <br>
     * <br>
     * <b>示例 </b> <br>
     * StringUtils.indexOf(&quot;Tom's name is Tom&quot;,
     * &quot;tom&quot;,0,true) 返回值： -1<br>
     * StringUtils.indexOf(&quot;Tom's name is Tom&quot;,
     * &quot;Tom&quot;,0,true) 返回值： 0 <br>
     * StringUtils.indexOf(&quot;Tom's name is Tom&quot;,
     * &quot;Tom&quot;,2,true) 返回值： 14 <br>
     *
     * @param str           目标字符串，不能为null
     * @param subStr        匹配条件字符串，不能为null
     * @param fromIndex     开始索引
     * @param caseSensitive 是否字母大小写匹配，true：区分；false：不区分
     * @authorer: 樊高风
     * @date: 2020/5/5 21:03
     * @return: 返回从fromIndex索引位置开始的查询子字符串在目标字符串中的索引值，如果没有匹配项则返回-1.
     */
    public static int indexOf(String str, String subStr, int fromIndex, boolean caseSensitive) {
        if (caseSensitive == false) {
            return str.toLowerCase().indexOf(subStr.toLowerCase(), fromIndex);
        }
        return str.indexOf(subStr, fromIndex);
    }

    /**
     * 功能描述：字符换替换。把字符串str中searchStr字符串替换成replaceStr字符串. <br>
     * <br>
     * <b>示例： </b> <br>
     * StringUtils.replace(&quot;Tom's name is
     * Tom&quot;,&quot;Tom&quot;,&quot;Peter&quot;,true) 返回值： &quot;Peter's name
     * is Peter&quot; <br>
     * StringUtils.replace(&quot;Tom's name is
     * Tom&quot;,&quot;tom&quot;,&quot;Peter&quot;,true) 返回值：&quot;Tom's name is
     * Tom&quot; <br>
     * StringUtils.replace(&quot;Tom's name is
     * Tom&quot;,&quot;tom&quot;,&quot;Peter&quot;,false) 返回值：&quot;Peter's name
     * is Peter&quot; <br>
     *
     * @param str           目标字符串，不能为null
     * @param searchStr     查询字符串，不能为null
     * @param replaceStr    替换字符串
     * @param caseSensitive 是否字母大小写匹配，true：区分 false：不区分
     * @authorer: 樊高风
     * @date: 2020/5/6 9:45
     * @return: 返回替换后的字符串
     */
    public static String replace(String str, String searchStr, String replaceStr, boolean caseSensitive) {
        String result = "";
        int i = 0;
        int j = 0;
        if (null == str) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        if (null == searchStr || "".equals(searchStr)) {
            return str;
        }
        if (null == replaceStr) {
            replaceStr = "";
        }
        while ((j = indexOf(str, searchStr, i, caseSensitive)) > -1) {
            result = result + str.substring(i, j) + replaceStr;
            i = j + searchStr.length();
        }
        result = result + str.substring(i, str.length());
        return result;
    }

    /**
     * 功能描述：字符串替换，根据规则把oldStr替换后返回newStr.<br>
     * <br>
     * <b>示例： </b> <br>
     * StringUtils.replace(null, *, *) = null <br>
     * StringUtils.replace(&quot;&quot;, *, *) = &quot;&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, null) =
     * &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;) =
     * &quot;b&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;) =
     * &quot;zbz&quot; <br>
     *
     * @param str        目标字符串，如果为null则返回null
     * @param searchStr  匹配字符串，如果为null则不匹配任何值
     * @param replaceStr 替换字符串，如果为null则不替换任何字符串
     * @authorer: 樊高风
     * @date: 2020/5/6 9:52
     * @return: 返回全部替换后的字符串
     */
    public static String replace(String str, String searchStr, String replaceStr) {
        return replace(str, searchStr, replaceStr, true);
    }

    /**
     * 功能描述：字符替换，根据规则把searchChar替换后返回newStr.<br>
     * <br>
     * <b>示例： </b> <br>
     * StringUtils.replace(null, *, *) = null <br>
     * StringUtils.replace(&quot;&quot;, *, *) = &quot;&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, null) =
     * &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;) =
     * &quot;b&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;) =
     * &quot;zbz&quot; <br>
     *
     * @param str        目标字符串，如果为null则返回null
     * @param searchChar 匹配字符串，如果为null则不匹配任何值
     * @param replaceStr 替换字符串，如果为null则不替换任何字符串
     * @authorer: 樊高风
     * @date: 2020/5/6 9:54
     * @return: 返回全部替换后的字符串
     */
    public static String replace(String str, char searchChar, String replaceStr) {
        return replace(str, searchChar + "", replaceStr, true);
    }

    /**
     * 功能描述：替换字符串，从索引位置开始. <br>
     * <br>
     * <b>示例 </b> <br>
     * StringTools.replace(&quot;abcde f g&quot;,1,&quot;xx&quot;) 返回值：
     * &quot;axxde f g&quot;
     *
     * @param str        目标字符串，不能为null
     * @param beginIndex 开始替换索引位置
     * @param replaceStr 替换字符串，不能为null
     * @authorer: 樊高风
     * @date: 2020/5/6 9:57
     * @return: 返回字符串
     */
    public static String replace(String str, int beginIndex, String replaceStr) {
        String result = null;
        if (null == str) {
            return null;
        }
        if (null == replaceStr) {
            replaceStr = "";
        }
        result = str.substring(0, beginIndex) + replaceStr
                + str.substring(beginIndex, replaceStr.length());
        return result;
    }

    /**
     * 功能描述：去除字符串中所有空格. <br>
     * <br>
     * <b>示例： </b> <br>
     * StringUtils.absoluteTrim(&quot; ab cd e &quot;) 返回结果为： &quot;abcde&quot;
     *
     * @param str 带空格的字符串参数
     * @authorer: 樊高风
     * @date: 2020/5/6 10:04
     * @return: 不带空格的字符串
     */
    public static String absoluteTrim(String str) {
        String result = replace(str, " ", "");
        return result;
    }

    /**
     * 功能描述：英文数字排序
     *
     * @authorer: 樊高风
     * @date: 2020/5/6 10:13
     * @param:
     * @return:
     */
    public static Map<String, String> sortEnglishNumberWord(Map<String, String> map) {
        Map<String, String> resultMmap = new LinkedHashMap<>(0);
        Map<Integer, String> tempMap = new LinkedHashMap<>(0);

        Set<String> keys = map.keySet();

        int s = Integer.MAX_VALUE;
        for (String key : keys) {
            if (key.indexOf("One") > -1) {
                tempMap.put(1, key);
            } else if (key.indexOf("Two") > -1) {
                tempMap.put(2, key);
            } else if (key.indexOf("Three") > -1) {
                tempMap.put(3, key);
            } else if (key.indexOf("Four") > -1) {
                tempMap.put(4, key);
            } else if (key.indexOf("Five") > -1) {
                tempMap.put(5, key);
            } else if (key.indexOf("Six") > -1) {
                tempMap.put(6, key);
            } else if (key.indexOf("Seven") > -1) {
                tempMap.put(7, key);
            } else if (key.indexOf("Eight") > -1) {
                tempMap.put(8, key);
            } else if (key.indexOf("Nine") > -1) {
                tempMap.put(9, key);
            } else {
                tempMap.put(s, key);
            }
            s--;
        }
        Set<Integer> keyNum = tempMap.keySet();
        Object[] num_obj = keyNum.toArray();
        Integer[] nums = new Integer[num_obj.length];
        Integer tempInt = 0;
        for (int i = 0; i < num_obj.length; i++) {
            nums[i] = new Integer(num_obj[i].toString());
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    tempInt = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tempInt;
                }
            }
        }
        for (Integer num : nums) {
            resultMmap.put(tempMap.get(num), map.get(tempMap.get(num)));
        }
        return resultMmap;
    }

    /**
     * 功能描述：去除所有html标签
     *
     * @param content 传入的内容
     * @authorer: 樊高风
     * @date: 2020/5/6 10:16
     * @return:
     */
    public static String removeHtml(String content) {
        if (null == content) {
            return "";
        }
        Pattern p_html;
        Matcher m_html;
        try {
            p_html = Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(content);
            content = m_html.replaceAll("");
        } catch (Exception e) {
            return "";
        }
        return content;
    }

    /**
     * 功能描述：去除所有iframe标签
     *
     * @param content 传入的内容
     * @authorer: 樊高风
     * @date: 2020/5/6 10:16
     * @return:
     */
    public static String removeIframe(String content) {
        if (null == content) {
            return "";
        }
        Pattern p_html;
        Matcher m_html;
        try {
            p_html = Pattern.compile("<iframe[^>]+>", Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(content);
            content = m_html.replaceAll("");
        } catch (Exception e) {
            return "";
        }
        return content;
    }

    /**
     * 功能描述：去除样式加载
     *
     * @param content 传入的内容
     * @authorer: 樊高风
     * @date: 2020/5/6 10:16
     * @return:
     */
    public static String removeStyle(String content) {
        if (null == content) {
            return "";
        }
        Pattern p_html;
        Matcher m_html;
        try {
            p_html = Pattern
                    .compile(
                            "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>",
                            Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(content);
            content = m_html.replaceAll("");
        } catch (Exception e) {
            return "";
        }
        return content;
    }

    /**
     * 功能描述：去除脚本
     *
     * @param content 传入的内容
     * @authorer: 樊高风
     * @date: 2020/5/6 10:16
     * @return:
     */
    public static String removeScript(String content) {
        if (null == content) {
            return "";
        }
        Pattern p_html;
        Matcher m_html;
        try {
            p_html = Pattern
                    .compile(
                            "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>",
                            Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(content);
            content = m_html.replaceAll("");
        } catch (Exception e) {
            return "";
        }
        return content;
    }

    /**
     * 功能描述：去除空格
     *
     * @param content 传入的内容
     * @authorer: 樊高风
     * @date: 2020/5/6 10:24
     * @return:
     */
    public static String removeSpace(String content) {
        if (null == content) {
            return "";
        }
        return content.replaceAll("\\s*(\\r\\n)\\s*", "")
                .replaceAll(">(\\s+)", ">")
                .replaceAll("(\\s+)<", "<");
    }

    /**
     * 功能描述：以regex字符为分割符将list拼接成字符串
     *
     * @param list  集合
     * @param regex 分割符
     * @authorer: 樊高风
     * @date: 2020/5/6 10:26
     * @return:
     */
    public static String listToStr(List<String> list, String regex) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(regex);
            }
        }
        return sb.toString();
    }

    /**
     * 功能描述：以regex字符为分割符将数组拼接成字符串
     *
     * @param strArr 数组
     * @param regex  分隔符
     * @authorer: 樊高风
     * @date: 2020/5/6 10:28
     * @return:
     */
    public static String arrToStr(Object[] strArr, String regex) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb.append(regex);
            }
        }
        return sb.toString();
    }

    /**
     * 功能描述：数组转换成List
     *
     * @authorer: 樊高风
     * @date: 2020/5/6 10:30
     * @param:
     * @return:
     */
    public static List<String> arrToList(String[] strArr) {
        List<String> strList = new ArrayList<>();
        for (String string : strArr) {
            strList.add(string);
        }
        return strList;
    }

    /**
     * 功能描述：字符编码
     *
     * @param str 传入的字符串
     * @param enc 字符类型 “UTF-8”
     * @authorer: 樊高风
     * @date: 2020/5/6 10:35
     * @return:
     */
    public static String encode(String str, String enc) {
        String enstr = "";
        if (null == str || "".equals(str)) {
            return enstr;
        }
        try {
            enstr = URLEncoder.encode(str, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return enstr;
    }

    /**
     * 功能描述：字符解码
     *
     * @param str 传入的字符串
     * @param enc 字符类型 “UTF-8”
     * @authorer: 樊高风
     * @date: 2020/5/6 10:36
     * @return:
     */
    public static String decode(String str, String enc) {
        String enstr = "";
        if (null == str || "".equals(str)) {
            return enstr;
        }
        try {
            enstr = URLDecoder.decode(str, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return enstr;
    }

    /**
     * 功能描述：使用Base64编码方式给字符串编码
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/6 10:40
     * @return:
     */
    public static String encodeBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * 功能描述：使用Base64方式给字符串解码
     *
     * @param str 传入的字符串
     * @authorer: 樊高风
     * @date: 2020/5/6 10:39
     * @return:
     */
    public static String decodeBase64(String str) {
        byte[] b = null;
        String result = null;
        if (str != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(str);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
