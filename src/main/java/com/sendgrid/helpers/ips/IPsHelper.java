package com.sendgrid.helpers.ips;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for quick and easy access to the SendGrid IP Addresses API.
 */
public class IPsHelper {

    private static final String ALL_IPS_ENDPOINT = "ips";

    /**
     * Get a list of unassigned IP addresses.
     * @param sendGrid a SendGrid client.
     * @return a list of unassigned ip addresses if response status is ok (200), otherwise - null
     * @throws IOException in case of a network error or json parse error.
     */
    public static List<String> getAllUnassignedIPs(SendGrid sendGrid) throws IOException {
        Request request = new Request();
        request.setMethod(Method.GET);
        request.setEndpoint(ALL_IPS_ENDPOINT);

        Response response = sendGrid.api(request);
        if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
            List<String> unassignedIPs = new ArrayList<>();
            List<IPAddress> ipAddressList = new ObjectMapper().readValue(response.getBody(), new TypeReference<List<IPAddress>>() {});
            for (IPAddress ipAddress : ipAddressList) {
                if (ipAddress.getSubUsers() == null || ipAddress.getSubUsers().size() == 0) {
                    unassignedIPs.add(ipAddress.getIp());
                }
            }
            return unassignedIPs;
        }
        return null;
    }

}
