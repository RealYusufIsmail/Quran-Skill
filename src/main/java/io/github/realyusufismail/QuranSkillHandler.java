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
package io.github.realyusufismail;

import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import io.github.realyusufismail.handlers.basic.LaunchRequestHandler;
import io.github.realyusufismail.handlers.basic.WelcomeRequestHandler;
import io.github.realyusufismail.handlers.quran.QuranHandler;

@SuppressWarnings("unused")
public class QuranSkillHandler extends SkillStreamHandler {

  public QuranSkillHandler() {
    super(
        Skills.standard()
            .addRequestHandlers(
                new WelcomeRequestHandler(), new LaunchRequestHandler(), new QuranHandler())
            .build());
  }
}
