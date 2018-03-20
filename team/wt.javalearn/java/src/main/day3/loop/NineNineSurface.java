package day3.loop;

/**
 * 看到这里的,如果你是刚入门,你已经可以写一片99乘法表的练习了
 * @author weicong
 * @date 2018/3/20 0020
 */
public class NineNineSurface {
    public static void main(String args[]) {
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println();
        }
    }
}
