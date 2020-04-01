package chapter05;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * 本质上就是可以传递给其他函数的一小段代码
 * 多用于处理集合等
 */
public class LambbdaTest {
    public static void main(String[] args) {

        String[] planets = new String[]{"A", "B12", "E", "F12", "G", "H", "C", "D123"};
        System.out.println(Arrays.toString(planets));

        System.out.println("Sort by dictionary:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sort by length:");
        Arrays.sort(planets,
                (first, second) -> first.length() - second.length()
        );
        System.out.println(Arrays.toString(planets));

        // 监听按钮
        Timer t = new Timer(1000,
                event -> System.out.println("The Time is " + new Date() + "||" + event.toString())
        );
        t.start();
        System.out.println();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
