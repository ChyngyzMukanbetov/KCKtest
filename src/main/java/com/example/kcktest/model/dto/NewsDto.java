package com.example.kcktest.model.dto;

import com.example.kcktest.model.entity.Image;
import com.example.kcktest.model.entity.User;
import com.example.kcktest.model.enums.NewsStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Long.class)
public class NewsDto {
    private Long id;
    private String imageUri;
    private String header;
    private String content;
    private UserDto userDto;
    private NewsStatus newsStatus;
    private Timestamp timestamp;
}
