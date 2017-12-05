package com.nfalcon.lambra.event;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAllEvents() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);

        return events;
    }

    public Event findEventById(long id) {
        Event event = eventRepository.findOne(id);
        if (event != null) {
            return event;
        }
        return new Event();
    }
}
