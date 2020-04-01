package chapter04.数据类类委托4_3;

import java.util.*;

public class Test {
    private void test1() {
        // 在Java中调用KT的object类
        Payroll.INSTANCE.caculateSalary();


    }

    public static void main(String[] args) {
        Set b = new HashSet();
        b.add(null);
        b.remove(null);


//        Set a = new TreeSet();
//        a.add(null);
//        a.remove(null);

        HashMap aaa = new HashMap();
        aaa.put(null,"");
        aaa.get(null);

        LinkedList linkedList = new LinkedList();
        linkedList.add("");



    }
}
