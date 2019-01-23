package com.sopromadze.converters;

import org.springframework.core.convert.converter.Converter;

public class StringTrimmingConverter implements Converter<String, String> {

    @Override
    public String convert(String source) {
       return source.trim();
    }

}