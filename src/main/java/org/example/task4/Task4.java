package org.example.task4;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Vector of primitives");

        int[] intArray = (int[]) ArrayUtil.newInstance(3, int.class);
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 30);;
        }
        for (int value : intArray) {
            System.out.print(value + " ");
        }
        System.out.println("\n");

        System.out.println("Reference type vector");
        String[] strArray = (String[]) ArrayUtil.newInstance(3, String.class);
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = String.valueOf((int) (Math.random() * 30));;
            System.out.print(strArray[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Primitives matrix");
        int[][] intMatrix = (int[][]) ArrayUtil.newMatrix(2, 3, int.class);
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                intMatrix[i][j] = (int) (Math.random() * 30);
                System.out.print(intMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");

        System.out.println("Reference type matrix");
        Integer[][] integerMatrix = (Integer[][]) ArrayUtil.newMatrix(3, 2, Integer.class);
        for (int i = 0; i < integerMatrix.length; i++) {
            for (int j = 0; j < integerMatrix[i].length; j++) {
                integerMatrix[i][j] = (int) (Math.random() * 30);;
                System.out.print(integerMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");

        System.out.println("Resize primitive vector");
        intArray = (int[]) ArrayUtil.resize(intArray, 8);
        for (int k : intArray) {
            System.out.print(k + " ");
        }
        System.out.println("\n");

        System.out.println("Resize reference vector");
        integerMatrix = (Integer[][]) ArrayUtil.resizeMatrix(integerMatrix, 2, 4);
        for (Integer[] matrix : integerMatrix) {
            for (Integer integer : matrix) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println("\n");

        System.out.println("vector to string");
        String intArrayAsString = ArrayUtil.toString(intArray);
        System.out.println(intArrayAsString);
        System.out.println();

        System.out.println("matrix to string");
        String integerMatrixAsString = ArrayUtil.matrixToString(integerMatrix);
        System.out.println(integerMatrixAsString);
    }
}
