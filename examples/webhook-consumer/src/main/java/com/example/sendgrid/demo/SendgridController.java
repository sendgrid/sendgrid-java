package com.example.sendgrid.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendgridController {

    final Logger logger = LoggerFactory.getLogger(SendgridController.class);

    @RequestMapping(method = RequestMethod.POST,
            path = "consumer",
            consumes = "application/json")
    public String sample(@RequestBody SendgridEvent[] events) {

        for (final SendgridEvent event : events) {
            logger.info(event.toString());
        }

        return "ok";
    }
}
