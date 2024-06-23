package com.sendgrid.constant;

import java.util.function.Predicate;

public class ApplicationConstants {
    public static final Predicate<Integer> SUCCESS = i -> i != null && i >= 200 && i < 400;
}
