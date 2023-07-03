package com.example.codegym_coffee.service.staitistical.impl;

import com.example.codegym_coffee.dto.satistic.StaticDTO;
import com.example.codegym_coffee.repository.IStatisticalRepository;
import com.example.codegym_coffee.service.staitistical.IStatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class StatisticalService implements IStatisticalService {
    @Autowired
    private IStatisticalRepository statisticalRepository;
    @Override
    public List<StaticDTO> getListStatistical(Date dateAfter, Date dateBefore) {
        return statisticalRepository.getListStatistical(dateAfter, dateBefore);
    }
}
