/**
 * (C) Copyright 2024 Araf Karsh Hamid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fusion.air.microservice.ai.examples.openai;


import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;

import io.fusion.air.microservice.ai.core.assistants.Assistant;
import io.fusion.air.microservice.ai.core.tools.CalculatorTool;
import io.fusion.air.microservice.ai.utils.AiBeans;
import io.fusion.air.microservice.ai.utils.AiConstants;

/**
 * @author: Araf Karsh Hamid
 * @version:
 * @date:
 */
public class _06_Tools_Example {

    public static void main(String[] args) {
        // Create Chat Language Model - Open AI GPT 4o
        ChatLanguageModel model = AiBeans.getChatLanguageModelOpenAi(AiConstants.GPT_4o);
        AiBeans.printModelDetails(AiConstants.LLM_OPENAI, AiConstants.GPT_4o);

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .tools(new CalculatorTool())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        String question1 = "What is the square root of the sum of the numbers of letters in the words \"Hello\" and \"my Fusion world\"?";
        String answer1 = assistant.chat(question1);
        AiBeans.printResult(question1, answer1);

        // The square root of the sum of the number of letters in the words "hello" and "world" is approximately 4.47.
        String question2 = "What is the sum of the numbers of letters in the words \"Hello\" and \"my Fusion world\"?";
        String answer2 = assistant.chat(question2);
        AiBeans.printResult(question2, answer2);
    }
}
