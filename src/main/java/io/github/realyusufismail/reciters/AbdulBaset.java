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
package io.github.realyusufismail.reciters;

public class AbdulBaset implements Reciter {
  @Override
  public String getName() {
    return "AbdulBaset AbdulSamad";
  }

  @Override
  public String getAudioUrl() {
    return "https://download.quranicaudio.com/qdc/abdul_baset/mujawwad/";
  }

  @Override
  public int getReciterNumber() {
    return 1;
  }

  @Override
  public String getSurahUrl(int surahNumber) {
    return getAudioUrl() + surahNumber + ".mp3";
  }
}
