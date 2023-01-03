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

import static io.github.realyusufismail.utils.Utils.getAudioPlayerState;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.audioplayer.PlayBehavior;
import io.github.realyusufismail.reciters.Reciter;
import io.github.realyusufismail.utils.QuranUtils;
import java.util.Optional;

public class NextIntentHandler implements RequestHandler {
  @Override
  public boolean canHandle(HandlerInput handlerInput) {
    return false;
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {
    var currenSurahNumber =
        handlerInput.getAttributesManager().getSessionAttributes().get("surahNumber");
    if (currenSurahNumber == null) {
      handlerInput
          .getResponseBuilder()
          .withSpeech(
              "You haven't started listening to any surah yet. Please start listening to a surah first.")
          .withShouldEndSession(false);
    }

    var newSurahNumber = Integer.parseInt((String) currenSurahNumber) + 1;

    if (newSurahNumber > 114) {
      handlerInput
          .getResponseBuilder()
          .withSpeech(
              "You have reached the end of the Quran. Please start listening to a surah first.")
          .withShouldEndSession(false);
    }

    handlerInput
        .getAttributesManager()
        .getSessionAttributes()
        .put("surahNumber", String.valueOf(newSurahNumber));

    final var newSurahName = QuranUtils.getSuraName(newSurahNumber);

    var reciter =
        (Reciter) handlerInput.getAttributesManager().getSessionAttributes().get("reciter");

    if (reciter == null) {
      reciter = Reciter.DEFAULT_RECITER;
    }

    final var surahUrl = reciter.getSurahUrl(newSurahNumber);

    var audioPlayer = getAudioPlayerState(handlerInput);
    var token = audioPlayer.getToken();
    var offsetInMilliseconds = audioPlayer.getOffsetInMilliseconds();

    return handlerInput
        .getResponseBuilder()
        .withSpeech("Playing surah " + newSurahName + " from " + reciter.getName())
        .withShouldEndSession(false)
        .addAudioPlayerPlayDirective(
            PlayBehavior.REPLACE_ALL, offsetInMilliseconds, "", token, surahUrl)
        .build();
  }
}
