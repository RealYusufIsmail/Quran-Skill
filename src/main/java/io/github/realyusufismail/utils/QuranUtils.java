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

import io.github.realyusufismail.reciters.*;
import java.util.HashMap;
import java.util.Map;

public class QuranUtils {
  public static Map<String, Integer> surahNamesAndNumbers =
      new HashMap<>() {
        {
          put("Al-Fatihah", 1);
          put("Al-Baqarah", 2);
          put("Aal-e-Imran", 3);
          put("An-Nisa", 4);
          put("Al-Ma'idah", 5);
          put("Al-An'am", 6);
          put("Al-A'raf", 7);
          put("Al-Anfal", 8);
          put("At-Taubah", 9);
          put("Yunus", 10);
          put("Hud", 11);
          put("Yusuf", 12);
          put("Ar-Ra'd", 13);
          put("Ibrahim", 14);
          put("Al-Hijr", 15);
          put("An-Nahl", 16);
          put("Al-Isra", 17);
          put("Al-Kahf", 18);
          put("Maryam", 19);
          put("Ta-Ha", 20);
          put("Al-Anbiya", 21);
          put("Al-Haj", 22);
          put("Al-Mu'minun", 23);
          put("An-Nur", 24);
          put("Al-Furqan", 25);
          put("Ash-Shu'ara", 26);
          put("An-Naml", 27);
          put("Al-Qasas", 28);
          put("Al-Ankabut", 29);
          put("Ar-Rum", 30);
          put("Luqman", 31);
          put("As-Sajdah", 32);
          put("Al-Ahzab", 33);
          put("Saba", 34);
          put("Al-Fatir", 35);
          put("Ya-Sin", 36);
          put("As-Saffah", 37);
          put("Sad", 38);
          put("Az-Zumar", 39);
          put("Ghafir", 40);
          put("Fussilat", 41);
          put("Ash-Shura", 42);
          put("Az-Zukhruf", 43);
          put("Ad-Dukhan", 44);
          put("Al-Jathiya", 45);
          put("Al-Ahqaf", 46);
          put("Muhammad", 47);
          put("Al-Fath", 48);
          put("Al-Hujurat", 49);
          put("Qaf", 50);
          put("Adh-Dhariyat", 51);
          put("At-Tur", 52);
          put("An-Najm", 53);
          put("Al-Qamar", 54);
          put("Ar-Rahman", 55);
          put("Al-Waqi'ah", 56);
          put("Al-Hadid", 57);
          put("Al-Mujadilah", 58);
          put("Al-Hashr", 59);
          put("Al-Mumtahanah", 60);
          put("As-Saff", 61);
          put("Al-Jumu'ah", 62);
          put("Al-Munafiqun", 63);
          put("At-Taghabun", 64);
          put("At-Talaq", 65);
          put("At-Tahrim", 66);
          put("Al-Mulk", 67);
          put("Al-Qalam", 68);
          put("Al-Haqqah", 69);
          put("Al-Ma'arij", 70);
          put("Nuh", 71);
          put("Al-Jinn", 72);
          put("Al-Muzzammil", 73);
          put("Al-Muddaththir", 74);
          put("Al-Qiyamah", 75);
          put("Al-Insan", 76);
          put("Al-Mursalat", 77);
          put("An-Naba’", 78);
          put("An-Nazi’at", 79);
          put("‘Abasa", 80);
          put("At-Takwir", 81);
          put("Al-Infitar", 82);
          put("Al-Mutaffifin", 83);
          put("Al-Inshiqaq", 84);
          put("Al-Buruj", 85);
          put("At-Tariq", 86);
          put("Al-A’la", 87);
          put("Al-Ghashiyah", 88);
          put("Al-Fajr", 89);
          put("Al-Balad", 90);
          put("Ash-Shams", 91);
          put("Al-Layl", 92);
          put("Adh-Dhuha", 93);
          put("Al-Inshirah", 94);
          put("At-Tin", 95);
          put("Al-‘Alaq", 96);
          put("Al-Qadar", 97);
          put("Al-Bayinah", 98);
          put("Az-Zalzalah", 99);
          put("Al-‘Adiyah", 100);
          put("Al-Qari’ah", 101);
          put("At-Takathur", 102);
          put("Al-‘Asr", 103);
          put("Al-Humazah", 104);
          put("Al-Fil", 105);
          put("Quraish", 106);
          put("Al-Ma’un", 107);
          put("Al-Kauthar", 108);
          put("Al-Kafirun", 109);
          put("An-Nasr", 110);
          put("Al-Masad", 111);
          put("Al-Ikhlas", 112);
          put("Al-Falaq", 113);
          put("An-Nas", 114);
        }
      };

  public static String getSuraName(int suraNumber) {
    for (Map.Entry<String, Integer> entry : surahNamesAndNumbers.entrySet()) {
      if (entry.getValue().equals(suraNumber)) {
        return entry.getKey();
      }
    }
    return null;
  }

  public static Reciter getReciter(String reciterName) {
    switch (reciterName) {
      case "AbdulBaset AbdulSamad":
        return new AbdulBaset();
      case "Mishari Rashid al-`Afasy":
        return new Afasy();
      case "Mahmoud Khalil Al-Husary":
        return new Husary();
      case "Mohamed Siddiq al-Minshawi":
        return new Minshawi();
      case "Hani ar-Rifai":
        return new Rifai();
      case "Abu Bakr al-Shatri":
        return new Shatri();
      case "Sa`ud ash-Shuraym":
        return new Shuraym();
      case "Abdur-Rahman as-Sudais":
        return new Sudais();
      case "Khalifah Taniji":
        return new Taniji();
      default:
        return null;
    }
  }

  public static Map<String, Integer> getRecitersAndAssociatedNumber() {
    return Map.of(
        "AbdulBaset AbdulSamad", 1,
        "Mishari Rashid al-`Afasy", 2,
        "Mahmoud Khalil Al-Husary", 3,
        "Mohamed Siddiq al-Minshawi", 4,
        "Hani ar-Rifai", 5,
        "Abu Bakr al-Shatri", 6,
        "Sa`ud ash-Shuraym", 7,
        "Abdur-Rahman as-Sudais", 8,
        "Khalifah Taniji", 9);
  }

  public static String getReciterName(int number) {
    return getRecitersAndAssociatedNumber().entrySet().stream()
        .filter(entry -> entry.getValue() == number)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown reciter number: " + number));
  }

  public static Integer checkIfSurahNumberIsIntegerOrStringToInteger(String requestedSurahNumber) {
    int surahNumber;
    try {
      surahNumber = Integer.parseInt(requestedSurahNumber);
    } catch (NumberFormatException e) {
      // check if the string name is a number and convert it to an integer
      if (isNumeric(requestedSurahNumber)) {
        surahNumber = Integer.parseInt(requestedSurahNumber);
      } else {
        return null;
      }
    }

    if (surahNumber < 1 || surahNumber > 114) {
      return null;
    }

    return surahNumber;
  }

  static boolean isNumeric(String c) {
    return c.matches("-?\\d+(\\.\\d+)?");
  }
}
