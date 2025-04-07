# Spring AI 集成 LLMs 

针对支持的每种 LLM Spring AI 都有提供对应的集成文档。比如：[智谱 AI 聊天模型](https://docs.spring.io/spring-ai/reference/1.0/api/chat/zhipuai-chat.html)

因为每种模型功能接口都可能有细微的差别，所以需要分别进行适配，所以有很多适配依赖，如：spring-ai-zhipuai、spring-ai-openai、spring-ai-ollama 等等。

**集成流程**（zhipuai）：

1. 添加仓库和BOM

2. 配置

   分为自动配置和手动配置，手动配置只需要添加 `spring-ai-zhipuai` 依赖。

   聊天模型配置项有三种（只列举重要配置项）：

   + 重试属性

   + 连接属性

     + spring.ai.zhipuai.base-url 

       模型服务 URL。

     + spring.ai.zhipuai.api-key

       模型用户 API Key。

   + 配置属性

     + spring.ai.zhipuai.chat.enabled

       启用 ZhiPuAI 聊天模型。

     + spring.ai.zhipuai.chat.options.model

       ZhiPuAI 聊天模型实际使用的模型。

     + spring.ai.zhipuai.chat.options.maxTokens

       聊天完成时生成的最大标记数。输入标记和生成的标记的总长度受模型上下文长度的限制。

     + spring.ai.zhipuai.chat.options.temperature

       使用何种采样温度，介于 0 和 1 之间。更高的值如 0.8 将使输出更随机，而更低的值如 0.2 将使其更集中和确定性。

     + spring.ai.zhipuai.chat.options.topP

     + spring.ai.zhipuai.chat.options.stop

       模型停止生成时会生成 stop 指定的字符。

**聊天调用**：

从一些Demo项目中看到有三种调用方式：

+ **Low-Level API**

  是一种低级客户端（即基础的客户端），比如智谱AI对应 ZhiPuAiAPI。

  封装了两种HTTP客户端，一种同步阻塞式，一种响应式。

  ```java
  private final RestClient restClient;
  private final WebClient webClient;
  ```

+ ChatClient 

  封装 **Low-Level API** 实现，旧版本使用。

+ **ChatModel**

  封装 **Low-Level API** 实现，貌似是 ChatClient 重名为了 ChatModel，因为看内部某些字段是相同的，ChatModel 还拓展了新属性，新版本（当前是 1.0.0-M6）已经没有 ChatClient 了；
  比如智谱AI对应 ZhiPuAiChatModel。

  > 1.0.0-M6 使用自动配置的话（starter）客户端只需要关注 ChatModel 即可。