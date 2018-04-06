public class test1 {
    public static void main(String[] args) {
        AAA.aaa=1;
        System.out.println(AAA.aaa);
    }
}
class AAA{
    static{
        System.out.println("AAA 类初始化");
        aaa=2;
    }

    static int aaa=10;
    static void aaa(){
        System.out.println("1111");
    }
}
