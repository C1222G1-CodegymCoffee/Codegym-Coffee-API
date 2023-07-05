package com.example.codegym_coffee.dto.sale;

import java.util.List;

public class BillDTO {
    private List<BillDetailDTO> billDetailDTOS;

    private Integer billId;

    public BillDTO(List<BillDetailDTO> billDetailDTOS, Integer billId) {
        this.billDetailDTOS = billDetailDTOS;
        this.billId = billId;
    }

    public List<BillDetailDTO> getBillDetailDTOS() {
        return billDetailDTOS;
    }

    public void setBillDetailDTOS(List<BillDetailDTO> billDetailDTOS) {
        this.billDetailDTOS = billDetailDTOS;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }
}
