package com.abhi.DI.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "practice running for 1 hour daily";
    }

}
