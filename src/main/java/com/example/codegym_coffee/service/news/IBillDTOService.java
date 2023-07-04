package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.model.Bill;

public interface IBillDTOService {
    Bill findByIdBill(int id);
}
