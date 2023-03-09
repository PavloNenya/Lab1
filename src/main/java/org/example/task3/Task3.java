package org.example.task3;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static Object invokeMethod(Object object, String methodName, List<Object> args) throws FunctionNotFoundException {

        Class<?>[] argClasses = new Class<?>[args.size()];
        for (int i = 0; i < args.size(); i++) {
            argClasses[i] = args.get(i).getClass();
        }

        try {
            Method method = object.getClass().getMethod(methodName, argClasses);
            return method.invoke(object, args.toArray());
        } catch (NoSuchMethodException e) {
            throw new FunctionNotFoundException("Method " + methodName + " not found in class " + object.getClass().getName());
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new FunctionNotFoundException("Cannot call method " + methodName + ": " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws FunctionNotFoundException{
        String str = "te-stS-trin-g";

        String methodName = "replaceAll";
        System.out.println("Input string: " + str);
        System.out.println("Method name: " + methodName);
        System.out.println("Method parameters: " + "\"-\", " + "\"\"");
        System.out.println("Resul: " + invokeMethod(str, methodName, List.of("-", "")));
    }
}
