package com.ricstudio.springbootactuatorprometheustest.controller;

import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/statereader")
public class StateReaderController {
    @Resource
    ApplicationAvailability applicationAvailability;

    @RequestMapping(value="/get")
    public String state() {
        return "livenessState : " + applicationAvailability.getLivenessState()
                + "<br>readinessState : " + applicationAvailability.getReadinessState()
                + "<br>" + new Date();
    }
}
