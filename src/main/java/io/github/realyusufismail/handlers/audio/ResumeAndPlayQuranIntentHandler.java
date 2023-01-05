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

import static com.amazon.ask.request.Predicates.intentName;
import static io.github.realyusufismail.utils.Utils.*;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.audioplayer.PlayBehavior;
import io.github.realyusufismail.reciters.Reciter;
import io.github.realyusufismail.utils.QuranUtils;
import java.util.Optional;

public class ResumeAndPlayQuranIntentHandler implements RequestHandler {
  @Override
  public boolean canHandle(HandlerInput handlerInput) {
    if (handlerInput.matches(intentName("AMAZON.ResumeIntent"))) {
      return true;
    } else return handlerInput.matches(intentName("PlayQuranIntent"));
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {

    if (!getIntent(handlerInput).getSlots().containsKey("surahNumber")) {
      return handlerInput
          .getResponseBuilder()
          .withSpeech("Please provide a surah number")
          .withShouldEndSession(false)
          .build();
    }

    var requestedSurahNumber = getIntent(handlerInput).getSlots().get("surahNumber").getValue();

    final var surahNumber =
        QuranUtils.checkIfSurahNumberIsIntegerOrStringToInteger(requestedSurahNumber);

    if (surahNumber == null) {
      return handlerInput
          .getResponseBuilder()
          .withSpeech("Sorry, You have said an invalid surah number. Please try again.")
          .withShouldEndSession(false)
          .build();
    }

    final var surahName = QuranUtils.getSuraName(surahNumber);
    var reciter =
        (Reciter) handlerInput.getAttributesManager().getSessionAttributes().get("reciter");

    if (reciter == null) {
      reciter = Reciter.DEFAULT_RECITER;
    }

    final var surahUrl = reciter.getSurahUrl(surahNumber);

    var audioPlayer = getAudioPlayerState(handlerInput);
    var token = audioPlayer.getToken();
    var offsetInMilliseconds = audioPlayer.getOffsetInMilliseconds();

    // set the current surah number to the session attributes
    handlerInput.getAttributesManager().getSessionAttributes().put("surahNumber", surahNumber);

    return handlerInput
        .getResponseBuilder()
        .withSpeech("Playing surah " + surahName + " from " + reciter.getName())
        .withShouldEndSession(false)
        .addAudioPlayerPlayDirective(
            PlayBehavior.REPLACE_ALL, offsetInMilliseconds, "", token, surahUrl)
        .build();
  }
}
