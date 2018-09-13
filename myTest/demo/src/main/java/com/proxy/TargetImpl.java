package com.proxy;

/**
 * @author ys
 * @Description
 * @Date 2018/9/12 18:57
 */
public class TargetImpl implements Target {
    @Override
    public int test(int i) {
        return i+1;
    }
}
