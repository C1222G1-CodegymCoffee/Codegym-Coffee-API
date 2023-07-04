package com.example.codegym_coffee.service.staitistical;

import com.example.codegym_coffee.dto.satistic.StaticDTO;

import java.util.Date;
import java.util.List;

public interface IStatisticalService {
    List<StaticDTO> getListStatistical(Date dateAfter, Date dateBefore);

}
