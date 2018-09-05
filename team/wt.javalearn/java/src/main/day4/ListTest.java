package day4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * List 一下是我经常使用list的所有需求实现 这些都熟练掌握,写麻将字牌算法已经完全应对
 * @author weicong
 * @date 2018/3/20 0020
 */
public class ListTest {
    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            Field field = arrayListClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] objects = (Object[])field.get(arrayList);
            return objects.length;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static void main(String[] args) {
        // 1 list中添加，获取，删除元素；
        ArrayList<String> list=new ArrayList<>();
        // 显示arraylist中实际数组的大小
        System.out.println(getArrayListCapacity(list));
        list.add("jackie");
        System.out.println(getArrayListCapacity(list));
        for (int i = 0; i < 10; i++) {
            list.add("peter");
        }
        System.out.println(getArrayListCapacity(list));
        list.add("annie");
        System.out.println(getArrayListCapacity(list));

        // 输出: [jackie, peter, annie] 在这里,为什么输出一个List数据类型能得到一个字符串,因为List重写了toString方法
        System.out.println(list);
        list.remove("annie");
        list.remove(1);
        // 输出: [jackie]
        System.out.println(list);
        list.clear();
        // ArrayList 在添加数组的时候会扩容，但是删除的时候不会缩减
        System.out.println(getArrayListCapacity(list));
        // 2 list中是否包含某个元素；
        List<String> list1=new ArrayList<>();
        list1.add("苹果");
        list1.add("香蕉");
        list1.add("桃子");
        System.out.println("fruits中是否包含苹果："+list1.contains("苹果"));
        // 3 list中根据索引将元素数值改变(替换)；
        String a="白龙马", b="沙和尚", c="八戒", d="唐僧", e="悟空";
        List<String> people=new ArrayList<>();
        people.add(a);
        people.add(b);
        people.add(c);
        //.set(index, element);     //将d唐僧放到list中索引为0的位置，替换a白龙马
        people.set(0, d);
        //.add(index, element);     //将e悟空放到list中索引为1的位置,原来位置的b沙和尚后移一位
        people.add(1, e);
        //增强for循环遍历list
        for(String str:people){
            System.out.println(str);
        }
        // 4 list中查看（判断）元素的索引；　
        List<String> names=new ArrayList<>();
        names.add("刘备");    //索引为0
        names.add("关羽");    //索引为1
        names.add("张飞");    //索引为2
        names.add("刘备");    //索引为3
        names.add("张飞");    //索引为4
        System.out.println(names.indexOf("刘备"));
        System.out.println(names.lastIndexOf("刘备"));
        System.out.println(names.indexOf("张飞"));
        System.out.println(names.lastIndexOf("张飞"));
        // 5 对比两个list是否相同.  说出来可能也记不住,还不如自己运行一下看看
        // 两个相等对象的equals方法一定为true, 但两个hashcode相等的对象不一定是相等的对象
        ArrayList list2=new ArrayList();
        list2.add("1");
        LinkedList list3=new LinkedList<>();
        list3.add("1");
        System.out.println(list2.equals(list3));
        System.out.println(list2.hashCode()==list3.hashCode());
        // 6 判断list是否为空
        if (list2.isEmpty()){
            System.out.println("");
        }
        // 7 返回Iterator集合对象
        System.out.println("返回Iterator集合对象:"+names.iterator() );
        // 8 将集合转换为数组
        System.out.println("将集合转换为数组:"+names.toArray() );
        // 9 去重
        List<String> lst1=new ArrayList<>();
        lst1.add("aa");
        lst1.add("dd");
        lst1.add("ss");
        lst1.add("aa");
        lst1.add("ss");

        //方法 1.
        for (int i = 0; i <lst1.size()-1; i++) {
            for (int j = lst1.size()-1; j >i; j--) {
                if (lst1.get(j).equals(lst1.get(i))) {
                    lst1.remove(j);
                }
            }
        }
        System.out.println(lst1);

        //方法 2.
        List<String> lst2=new ArrayList<>();
        for (String s:lst1) {
            if (Collections.frequency(lst2, s)<1) {
                lst2.add(s);
            }
        }
        System.out.println(lst2);
    }
}
