package com.example.kcktest.controller;

import com.example.kcktest.mapper.NewsMapper;
import com.example.kcktest.model.dto.NewsDto;
import com.example.kcktest.model.entity.News;
import com.example.kcktest.model.enums.NewsStatus;
import com.example.kcktest.service.abstracts.NewsService;
import com.example.kcktest.service.impl.CheckInNewsStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/news", produces = "application/json")
@Api(value = "Контроллер работы с новостями")
public class NewsRestController {

    private NewsService newsService;
    private NewsMapper newsMapper;

    @PostMapping("/addNews")
    @ApiOperation("Добавление новости")
    public Long addNews(@RequestBody NewsDto newsDto) {
        return newsService.save(newsDto).getId();
    }

    @GetMapping("/get/{id}")
    @ApiOperation("Получение новости по ID")
    public ResponseEntity<NewsDto> getNews(@PathVariable Long id) {
        if (newsService.existsById(id)) {
            return new ResponseEntity<>(newsMapper.toDto(newsService.findById(id).get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    @ApiOperation("Изменение статуса новости")
    public ResponseEntity<NewsDto> updateStatus (@PathVariable Long id, @RequestParam(value = "newsStatus") String newsStatus) {
        if (!CheckInNewsStatus.checkInNewsStatus(NewsStatus.values(), newsStatus) || !newsService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(newsMapper.toDto(newsService.updateStatus(id, newsStatus)), HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    @ApiOperation("Получение списка новостей с фильтрацией по статусу и timestamp последней корректировки")
    public ResponseEntity<List<NewsDto>> getAllFiltered(@RequestParam(value = "newsStatus", required = false) String newsStatus,
                                    @RequestParam(value = "timestampfrom", required = false) Timestamp timestampfrom,
                                    @RequestParam(value = "timestampto", required = false) Timestamp timestampto) {
        if (newsStatus != null) {
            if (!CheckInNewsStatus.checkInNewsStatus(NewsStatus.values(), newsStatus)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        List<NewsDto> newsDtoList = new ArrayList<>();
        List<News> newsList = newsService.findAllByNewsStatusAndTimestampBetween(newsStatus, timestampfrom, timestampto);
        for (News news : newsList) {
            newsDtoList.add(newsMapper.toDto(news));
        }
        return new ResponseEntity<>(newsDtoList, HttpStatus.OK);
    }

    @GetMapping("/getAllNews")
    @ApiOperation("Получение всего списка новостей")
    public List<NewsDto> getAllNews() {
        List<NewsDto> newsDtoList = new ArrayList<>();
        List<News> newsList = newsService.findAll();
        for (News news : newsList) {
            newsDtoList.add(newsMapper.toDto(news));
        }
        return newsDtoList;
    }
}

