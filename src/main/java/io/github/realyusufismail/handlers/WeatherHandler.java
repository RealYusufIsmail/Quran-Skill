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
package io.github.realyusufismail.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import io.github.realyusufismail.utils.WeatherRetriever;
import java.util.Optional;

public class WeatherHandler implements RequestHandler {

  @Override
  public boolean canHandle(HandlerInput handlerInput) {
    return handlerInput.matches(intentName("WeatherIntent"));
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput) {
    final var city = handlerInput.getRequestEnvelope().getRequest().getLocale();
    final var weather = WeatherRetriever.getWeather(city);
    final var speechText = "The weather in " + city + " is " + weather;
    return handlerInput
        .getResponseBuilder()
        .withSpeech(speechText)
        .withSimpleCard("Weather", speechText)
        .build();
  }
}
