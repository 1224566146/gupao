package com.fan.gupao.demo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        crawl("咕泡",1,10);

    }

    private static void crawl(String keyWorld, int startPageNum, int endPageNum) {
        try {

            int pageSize = 10;
            for(int pageNum = (startPageNum -1); pageNum < endPageNum;pageNum++){
                String url ="https://www.baidu.com/s?wd="+keyWorld+"&pn="+(pageNum*pageSize)+"&ie=utf-8";
                Connection connect = Jsoup.connect(url);
                Document document = header(connect).get();
                System.out.println("===============第" + (pageNum + 1) + "页=================");
                parse(document);
                Thread.sleep(1000);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parse(Document document) {
        String content = document.toString();

        try {
            Pattern regex = Pattern.compile("<div\\s+class=\"(?:result|result-op)\\s+c-container\\s+.*?<a.*?>(?<baiduTitle>.*?)</a>", Pattern.DOTALL);
            Matcher regexMatcher = regex.matcher(content);
            while (regexMatcher.find()) {
                // matched text: regexMatcher.group()
                // match start: regexMatcher.start()
                // match end: regexMatcher.end()
                System.out.println(regexMatcher.group("baiduTitle").replaceAll("(<em>|</em>)", ""));
            }
        } catch (PatternSyntaxException ex) {
            // Syntax error in the regular expression
        }

    }

    private static Connection header(Connection connect) {
        return connect.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3314.0 Safari/537.36 SE 2.X MetaSr 1.0")
                .header("Host", "www.baidu.com")
                .header("Referer", "https://www.baidu.com")
                .header("Cookie", "BAIDUID=F74673E2ABD0494A2512CA6EC571B110:FG=1; BIDUPSID=F74673E2ABD0494A2512CA6EC571B110; PSTM=1592449802; H_PS_PSSID=1456_31326_21102_31069_31660_32046_30823_31848_26350; BD_UPN=19314753; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; delPer=0; BD_CK_SAM=1; PSINO=1; H_PS_645EC=7e529eLcxBs9kQXklqQse1bTipysMyKTaJWRgBmJtlE6P%2BmGLgCkLpZkYCg");
    }
}
