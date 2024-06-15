package com.sendgrid.http.httpclient;

import com.sendgrid.constant.Config;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
class HttpUtility {
    public String getUserAgentString(final List<String> userAgentExtensions) {
        StringBuilder userAgentString = new StringBuilder();
        userAgentString.append("sendgrid-java/")
                .append(Config.VERSION)
                .append(" (")
                .append(Config.OS_NAME)
                .append(" ")
                .append(Config.OS_ARCH)
                .append(") ")
                .append("java/")
                .append(Config.JAVA_VERSION);

        if (userAgentExtensions != null && !userAgentExtensions.isEmpty()) {
            userAgentExtensions.stream().forEach(userAgentExtension -> {
                userAgentString.append(" ");
                userAgentString.append(userAgentExtension);
            });
        }

        return userAgentString.toString();
    }

    public String getUserAgentString(final List<String> userAgentExtensions, final boolean isCustomClient) {
        return isCustomClient ? getUserAgentString(userAgentExtensions) + " custom"
                : getUserAgentString(userAgentExtensions);
    }
}
