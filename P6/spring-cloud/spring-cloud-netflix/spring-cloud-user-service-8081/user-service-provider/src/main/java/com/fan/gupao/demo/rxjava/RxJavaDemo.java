package com.fan.gupao.demo.rxjava;

import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Func0;

/**
 * @author 樊高风
 * @date 2020/7/20
 */
public class RxJavaDemo {


    // ReactiveX java 响应式编程框架(android)
    // Java stream() java8
    // 观察者模式
    public static void main(String[] args) {
        final String[] datas = new String[]{"登录","进入课堂","上课","答疑"};

        final Action0 onComplated = new Action0() {
            @Override
            public void call() {
                System.out.println("on Complated");
            }
        };

        // 老师(被观察者)
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                Observable<String> observable1 = Observable.from(datas);
                return observable1.doOnCompleted(onComplated);
            }
        });

        // 学生(观察者)
       Observer observer = new Observer(){

           @Override
           public void onCompleted() {
               System.out.println("Observer:onCompleted");
           }

           @Override
           public void onError(Throwable e) {
               System.out.println("Observer:onError");
           }

           @Override
           public void onNext(Object o) {
               System.out.println("on Next:"+o);
           }
       };

       // 建立订阅关系
       observable.subscribe(observer);

    }

}
