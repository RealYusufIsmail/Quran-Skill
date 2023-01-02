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
package io.github.realyusufismail.utils;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.interfaces.audioplayer.AudioPlayerState;

public class Utils {
  public static Intent getIntent(HandlerInput handlerInput) {
    var request = handlerInput.getRequestEnvelope().getRequest();
    var intentRequest = (IntentRequest) request;
    return intentRequest.getIntent();
  }

  public static boolean checkSlot(Intent intent, String slotName) {
    return intent.getSlots().containsKey(slotName)
        || intent.getSlots().get(slotName).getValue() != null;
  }

  public static AudioPlayerState getAudioPlayerState(HandlerInput handlerInput) {
    return handlerInput.getRequestEnvelope().getContext().getAudioPlayer();
  }
}
