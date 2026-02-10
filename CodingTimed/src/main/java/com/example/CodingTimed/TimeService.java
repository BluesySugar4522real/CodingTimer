package com.example.CodingTimed;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {
    private final TimeRepo tR;

    public TimeService(TimeRepo tR) {
        this.tR = tR;
    }

    public List<Time> getTimes() {
        return tR.findAll();
    }

    public Time getTimeById(long id) {
        return tR.findById(id).orElseThrow();
    }

    public void createTime(Time time) {
        tR.save(time);
    }
}
