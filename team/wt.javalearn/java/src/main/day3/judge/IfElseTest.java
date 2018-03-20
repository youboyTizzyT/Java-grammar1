package day3.judge;

/**
 * 在这里将采用一个类解决所有判断语句的使用
 * @author weicong
 * @date 2018/3/20 0020
 */
public class IfElseTest {
    public static void main(String args[]){
        int x = 10;
        // 这里可以通过自行更改x的值进行查看是否走入每个分支语句
        if( x < 20 ){
            System.out.print("这是 if 语句");
        }else if (x < 10){
            System.out.println("这里是 else if 语句");
        }else{
            System.out.println("这里是 else 语句");
        }
        // 当然.if语句还可以嵌套,如同for循环一样
        if (true){
            System.out.println("走入第一层if");
            if (true){
                System.out.println("走入第二层if");
            }
        }
        // 除了if循环,当然还有一种不是很常用的分支语句,我目前没怎么用过.都是通过if来区分.
        char grade = 'C';

        switch(grade) {
            case 'A' :
                System.out.println("优秀");
                break;
            case 'B' :
            case 'C' :
                System.out.println("良好");
                break;// 这里必须break才能跳出switch循环 可以把grade更改成D大家自行体会
            case 'D' :
                System.out.println("及格");
            case 'F' :
                System.out.println("你需要再努力努力");
                break;
            default :
                System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);
    }
}
