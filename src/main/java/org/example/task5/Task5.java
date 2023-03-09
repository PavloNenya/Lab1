package org.example.task5;

import java.lang.reflect.*;

public class Task5 {
    public static void main(String[] args) {
        myInterface myObject1 = new myImpl();
        myInterface exampleProxy = (myInterface) Proxy.newProxyInstance(
                myObject1.getClass().getClassLoader(),
                myObject1.getClass().getInterfaces(),
                new Profiler(myObject1)
        );
        exampleProxy.myMethod("some arg1");

        myInterface exampleProxy2 = (myInterface) Proxy.newProxyInstance(
                myObject1.getClass().getClassLoader(),
                myObject1.getClass().getInterfaces(),
                new Tracer(myObject1)
        );
        exampleProxy2.myMethod("some arg2");
    }
}

interface myInterface {
    String myMethod(String... args);
}

class myImpl implements myInterface {
    public String myMethod(String... args) {
        System.out.print("myMethod called, args: ");
        for(String arg: args) {
            System.out.print(arg);
        }
        System.out.println();
        return "myMethodReturn";
    }
}

class Profiler implements InvocationHandler {
    private final Object target;

    public Profiler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object... args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        return result;
    }
}

class Tracer implements InvocationHandler {
    private final Object target;

    public Tracer(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object... args) throws Throwable {
        System.out.println("Calling method " + method.getName());
        if (args != null) {
            System.out.print("With parameters: ");
            for (Object arg : args) {
                System.out.print(arg);
            }
            System.out.println();
        }
        Object result = method.invoke(target, args);
        System.out.println("Returning: " + result);
        return result;
    }
}
