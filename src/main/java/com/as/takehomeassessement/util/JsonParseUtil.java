package com.as.takehomeassessement.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JsonParseUtil {

    private JsonParseUtil(){
        //Empty implementation to prevent instantiation
    }

    public static <T> List<T> parseToListOfObjects(String path, Class<T[]> type) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        try {
            return Arrays.stream(
                    mapper.readValue(
                            new FileReader(path),
                            type)
            ).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
