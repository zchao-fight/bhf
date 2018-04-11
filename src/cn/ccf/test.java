package cn.ccf;

import org.junit.Test;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class test {

    @Test
    public void main() {
        System.out.println("hello world");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }


        String str1 = "zhangsan";
        List<String> list = new ArrayList<>();
        String str2 = "lisi";

        String[] temp = {str1, str2};
        list =  Arrays.asList(temp);
        for (String s : list) {
            System.out.println(s);
        }

        temp = list.toArray(new String[2]);
        System.out.println(1);
        System.out.println(2);

    }
    
    @Test
    public void test3() {
        System.out.println(1);
    }
}
