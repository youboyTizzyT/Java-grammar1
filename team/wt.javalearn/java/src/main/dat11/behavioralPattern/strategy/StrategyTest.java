package dat11.behavioralPattern.strategy;

public class StrategyTest {
    public static void main(String[] args) {
//        策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可。
        String exp="39+2";
        ICalculator cal=new Plus();
        System.out.println(cal.calculate(exp));
    }
}
