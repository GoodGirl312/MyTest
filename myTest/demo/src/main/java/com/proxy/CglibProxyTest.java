package com.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ys
 * @Description
 * @Date 2018/9/12 19:06
 */
public class CglibProxyTest implements MethodInterceptor {

    public CglibProxyTest() {
    }

    public static <T extends Target> Target newProxyInstance(Class<T> targetInstanceClazz){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxyTest());
        return (Target)enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o,objects);
    }
}
