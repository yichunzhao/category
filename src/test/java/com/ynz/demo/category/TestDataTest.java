package com.ynz.demo.category;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

class TestDataTest {

  @Test
  void genRandomRating() {
    var ratings = new ArrayList<>();
    IntStream.range(0, 15).forEach(i -> ratings.add(TestData.generator().genRandomRating()));

    ratings.forEach(
        rating ->
            assertThat(rating, anyOf(equalTo(1), equalTo(2), equalTo(3), equalTo(4), equalTo(5))));
  }
}
