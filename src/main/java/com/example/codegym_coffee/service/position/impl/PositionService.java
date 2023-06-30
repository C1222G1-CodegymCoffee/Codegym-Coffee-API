package com.example.codegym_coffee.service.position.impl;

import com.example.codegym_coffee.model.Position;
import com.example.codegym_coffee.repository.employee.IPositionRepository;
import com.example.codegym_coffee.service.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> showList() {
        return iPositionRepository.showPositionList();
    }
}
