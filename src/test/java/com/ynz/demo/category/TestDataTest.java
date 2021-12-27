package com.ynz.demo.category;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
class TestDataTest {

  @Test
  void genRandomRating() {
    var rateList = TestData.instance().genTestRates();
    log.info("rate list: {}", rateList);
    assertThat(rateList, Matchers.hasSize(4));
  }
}
