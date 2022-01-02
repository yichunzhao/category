package com.ynz.demo.category;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RatingCategory {

  public static void main(String[] args) {
    var rateList = TestData.instance().genTestRates();
    log.info("rate list: {}", rateList);
    var scoreRateListMap = rateList.stream().collect(Collectors.groupingBy(Rate::getScore));
    log.info("Score RateList Map: {}", scoreRateListMap);

    var scoreGreaterEqualToScoreFour =
        rateList.stream().collect(Collectors.partitioningBy(rate -> rate.getScore() >= 4));
    log.info("score greaterThanAndEqualTo 4, RateList: {}", scoreGreaterEqualToScoreFour.get(true));
    log.info("score lessThan 4, RateList: {}", scoreGreaterEqualToScoreFour.get(false));

    var min = rateList.stream().min(Rate::compareTo);
    log.info("Rate having min score: {} ", min.isPresent() ? min.get() : "not present!");

    var max = rateList.stream().max(Rate::compareTo);
    log.info("Rate having max score: {} ", max.isPresent() ? max.get() : "not present!");

    // teeing both Collectors in one statement,and then merging both results together.
    var teeingBoth =
        rateList.stream()
            .collect(
                Collectors.teeing(
                    Collectors.maxBy(Rate::compareTo),
                    Collectors.minBy(Rate::compareTo),
                    List::of));
    log.info("teeing both max and min: {}", teeingBoth);

    var sortedRatesByScore = rateList.stream().sorted().toList();
    log.info("sorted rate by natural order: {} ", sortedRatesByScore);

    // drop while is applied on a sorted stream
    var scoreLessEqualToThree =
        rateList.stream().sorted().dropWhile(rate -> rate.getScore() <= 3).toList();
    log.info("rates score <= 3 {} ", scoreLessEqualToThree);

    log.info("rate list: {}", rateList);

    // drop while on un-ordered stream
    // As per the API documentation, when the dropWhile is applied on an unordered Stream, it can
    // drop any subset of matching elements, but the behavior is non-deterministic and so it may
    // return a different result each time. So basically, what this means is that the dropWhile
    // method may or may not drop a subset of elements that match the specified Predicate.
    var scoreLessEqualToThreeNotOrdered =
        rateList.stream().dropWhile(rate -> rate.getScore() <= 3).toList();
    log.info("rates score <= 3 {} ", scoreLessEqualToThreeNotOrdered);
  }
}
