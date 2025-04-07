package top.kwseeker.ai.chat.web.app;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootTest
@ComponentScan(basePackages = {"top.kwseeker.ai.chat.web"})
public class ChatClientTest {

    @Resource
    private ZhiPuAiChatModel chatModel;

    @Test
    public void testChatClient() {
        ChatResponse response = chatModel.call(new Prompt("1+2=?"));
        log.info("测试结果(call):{}", JSON.toJSONString(response));
    }
}
