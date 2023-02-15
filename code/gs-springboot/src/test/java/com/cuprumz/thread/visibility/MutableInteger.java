package com.cuprumz.thread.visibility;

public class MutableInteger {
    
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
