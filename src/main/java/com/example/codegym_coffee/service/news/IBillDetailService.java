package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.dto.sale.BillDetailDTO;

import java.util.List;

public interface IBillDetailService {
    List<BillDetailDTO> getBillDetailsAndTotalAmountByTableId(int tableId);

    List<BillDetailDTO> resetTable(int tableId);
}
