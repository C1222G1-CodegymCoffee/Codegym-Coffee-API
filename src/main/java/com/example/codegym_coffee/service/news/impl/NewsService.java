package com.example.codegym_coffee.service.news.impl;

import com.example.codegym_coffee.dto.news.NewsDTO;
import com.example.codegym_coffee.model.News;
import com.example.codegym_coffee.repository.news.INewsRepository;
import com.example.codegym_coffee.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class NewsService implements INewsService {
    /**
     * create by : ThongDM ,
     * Date Create : 27/06/2023
     * Function : Add new 1 news to db
     *
     * @param newsDTO
     * @return no return value
     */
    @Autowired
    private INewsRepository inewsRepository;
    @Override
    public void addNews(NewsDTO newsDTO) {
        inewsRepository.addNews(newsDTO.getTitle(),newsDTO.getContent(),newsDTO.getDayPost(),newsDTO.getImage(),1);
    }

    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * function: find all news
     * @param pageable
     */
    @Override
    public Page<News> findAllNews(Pageable pageable) {
        return this.inewsRepository.findAllNews(
                pageable
        );
    }

    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * function: find by id of News
     * @param id
     */
    @Override
    public News findByIdNews(int id) {
        return inewsRepository.findByIdNews(id);
    }
}
