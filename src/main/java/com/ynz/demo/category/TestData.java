package com.ynz.demo.category;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.NONE)
public class TestData {
  public static List<UUID> clientIds =
      List.of(
          UUID.randomUUID(),
          UUID.randomUUID(),
          UUID.randomUUID(),
          UUID.randomUUID(),
          UUID.randomUUID(),
          UUID.randomUUID());

  public static List<YearMonth> yearMonths =
      List.of(
          YearMonth.of(2001, 10),
          YearMonth.of(2001, 10),
          YearMonth.of(2002, 11),
          YearMonth.of(2003, 12),
          YearMonth.of(2004, 9),
          YearMonth.of(2004, 9));

  public static List<Integer> rates = List.of(5, 4, 4, 2, 3, 1);

  public List<Rate> genTestRates() {
    List<Rate> rateList = new ArrayList<>();
    IntStream.range(0, clientIds.size())
        .forEach(i -> rateList.add(new Rate(clientIds.get(i), yearMonths.get(i), rates.get(i))));
    return rateList.stream().collect(Collectors.toUnmodifiableList());
  }

  public static TestData instance() {
    return new TestData();
  }
}
