package dat11.behavioralPattern.state.easy;

/**
 * 电梯接口
 * 每个电梯都有
 * 开门 open
 * 关门 close
 * 运行 run
 * 停止 stop
 */
public interface ILift {
    //电梯的四个状态
    public final static int OPENING_STATE = 1; //门敞状态
    public final static int CLOSING_STATE = 2; //门闭状态
    public final static int RUNNING_STATE = 3; //运行状态
    public final static int STOPPING_STATE = 4; //停止状态；

    public void setState(int state);

    public void open();
    public void close();
    public void run();
    public void stop();
}
