import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.ActionCardAction;
import com.dingtalk.chatbot.message.ActionCardMessage;

import java.io.IOException;

/**
 * Create by weicong on 2018/9/19
 */
public class DingDingRobTest {

    public static void main(String[] args) throws IOException {
        DingtalkChatbotClient client = new DingtalkChatbotClient();
        ActionCardMessage message = new ActionCardMessage();
        message.setBriefText("亲，小秘没有看懂你的问题哦，换个说法问问小秘看~你也可以试试以下问题");
        ActionCardAction action1 = new ActionCardAction("考勤打卡", "http://www.dingtalk.com");
        message.addAction(action1);
        ActionCardAction action2 = new ActionCardAction("办公电话", "http://www.dingtalk.com");
        message.addAction(action2);
        ActionCardAction action3 = new ActionCardAction("智能客服", "http://www.dingtalk.com");
        message.addAction(action3);
        ActionCardAction action4 = new ActionCardAction("更多问题", "http://www.dingtalk.com");
        message.addAction(action4);
        SendResult result = client.send("https://oapi.dingtalk.com/robot/send?access_token=44cebb83151f9151dba5e304271aac5aa2f401101dae0207950adf40ed5e4be5", message);
        System.out.println(result);
    }
}
