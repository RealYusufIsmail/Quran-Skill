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
import static io.github.realyusufismail.utils.Utils.getAudioPlayerState;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.audioplayer.AudioPlayerState;
import java.util.Optional;

public class AudioPlayerEventHandler implements RequestHandler {

  @Override
  public boolean canHandle(HandlerInput handlerInput) {
    return handlerInput.matches(intentName("AudioPlayer.PlaybackStarted"))
        || handlerInput.matches(intentName("AudioPlayer.PlaybackFinished"))
        || handlerInput.matches(intentName("AudioPlayer.PlaybackStopped"))
        || handlerInput.matches(intentName("AudioPlayer.PlaybackNearlyFinished"))
        || handlerInput.matches(intentName("AudioPlayer.PlaybackFailed"));
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {
    var audioPlayer = getAudioPlayerState(handlerInput);
    var audioPlayerEventName =
        handlerInput.getRequestEnvelope().getRequest().getType().split("\\.")[1];
    var returnResponseFlag = false;
    switch (audioPlayerEventName) {
      case "PlaybackStarted":
        {
          AudioPlayerState.builder()
              .withToken(
                  handlerInput.getRequestEnvelope().getContext().getSystem().getApiAccessToken())
              .build();
        }
      case "PlaybackFinished":
        {
          returnResponseFlag = true;
        }
      default:
        break;
    }
    if (returnResponseFlag) {
      return handlerInput.getResponseBuilder().build();
    } else {
      return Optional.empty();
    }
  }
}
