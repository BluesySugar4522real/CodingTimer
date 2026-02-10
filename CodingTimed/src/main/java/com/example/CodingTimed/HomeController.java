package com.example.CodingTimed;

import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class HomeController {
    private final TimeService tS;
    private Time time = new Time();

    public HomeController(TimeService tS) {
        this.tS = tS;
    }

    @GetMapping
    public Message index() {
        return new Message("Welcome to the coding timed app!");
    }

    @GetMapping("start")
    public TimeMessage start() {

        if (time.isStarted() && time.isEnded()) {
            time = new Time();
            return new TimeMessage("Started new coding session", time.getStartedAt());
        }

        return new TimeMessage("Timer already running, started at timestamp below", time.getStartedAt());
    }

    @GetMapping("stop")
    public TimeMessage stop() {
        time.setEndedAt(ZonedDateTime.now());
        tS.createTime(time);
        return new TimeMessage("Ended coding session", time.getEndedAt());
    }

    @GetMapping("times")
    public List<Time> times() {
        return tS.getTimes();
    }
}

