package com.sendgrid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SendGridTest {

    private final String SENDGRID_API_KEY = "";
    
    @Test
    public void testVersion() {
        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Assert.assertEquals(sg.getVersion(), "3.0.0");
    }

    @Test
    public void testBuildGradleVersion() {
        try {
            SendGrid sg = new SendGrid(SENDGRID_API_KEY);
            BufferedReader br = new BufferedReader(new FileReader("./build.gradle"));
            String line = br.readLine();
            String regex = "version\\s*=\\s*'" + sg.getVersion() + "'";

            while (line != null) {
                if (line.matches(regex)) {
                    br.close();
                    return;
                }
                line = br.readLine();
            }
            br.close();
            Assert.assertTrue("build.gradle version does not match", false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
