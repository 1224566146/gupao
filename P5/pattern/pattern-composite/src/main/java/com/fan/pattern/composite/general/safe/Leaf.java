package com.fan.pattern.composite.general.safe;

/**
 * 叶子节点
 * @author 樊高风
 * @date 2020/6/29
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public String operation() {
        return this.name;
    }
}
