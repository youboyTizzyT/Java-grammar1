package day11.structurePattern.decorator;

public class Main {
    public static void main(String[] args) {
        /**
         * 从程序的角度来看，封装给程序猿看的完全是Sourceable接口一模一样
         * 但是会从中进行一些操作，再之前或者之后，和SpringAop一样。
         */
        Sourceable souece=new Source();
        Sourceable obj=new Decorator(souece);
        obj.method();
    }
}
