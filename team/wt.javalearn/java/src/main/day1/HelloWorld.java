package day1;

/**
 * @author weicong
 * @date 2018/3/16 0016
 */
public class HelloWorld {
    public static void main(String[] args) {
        /*
         *  java中使用System.out.println("内容")进行输出
         *
         *  此处注意，main 是一个程序的入口，一个 java 程序运行必须而且有且仅有一个 main 方法。
         *  args[0] 是你传入的第一个参数，args[1]是传入的第二个参数
         */
        System.out.println("Hello World");
//        System.out.println(args[0]);  // 在idea里面没法执行.只能出去使用java -cp 执行,可以获取参数
        // 这是我们的第一个程序,时隔3年,重新打些这个例子,有些怀念大二的时光
        /*
         * 这里记一下java的一些专业术语.
         * JDK（Java Development Kit ）：编写Java程序的程序员使用的软件
         * JRE（Java Runtime Environment）：运行Java程序的用户使用的软件
         * Server JRE （Java SE Runtime Environment）：服务端使用的 Java 运行环境
         * SDK（Software Development Kit）：软件开发工具包，在Java中用于描述1998年~2006年之间的JDK
         * DAO（Data Access Object）：数据访问接口，数据访问，顾名思义就是与数据库打交道(在Spring中经常使用DAO)  当然,在
         * 我编写的时候,经常与Model搞混了
         * MVC（Model View Controller）：模型(model)－视图(view)－控制器(controller)的缩写，一种软件设计典范，用于组织代码用一种业务逻辑和数据显示分离的方法
         *
         */
    }
}
