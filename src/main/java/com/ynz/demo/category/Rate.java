package com.ynz.demo.category;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.YearMonth;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Rate {
  private UUID clientId;
  private YearMonth date;
  private int score;
}
