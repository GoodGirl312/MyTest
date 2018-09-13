package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ys
 * @Description   jdk动态代理
 * @Date 2018/9/12 18:59
 */
public class JdkDynamicProxyTest implements InvocationHandler {

    private Target target;

    private JdkDynamicProxyTest(Target target){
        this.target=target;
    }

    public static Target newProxyInstance(Target target){

        return (Target) Proxy.newProxyInstance(JdkDynamicProxyTest.class.getClassLoader(),
                new Class<?>[]{Target.class},
                new JdkDynamicProxyTest(target));
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
