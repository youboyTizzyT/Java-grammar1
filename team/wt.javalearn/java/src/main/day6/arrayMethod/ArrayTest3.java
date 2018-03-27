package day6.arrayMethod;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 数组反转
 * @author weicong
 * @date 2018/3/27 0027
 */
public class ArrayTest3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println("反转前排序: " + arrayList);
        Collections.reverse(arrayList);
        System.out.println("反转后排序: " + arrayList);
    }
}
