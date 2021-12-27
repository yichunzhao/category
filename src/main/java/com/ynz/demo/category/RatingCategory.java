package com.ynz.demo.category;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
public class RatingCategory {

  public static void main(String[] args) {

    var rateList = TestData.instance().genTestRates();

    var scoreRateListMap = rateList.stream().collect(Collectors.groupingBy(Rate::getScore));
    log.info("Score RateList Map: {}", scoreRateListMap);

    var scoreGreaterEqualToScoreFour =
        rateList.stream().collect(Collectors.partitioningBy(rate -> rate.getScore() >= 4));
    log.info("score greaterThanAndEqualTo 4, RateList: {}", scoreGreaterEqualToScoreFour.get(true));
    log.info("score lessThan 4, RateList: {}", scoreGreaterEqualToScoreFour.get(false));
  }
}
