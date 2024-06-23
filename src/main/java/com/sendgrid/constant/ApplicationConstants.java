package com.sendgrid.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationConstants {
    public static final int HTTP_STATUS_CODE_CREATED = 201;
    public static final int HTTP_STATUS_CODE_NO_CONTENT = 204;
    public static final int HTTP_STATUS_CODE_OK = 200;
    public static final Predicate<Integer> SUCCESS = i -> i != null && i >= 200 && i < 400;
}
