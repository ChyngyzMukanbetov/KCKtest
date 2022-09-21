package com.example.kcktest.mapper;

import java.util.Optional;

public class OptionalResolver {
    public static <T> T fromOptional(Optional<T> optional) {
        return optional.orElse( null );
    }
}
