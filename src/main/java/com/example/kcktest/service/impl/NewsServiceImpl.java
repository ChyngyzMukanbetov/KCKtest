package com.example.kcktest.service.impl;

import com.example.kcktest.dao.NewsDao;
import com.example.kcktest.mapper.UserMapper;
import com.example.kcktest.model.dto.NewsDto;
import com.example.kcktest.model.entity.News;
import com.example.kcktest.model.enums.NewsStatus;
import com.example.kcktest.service.abstracts.ImageService;
import com.example.kcktest.service.abstracts.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {

    private ImageService imageService;
    private UserMapper userMapper;
    private NewsDao newsDao;

    @Override
    public News save(NewsDto newsDto) {
        News news = new News();
        news.setImage(imageService.getImageByUri(newsDto.getImageUri()));
        news.setHeader(newsDto.getHeader());
        news.setContent(newsDto.getContent());
        news.setUser(userMapper.toUser(newsDto.getUserDto()));
        news.setNewsStatus(NewsStatus.DRAFT);
        news.setTimestamp(new Timestamp(System.currentTimeMillis()));

        newsDao.save(news);
        return news;
    }

    @Override
    public News updateStatus(Long id, String newsStatus) {
        Optional<News> news = findById(id);
        news.get().setNewsStatus(NewsStatus.valueOf(newsStatus));
        news.get().setTimestamp(new Timestamp(System.currentTimeMillis()));
        return newsDao.save(news.get());
    }

    public Optional<News> findById(Long id) {
        return newsDao.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return newsDao.existsById(id);
    }

    @Override
    public List<News> findAll() {
        return (List<News>) newsDao.findAll();
    }

    @Override
    public List<News> findAllByNewsStatusAndTimestampBetween(String newsStatus, Timestamp timestampFrom, Timestamp timestampTo) {
        List<News> newsList = (List<News>) newsDao.findAll();
        if (newsStatus != null) {
            newsList = newsList.stream().filter(n -> n.getNewsStatus() == NewsStatus.valueOf(newsStatus)).collect(Collectors.toList());
        }
        if (timestampFrom != null) {
            newsList = newsList.stream().filter(n -> n.getTimestamp().after(timestampFrom)).collect(Collectors.toList());
        }
        if (timestampTo != null) {
            newsList = newsList.stream().filter(n -> n.getTimestamp().before(timestampTo)).collect(Collectors.toList());
        }
        return newsList;
    }
}
