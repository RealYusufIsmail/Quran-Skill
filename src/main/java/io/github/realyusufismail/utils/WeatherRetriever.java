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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.realyusufismail.jconfig.util.JConfigUtils;
import java.io.IOException;
import java.util.Objects;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherRetriever {
  public static String getWeather(String city) {
    OkHttpClient client = new OkHttpClient();

    HttpUrl.Builder urlBuilder =
        HttpUrl.parse(
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast")
            .newBuilder();
    urlBuilder
        .addQueryParameter("aggregateHours", "24")
        .addQueryParameter("contentType", "json")
        .addQueryParameter("unitGroup", "metric")
        .addQueryParameter("locationMode", "single")
        .addQueryParameter("key", JConfigUtils.getString("weatherKey"))
        .addQueryParameter("locations", city + ",Uk");
    String url = urlBuilder.build().toString();

    Request request = new Request.Builder().url(url).build();

    JsonNode jsonNode;
    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

      jsonNode = new ObjectMapper().readTree(Objects.requireNonNull(response.body()).string());
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

    JsonNode values = jsonNode.get("location").get("values");

    // get the conditions and percentage for snow and rain

    for (JsonNode value : values) {
      double snow = value.get("snow").asDouble();
      double rain = value.get("precip").asDouble();
      double temp = value.get("temp").asDouble();
      String conditions = value.get("conditions").asText();
      if (snow > 0 && rain > 0) {
        return conditions
            + " with "
            + snow
            + "cm of snow and "
            + rain
            + "mm of rain and a temperature of "
            + temp
            + " degrees";
      } else if (snow > 0) {
        return conditions
            + " with "
            + snow
            + "cm of snow and a temperature of "
            + temp
            + " degrees";
      } else if (rain > 0) {
        return conditions
            + " with "
            + rain
            + "mm of rain and a temperature of "
            + temp
            + " degrees";
      } else {
        return conditions + " with a temperature of " + temp + " degrees";
      }
    }

    return "No weather found";
  }
}
