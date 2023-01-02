/*
 * Copyright 2022 YDWK inc.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package io.github.realyusufismail.handlers.audio;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CancelIntentHandler implements RequestHandler {
  @Override
  public boolean canHandle(com.amazon.ask.dispatcher.request.handler.HandlerInput handlerInput) {
     if (handlerInput.matches(intentName("AMAZON.CancelIntent"))) {
       return true;
     } else return handlerInput.matches(intentName("AMAZON.StopIntent"));
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {
    return handlerInput.getResponseBuilder()
        .withSpeech("Ok, see you next time!")
        .withShouldEndSession(true)
        .build();
  }
}
