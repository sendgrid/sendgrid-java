package com.sendgrid;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class LicenseTest {

    @Test
    public void testLicenseShouldHaveCorrectYear() throws IOException {
        String copyrightText = null;
        try (BufferedReader br = new BufferedReader(new FileReader("./LICENSE.md"))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (line.startsWith("Copyright")) {
                    copyrightText = line;
                    break;
                }
            }
        }
        String expectedCopyright = String.format("Copyright (C) %d, Twilio SendGrid, Inc. <help@twilio.com>", Calendar.getInstance().get(Calendar.YEAR));
        Assert.assertEquals("License has incorrect year", copyrightText, expectedCopyright);
    }
}
