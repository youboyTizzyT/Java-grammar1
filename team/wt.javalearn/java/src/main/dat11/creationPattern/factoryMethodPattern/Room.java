package dat11.creationPattern.factoryMethodPattern;

public abstract class Room {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void relax() {
        System.out.println("in "+this.getName()+" relax");
    }
}
