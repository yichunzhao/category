package com.ynz.demo.category;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.YearMonth;
import java.util.Random;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.NONE)
public class TestData {

  public Rate genClientRatingByYearMonth(UUID clientId, YearMonth yearMonth, int rate) {
    return new Rate(clientId, yearMonth, rate);
  }

  public int genRandomRating() {
    return new Random().nextInt(5) + 1;
  }

  public static TestData generator() {
    return new TestData();
  }
}
