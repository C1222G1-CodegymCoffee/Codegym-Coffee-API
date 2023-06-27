package com.example.codegym_coffee.service.home_page.impl;

import com.example.codegym_coffee.model.Product;
import com.example.codegym_coffee.repository.home_page.IHomePageRepository;
import com.example.codegym_coffee.service.home_page.IHomePageService;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageService implements IHomePageService {
    @Autowired
    IHomePageRepository homePageRepository;

    @Override
    public List<Product> findTopProduct() {
        return homePageRepository.findTopProduct();
    }

    @Override
    public List<Product> findNewProduct() {
        return homePageRepository.findNewProduct();
    }
}
