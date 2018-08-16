package day11.behavioralPattern.mediator;

public class ConcreteMediator extends Mediator {
    public ColleagueA getColleagueA() {
        return colleagueA;
    }

    public void setColleagueA(ColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public CollegaueB getCollegaueB() {
        return collegaueB;
    }

    public void setCollegaueB(CollegaueB collegaueB) {
        this.collegaueB = collegaueB;
    }

    ColleagueA colleagueA;
    CollegaueB collegaueB;
    @Override
    public void contact(String content, Colleague coll) {
        if (coll==colleagueA) {
            colleagueA.getMessage(content);
        } else {
            collegaueB.getMessage(content);
        }
    }
}
