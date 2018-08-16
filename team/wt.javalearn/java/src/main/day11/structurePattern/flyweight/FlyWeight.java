package day11.structurePattern.flyweight;

public class FlyWeight {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public FlyWeight(String name) {
        System.out.println("初始化"+name);
        this.name = name;
    }
}
