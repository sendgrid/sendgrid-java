package com.sendgrid.util;

import com.sendgrid.constant.EnumConstants;
import org.apache.http.client.utils.URIBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Utility {

    public static String buildBaseUrl(final String domain, final String region, final String endPoint) {
        List<String> availableRegions = EnumConstants.Region.getValues();
        StringBuilder defaultDomain = new StringBuilder(domain);
        if (availableRegions.contains(region)) {
            if (!EnumConstants.Region.GLOBAL.getValue().equals(region)) {
                defaultDomain.append(".");
                defaultDomain.append(region);
            }
        }
        return "https://" + defaultDomain.toString() + ".sendgrid.com" + endPoint;
    }
    public static String buildWithPathParams(String path, final Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String placeholder = "\\{" + entry.getKey() + "\\}";
            path = path.replaceAll(placeholder, entry.getValue());
        }
        return path;
    }

    public static String buildWithQueryParams(String path, final Map<String, String> queryParams) {
        URIBuilder builder = new URIBuilder();
        if (queryParams != null) {
            String multiValueDelimiter = "&";
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (value.contains(multiValueDelimiter)) {
                    List<String> values = Arrays.asList(value.split(multiValueDelimiter));
                    for (String val : values) {
                        builder.addParameter(key, val);
                    }
                } else {
                    builder.setParameter(key, value);
                }
            }
        }
        return path + builder.toString();
    }
}
