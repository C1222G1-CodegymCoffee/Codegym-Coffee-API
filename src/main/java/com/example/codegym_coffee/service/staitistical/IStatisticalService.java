package com.example.codegym_coffee.service.staitistical;

import com.example.codegym_coffee.dto.satistic.StatisticDTO;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IStatisticalService {
    List<StatisticDTO> getListStatistical( Date dateAfter, Date dateBefore);

}
