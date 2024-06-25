package com.sendgrid.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumConstants {
    @Getter
    @RequiredArgsConstructor
    public enum ContentType {
        JSON("application/json"),
        FORM_URLENCODED("application/x-www-form-urlencoded");

        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Region {
        GLOBAL("global"),
        EU("eu");

        private final String value;

        public static List<String> getValues() {
            return Arrays.stream(Region.values())
                    .map(Region::getValue)
                    .collect(Collectors.toList());
        }
    }
}
