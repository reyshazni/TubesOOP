package com.monstersaku;

public class ElementTypeEff {
    ElementType source;
    private ElementType target;
    private int effectivity;
    
    //konstruktor
    public ElementTypeEff(ElementType source, ElementType target, int effectivity){
        this.source = source;
        this.target = target;
        this.effectivity = effectivity;
    }

    //getter
    public ElementType getSource() {
        return source;
    }

    public ElementType getTarget() {
        return target;
    }

    public int getEffectivity() {
        return effectivity;
    }

    //setter
    public void setSource(ElementType source) {
        this.source = source;
    }

    public void setTarget(ElementType target) {
        this.target = target;
    }

    public void setEffectivity(int effectivity) {
        this.effectivity = effectivity;
    }
}