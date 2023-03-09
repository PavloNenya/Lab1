package org.example.task1;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task1 {
    public static String getInfo(Class clazz) {
        StringBuilder classInfo = new StringBuilder();

        classInfo.append("Package of the class: ")
                .append(clazz.getPackageName())
                .append("\n");
        classInfo.append("Modifiers: ")
                .append(Modifier.toString(clazz.getModifiers()))
                .append("\n");
        classInfo.append("Name: ")
                .append(clazz.getSimpleName())
                .append("\n");
        if(!clazz.isPrimitive()) {
            classInfo.append("Superclass(-es): ")
                    .append(getSuperclassesAsString(clazz))
                    .append("\n");

            classInfo.append("Implement interfaces: ").append(Arrays.stream(clazz.getInterfaces())
                            .map(Class::getSimpleName)
                            .collect(Collectors.joining(", ")))
                    .append("\n");

            classInfo.append("Fields: ");
            for (Field field : clazz.getDeclaredFields()) {
                classInfo.append(Modifier.toString(field.getModifiers())).append(" ");
                classInfo.append(field.getType().getSimpleName()).append(" ");
                classInfo.append(field.getName()).append(", \n\t");
            }
            classInfo.append("\n");

            classInfo.append("Constructors: ");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                classInfo.append(Modifier.toString(constructor.getModifiers())).append(" ");
                classInfo.append(clazz.getSimpleName())
                        .append("(")
                        .append(Arrays.stream(constructor.getParameters())
                            .map(p -> p.getType().getSimpleName())
                            .collect(Collectors.joining(", ")))
                            .append(")\n\t");
            }
            classInfo.append("\n");

            classInfo.append("Methods: ");
            for (Method method : clazz.getDeclaredMethods()) {
                classInfo.append(Modifier.toString(method.getModifiers())).append(" ");
                classInfo.append(method.getReturnType().getSimpleName()).append(" ");
                classInfo.append(method.getName())
                        .append("(")
                        .append(Arrays.stream(method.getParameters())
                                .map(p -> p.getType().getSimpleName())
                                .collect(Collectors.joining(", ")))
                        .append(")\n\t");
            }
            classInfo.append("\n");
        }



        return classInfo.toString();
    }

    private static String getSuperclassesAsString(Class clazz) {
        StringBuilder superClasses = new StringBuilder();
        do {
            clazz = clazz.getSuperclass();
            superClasses.append(clazz.getSimpleName()).append(", ");
        } while (clazz != Object.class);
        return superClasses.isEmpty() ? null : superClasses.substring(0, superClasses.length()-2);
    }

    public static String getInfo(String classPath)  {
        Class clazz;
        try {
            clazz = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return getInfo(clazz);
    }

    public static void main(String[] args)  {
        ClassInfoGUI gui = new ClassInfoGUI();
    }
}
