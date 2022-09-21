package com.example.kcktest.dao;

import com.example.kcktest.model.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao extends CrudRepository<Image, Long> {
    Image getImageByUri(String uri);
}
