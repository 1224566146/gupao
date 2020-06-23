package com.fan.gupao.demo.points;

/**
 * @author 樊高风
 * @date 2020/6/23 16:08
 */
public class FacadeService {

    private QualifyService qualifyService = new QualifyService();
    private ShippingService shippingService = new ShippingService();
    private PaymentService paymentService = new PaymentService();


    public void exchange(GiftInfo giftInfo){
        if(qualifyService.isAvailable(giftInfo)){
            if(paymentService.pay(giftInfo)){
                String delivery = shippingService.delivery(giftInfo);
                System.out.println("物流系统下单成功，物流单号是:"+delivery);
            }
        }
    }
}