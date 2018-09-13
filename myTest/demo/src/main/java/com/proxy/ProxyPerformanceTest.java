package com.proxy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ys
 * @Description 测试原生方法和两种代理模式
 * @Date 2018/9/13 9:45
 */
public class ProxyPerformanceTest {

    public static void main(String[] args) {
        //创建对象
        Target nativeTarget=new TargetImpl();
        Target dynamicProxy=JdkDynamicProxyTest.newProxyInstance(nativeTarget);
        Target cglibProxy=CglibProxyTest.newProxyInstance(TargetImpl.class);

        //预热
      /*  int preRunCount=10000;
        runWithoutMonitor(nativeTarget,preRunCount);
        runWithoutMonitor(cglibProxy,preRunCount);
        runWithoutMonitor(dynamicProxy,preRunCount);*/

        //执行测试
        Map<String,Target> tests=new LinkedHashMap<>();
        tests.put("Native",nativeTarget);
        tests.put("Dynamic",dynamicProxy);
        tests.put("Cglib",cglibProxy);

        int repeatCount=3;

        int runCount=1000000;
        runTest(repeatCount,runCount,tests);
        runCount=50000000;
        runTest(repeatCount,runCount,tests);
    }

    private static void runTest(int repeatCount, int runCount, Map<String, Target> tests) {
        System.out.println(
                String.format("\n====run test :[repeatCount=%s] [runCount=%s] [java.version=%s]====",
                        repeatCount,runCount,System.getProperty("java.version")));
        for (int i=0;i<repeatCount;i++){
            System.out.println(String.format("\n-------test: [%s]------",(i+1)));
            for (String key:tests.keySet()) {
                runWithMonitor(tests.get(key),runCount,key);
            }
        }
    }

    private static void runWithMonitor(Target target, int runCount, String tag) {
        long start =System.currentTimeMillis();
        for (int i=0;i<runCount;i++){
            target.test(i);
        }
        long end =System.currentTimeMillis();
        System.out.println("["+tag+"] Total Time :"+(end-start)+" ms");
    }

    private static void runWithoutMonitor(Target target, int runCount) {
        for (int i=0;i<runCount;i++){
            target.test(i);
        }
    }
}
