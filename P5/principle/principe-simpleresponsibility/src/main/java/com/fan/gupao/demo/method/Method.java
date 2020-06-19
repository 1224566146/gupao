package com.fan.gupao.demo.method;

/**
 * @author 樊高风
 * @date 2020/6/19 18:51
 */
public class Method {

    private void modifyUserInfo(String userName, String address){
        userName = "Tom";
        address = "changshang";
    }

    private void modifyUserInfo(String userName,String... fileds){}

    private void modifyUserInfo(String userName,String address,boolean bool){
        if(bool){

        }else{

        }
    }

    private void modifyUserName(String userName){

    }

    private void modifyAddress(String address){}
}
