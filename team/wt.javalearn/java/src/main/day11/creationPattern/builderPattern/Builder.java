package day11.creationPattern.builderPattern;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private List<Baby> list=new ArrayList<>();
    public void makeBabysA(int count){
        for (int i=0;i<count;i++){
            list.add(new BabyA());
        }
    }
    public void makeBabysB(int count){
        for (int i=0;i<count;i++){
            list.add(new BabyB());
        }
    }

    public List<Baby> getList() {
        return list;
    }
}
