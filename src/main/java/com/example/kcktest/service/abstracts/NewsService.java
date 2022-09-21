package com.example.kcktest.service.abstracts;

import com.example.kcktest.model.dto.NewsDto;
import com.example.kcktest.model.entity.News;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface NewsService {
    Optional<News> findById(Long id);
    boolean existsById(Long id);
    List<News> findAll();
    List<News> findAllByNewsStatusAndTimestampBetween(String newsStatus, Timestamp timestampFrom, Timestamp timestampTo);
    News save(NewsDto newsDto);
    News updateStatus(Long id, String newsStatus);
}
