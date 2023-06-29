package com.example.codegym_coffee.dto.satistic;

import java.util.Date;

public interface StatisticDTO {
    Date getDateAfter();
    Date getDateBefore();
    Double getTotalBill();
    Date getDayOfBill();
}
