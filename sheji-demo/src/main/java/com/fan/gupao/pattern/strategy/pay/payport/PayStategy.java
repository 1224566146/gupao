package com.fan.gupao.pattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:14 2020/3/4
 */
public class PayStategy {

    public static final String ALI_PAY = "ALIPAY";
    public static final String JD_PAY = "JDPAY";
    public static final String WECHAT_PAY = "WECHATPAY";
    public static final String UNION_PAY = "UNIONPAY";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> payStategy = new HashMap<>();

    static {
        payStategy.put(ALI_PAY, new AliPay());
        payStategy.put(JD_PAY, new JDpay());
        payStategy.put(WECHAT_PAY, new WeChatpay());
        payStategy.put(UNION_PAY, new UnionPay());
    }

    public static Payment get(String paymentKey){
        if(!payStategy.containsKey(paymentKey)){
            return payStategy.get(DEFAULT_PAY);
        }
        return payStategy.get(paymentKey);
    }

    private PayStategy(){

    }


}
