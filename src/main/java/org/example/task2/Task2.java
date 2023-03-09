package org.example.task2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Task2 {


    public static void main(String[] args) throws IllegalAccessException {
        ObjectExample objectExample = new ObjectExample(123);

        objectState(objectExample);
    }

    public static void objectState(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        System.out.println("Class name: " + clazz.getName());

        Method[] methods = clazz.getMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                System.out.println("    " + method.getName());
            }
        }
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
                System.out.println("    " + field.getName() + " = " + field.get(obj));
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of method to call: ");
        String methodName = scanner.nextLine();
        if (!methodName.isEmpty()) {
            try {
                Method method = clazz.getMethod(methodName);
                Object result = method.invoke(obj);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println("Error calling method: " + e.getMessage());
            }
        }
    }

}
