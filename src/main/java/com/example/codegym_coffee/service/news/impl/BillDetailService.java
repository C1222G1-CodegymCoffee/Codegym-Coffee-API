package com.example.codegym_coffee.service.news.impl;

import com.example.codegym_coffee.dto.sale.BillDetailDTO;
import com.example.codegym_coffee.repository.sale.IBillDetailRepository;
import com.example.codegym_coffee.service.news.IBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailService implements IBillDetailService {
    @Autowired
    private IBillDetailRepository billDetailRepository;


    @Override
    public List<BillDetailDTO> getBillDetailsAndTotalAmountByTableId(int tableId) {
        return billDetailRepository.getBillDetailsAndTotalAmountByTableId(tableId);
    }

    @Override
    public List<BillDetailDTO> resetTable(int tableId) {
        return billDetailRepository.resetTable(tableId);
    }
}
