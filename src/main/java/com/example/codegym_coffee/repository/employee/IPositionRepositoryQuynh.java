package com.example.codegym_coffee.repository.employee;

import com.example.codegym_coffee.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPositionRepositoryQuynh extends JpaRepository<Position,Integer> {
    @Query(value = "select * from position", nativeQuery = true)
    List<Position> findAllPosition();
}
