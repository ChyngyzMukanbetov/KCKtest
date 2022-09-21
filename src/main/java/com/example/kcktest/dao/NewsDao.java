package com.example.kcktest.dao;

import com.example.kcktest.model.entity.News;
import com.example.kcktest.model.enums.NewsStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface NewsDao extends CrudRepository<News, Long> {

//    @Query("from News news where news.newsStatus=:newsStatus and news.timestamp BETWEEN :from and :to")
//    List<News> findAllByNewsStatusAndTimestampBetween(@Param("newsStatus") NewsStatus newsStatus,
//                                                      @Param("from") Timestamp from,
//                                                      @Param("to") Timestamp to);
//}
//
//    @Query("from News news where news.newsStatus=:newsStatus and news.timestamp BETWEEN :from and :to")
//    List<News> findAllByNewsStatusAndTimestampBetween(@Param("newsStatus") NewsStatus newsStatus,
//                                                      @Param("from") Timestamp from,
//                                                      @Param("to") Timestamp to);
//}
        }