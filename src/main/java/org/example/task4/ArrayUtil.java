package org.example.task4;

import java.lang.reflect.Array;

public class ArrayUtil {
    public static Object newInstance(int size, Class<?> type) {
        return Array.newInstance(type, size);
    }

    public static Object newMatrix(int rows, int columns, Class<?> type) {
        return Array.newInstance(type, rows, columns);
    }

    public static Object resize(Object array, int newSize) {
        int oldSize = Array.getLength(array);
        Class<?> elementType = array.getClass().getComponentType();
        Object newArray = Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0) {
            System.arraycopy(array, 0, newArray, 0, preserveLength);
        }
        return newArray;
    }

    public static Object resizeMatrix(Object matrix, int newRows, int newColumns) {
        int oldRows = Array.getLength(matrix);
        int oldColumns = Array.getLength(Array.get(matrix, 0));
        Class<?> elementType = matrix.getClass().getComponentType().getComponentType();
        Object newMatrix = Array.newInstance(elementType, newRows, newColumns);
        int preserveRows = Math.min(oldRows, newRows);
        int preserveColumns = Math.min(oldColumns, newColumns);
        for (int i = 0; i < preserveRows; i++) {
            System.arraycopy(Array.get(matrix, i), 0, Array.get(newMatrix, i), 0, preserveColumns);
        }
        return newMatrix;
    }


    public static String toString(Object array) {
        StringBuilder builder = new StringBuilder();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            builder.append(Array.get(array, i));
            if (i < length - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public static String matrixToString(Object matrix) {
        StringBuilder builder = new StringBuilder();
        int rows = Array.getLength(matrix);
        int columns = Array.getLength(Array.get(matrix, 0));
        for (int i = 0; i < rows; i++) {
            builder.append("[");
            for (int j = 0; j < columns; j++) {
                builder.append(Array.get(Array.get(matrix, i), j));
                if (j < columns - 1) {
                    builder.append(", ");
                }
            }
            builder.append("]");
            if (i < rows - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
