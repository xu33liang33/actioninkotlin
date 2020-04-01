package chapter06;

public class Intro06Java {


    public static void main(String[] args) {

        strLen("asd");
        strLen("");
        strLen(null);
    }

    /**
     * 不安全的函数
     * 可以加空判断
     * kotlin更优雅的解决方案
     *
     * @param s
     * @return
     */
    public static int strLen(String s) {
        return s.length();
    }
}
