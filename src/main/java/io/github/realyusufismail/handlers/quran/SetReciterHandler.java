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
import static io.github.realyusufismail.utils.Utils.getIntent;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import io.github.realyusufismail.utils.QuranUtils;
import java.util.Optional;

public class SetReciterHandler implements RequestHandler {

  @Override
  public boolean canHandle(HandlerInput handlerInput) {
    return handlerInput.matches(intentName("SetReciterIntent"));
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {
    var reciterNumber = getIntent(handlerInput).getSlots().get("reciterNumber").getValue();
    var reciterName = QuranUtils.getReciterName(Integer.parseInt(reciterNumber));
    var reciter = QuranUtils.getReciter(reciterName);
    if (reciter == null) {
      return handlerInput
          .getResponseBuilder()
          .withSpeech(
              "Sorry, I couldn't find that reciter, to see the list of reciters, say list reciters")
          .build();
    }

    var sessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
    sessionAttributes.put("reciter", reciter);
    return handlerInput
        .getResponseBuilder()
        .withSpeech("Reciter set to " + reciter.getName())
        .build();
  }
}
