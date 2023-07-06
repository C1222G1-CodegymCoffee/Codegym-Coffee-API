package com.example.codegym_coffee.controller.position;

import com.example.codegym_coffee.model.Position;
import com.example.codegym_coffee.service.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position")
@CrossOrigin
public class PositionController {

    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public List<Position> showList() {
        return iPositionService.showList();
    }
}
