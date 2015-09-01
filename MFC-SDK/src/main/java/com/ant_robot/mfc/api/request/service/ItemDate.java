package com.ant_robot.mfc.api.request.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemDate {
  private static final ThreadLocal<DateFormat> DF = new ThreadLocal<DateFormat>() {
    @Override public DateFormat initialValue() {
      return new SimpleDateFormat("yyyy-MM-dd");
    }
  };

  private final Date date;

  public ItemDate(Date date) {
    this.date = date;
  }

  @Override public String toString() {
    return DF.get().format(date);
  }
}