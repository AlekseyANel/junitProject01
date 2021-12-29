package Math;/*This is a little math calculation*/

public class MathCalc {
    public static int addition(int a, int b) throws InterruptedException {
        Thread.sleep(10); // make a TestTimedOutException
        return a+b;
    }
    public static int multiplication(int a, int b) {
        return a*b;
    }
    public static int subtraction(int a, int b) {
        return a-b;
    }
    public static int division(int a, int b) {
        return a/b;
    }

}
