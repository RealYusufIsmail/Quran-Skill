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

public enum Strings {
  WELCOME(
      "Welcome to the weather skill, you can ask me for the weather in a city located in the United Kingdom"),
  HELP("You can ask me for the weather in a city located in the United Kingdom"),
  ERROR("Sorry, I couldn't understand what you said. Please try again."),
  STOP("Goodbye!");

  private final String value;

  Strings(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
