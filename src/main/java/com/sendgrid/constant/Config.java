package com.sendgrid.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Config {
    public static final String VERSION = "5.0.0-rc.1";
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_ARCH = System.getProperty("os.arch");
}
