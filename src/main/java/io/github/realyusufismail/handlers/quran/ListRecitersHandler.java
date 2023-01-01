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
package io.github.realyusufismail.handlers.quran;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import io.github.realyusufismail.utils.QuranUtils;
import java.util.Optional;

public class ListRecitersHandler implements RequestHandler {
  @Override
  public boolean canHandle(HandlerInput handlerInput) {
    return handlerInput.matches(intentName("ListRecitersIntent"));
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {
    var reciters = QuranUtils.getRecitersAndAssociatedNumber();
    var recitersNames = reciters.keySet();
    var recitersNumbers = reciters.values();
    StringBuilder recitersList = new StringBuilder();
    for (var i = 0; i < recitersNames.size(); i++) {
      recitersList
          .append(recitersNames.toArray()[i])
          .append(" with number ")
          .append(recitersNumbers.toArray()[i])
          .append(", ");
    }
    return handlerInput
        .getResponseBuilder()
        .withSpeech("The list of reciters is " + recitersList)
        .build();
  }
}
