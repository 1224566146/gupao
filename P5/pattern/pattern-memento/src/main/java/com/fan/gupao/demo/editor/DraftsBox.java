package com.fan.gupao.demo.editor;

import java.util.Stack;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class DraftsBox {

    private final Stack<ArticleMemento> STACK = new Stack<>();

    public ArticleMemento getMemento(){
        ArticleMemento articleMemento = STACK.pop();
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento){
        STACK.push(articleMemento);
    }


}
