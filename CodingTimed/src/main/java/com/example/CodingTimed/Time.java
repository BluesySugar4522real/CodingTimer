package com.example.CodingTimed;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private ZonedDateTime startedAt;
    private ZonedDateTime endedAt;

    public Time() {
        startedAt = ZonedDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartedAt() {
        final DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return formatter.format(startedAt);
    }

    public void setStartedAt(ZonedDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public String getEndedAt() {
        final DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return formatter.format(endedAt);
    }

    public void setEndedAt(ZonedDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public boolean isStarted() {
        return startedAt != null;
    }

    public boolean isEnded() {
        return endedAt != null;
    }
}
