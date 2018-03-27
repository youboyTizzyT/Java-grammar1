package day6.arrayMethod;

import java.util.ArrayList;

/**
 *  数组交集
 * @author weicong
 * @date 2018/3/27 0027
 */
public class ArrayTest10 {
    public static void main(String[] args)  {
        ArrayList objArray = new ArrayList();
        ArrayList objArray2 = new ArrayList();
        objArray2.add(0,"common1");
        objArray2.add(1,"common2");
        objArray2.add(2,"notcommon");
        objArray2.add(3,"notcommon1");
        objArray.add(0,"common1");
        objArray.add(1,"common2");
        objArray.add(2,"notcommon2");
        System.out.println("array1 数组元素："+objArray);
        System.out.println("array2 数组元素："+objArray2);
        objArray.retainAll(objArray2);
        System.out.println("array2 & array1 数组交集为："+objArray);
    }
}
