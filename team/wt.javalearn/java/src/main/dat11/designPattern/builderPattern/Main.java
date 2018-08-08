package dat11.designPattern.builderPattern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 创建建造者的实例
        Builder builder=new Builder();
        builder.makeBabysB(10);
        List<Baby> list=builder.getList();
        for (Baby baby:list) {
            System.out.println(baby.name);
        }
    }
}
