package com.example.kcktest.service.impl;

import com.example.kcktest.model.enums.NewsStatus;
import org.springframework.stereotype.Service;

@Service
public class CheckInNewsStatus {
    public static boolean checkInNewsStatus(NewsStatus[] values, String newsStatus) {
        for(NewsStatus ns : values) {
            if(newsStatus.equals(ns.toString())) {
                return true;
            }
        }
        return false;
    }
}