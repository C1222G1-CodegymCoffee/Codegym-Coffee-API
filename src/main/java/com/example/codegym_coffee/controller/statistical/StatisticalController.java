package com.example.codegym_coffee.controller.statistical;


import com.example.codegym_coffee.dto.satistic.StaticDTO;
import com.example.codegym_coffee.service.staitistical.IStatisticalService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class StatisticalController {

    /**
     * create by : ThongDM ,
     * Date Create : 27/06/2023
     * Function : statistical controller
     *
     * @param dateAfter
     * @param dateBefore
     * @return HttpStatus.OK
     */
    @Autowired
    private IStatisticalService iStatisticalService;

    @GetMapping("/statistical")
    public ResponseEntity<List<StaticDTO>> getStatistic(@RequestParam String dateAfter, @RequestParam String dateBefore ){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date;
        Date date1;
        try {
            date = dateFormat.parse(dateAfter);
            date1 = dateFormat.parse(dateBefore);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<StaticDTO> entityStatisticDTOS  = iStatisticalService.getListStatistical(date,date1);
        return new ResponseEntity<>(entityStatisticDTOS, HttpStatus.OK);
    }
}


