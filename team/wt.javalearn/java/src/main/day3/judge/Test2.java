package day3.judge;

/**
 * 例子2
 * @author weicong
 * @date 2018/3/20 0020
 */
public class Test2 {
    int a,b;    //a是要生成的菱形行数
    int h;      //h是方法中的参数，也是行数
    int i,j;    //i j是循环结构参数
    public void draw(int h ){
        for(i = 1 ;i <= h ;i++){         //逐行打印
            for(j = 1;j <= h;j++){       //每行打印个数与行数保持一致
                //下面语句是菱形四条边的函数，在边上的坐标点，打印*，否则打印空格
                if(j == (h + 3) / 2 - i || j == (h - 1) / 2 + i || j == i - (h - 1 ) / 2 || j == (3 * h + 1) / 2 - i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();        //第 i 行打印完换行
        }
    }
    public static void main(String[] args){
        Test2 b = new Test2();                    //初始化方法
        int a = 35;                               //赋值并执行draw方法
        b.draw(a);
    }
}
