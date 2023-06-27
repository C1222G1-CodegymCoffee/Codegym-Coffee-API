package com.example.codegym_coffee.service.bill;

import com.example.codegym_coffee.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IBillService {
    Page<Bill> showBill(Pageable pageable);
}
