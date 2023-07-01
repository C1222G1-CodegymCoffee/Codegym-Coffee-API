package com.example.codegym_coffee.service.employee.impl;

import com.example.codegym_coffee.model.Position;
import com.example.codegym_coffee.repository.employee.IPositionRepositoryQuynh;
import com.example.codegym_coffee.service.employee.IPositionServiceQuynh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceQuynh implements IPositionServiceQuynh {
    @Autowired
    IPositionRepositoryQuynh iPositionRepositoryQuynh;
    @Override
    public List<Position> findAll() {
        return iPositionRepositoryQuynh.findAllPosition();
    }
}
