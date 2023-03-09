package org.example.task2;

public class ObjectExample {
    int field1;
    public final int field2;
    private double field3;
    static int staticField;

    public ObjectExample(int field2) {

        this.field2 = field2;
    }

    public ObjectExample(int field1, int field2, double field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public double getField3() {
        return field3;
    }

    public void setField3(double field3) {
        this.field3 = field3;
    }

    public static int getStaticField() {
        return staticField;
    }

    public static void setStaticField(int staticField) {
        ObjectExample.staticField = staticField;
    }

    private void method1(String params) {
        System.out.println("This is method1 with params");
    }

    public void method2(String params) {
        System.out.println("This is method2 with params");
    }

    public String methodReturnString() {
        return ("This is method without params");
    }

    private void method3() {
        System.out.println(("This is method3 without params"));
    }

    protected void method4() {
        System.out.println(("This is method4 without params"));
    }
}
