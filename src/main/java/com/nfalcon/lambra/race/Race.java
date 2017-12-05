package com.nfalcon.lambra.race;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nfalcon.lambra.event.Event;

import javax.persistence.*;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="event_id", nullable = false)
    private Event event;

    public Race() {
    }

    public Race(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
