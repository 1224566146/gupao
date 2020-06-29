package com.fan.pattern.composite.general.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 * @author 樊高风
 * @date 2020/6/29
 */
public class Composite extends Component {

    private List<Component> mComponents;

    public Composite(String name) {
        super(name);
        this.mComponents = new ArrayList<>();
    }

    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder(this.name);
        for (Component mComponent : mComponents) {
            builder.append("\n");
            builder.append(mComponent.operation());
        }
        return builder.toString();
    }

    @Override
    public boolean addChild(Component component) {
       return this.mComponents.add(component);
    }

    @Override
    public boolean removeChild(Component component) {
        return this.mComponents.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return this.mComponents.get(index);
    }
}
