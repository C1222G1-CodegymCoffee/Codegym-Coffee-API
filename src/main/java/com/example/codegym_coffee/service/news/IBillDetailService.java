package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.dto.news.BillDetailDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillDetailService {
    List<BillDetailDTO> getBillDetailsAndTotalAmountByTableId(int tableId);
}
