package com.example.codegym_coffee.service.bill.impl;

import com.example.codegym_coffee.model.BillDetail;
import com.example.codegym_coffee.repository.bill.IBillDTRepository;
import com.example.codegym_coffee.service.bill.IBillDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDTService implements IBillDTService {
    @Autowired
    private IBillDTRepository billDTRepository;

    @Override
    public List<BillDetail> getBillDetail(Integer idBill) {
        return billDTRepository.getByIdBill(idBill);
    }
}
