package day6.arrayMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组合并
 * @author weicong
 * @date 2018/3/27 0027
 */
public class ArrayTest5 {
    public static void main(String args[]) {
        String a[] = { "A", "E", "I" };
        String b[] = { "O", "U" };
        List list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        Object[] c = list.toArray();
        System.out.println(Arrays.toString(c));
    }
}
