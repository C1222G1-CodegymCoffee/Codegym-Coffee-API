package com.example.codegym_coffee.service.bill;

import com.example.codegym_coffee.model.BillDetail;

import java.util.List;

public interface IBillDTService {
    List<BillDetail> getBillDetail(Integer idBill);
}
