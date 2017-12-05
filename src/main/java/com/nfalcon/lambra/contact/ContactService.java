package com.nfalcon.lambra.contact;

import com.nfalcon.lambra.event.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private ContactRepository contactRepository;
    private EventRepository eventRepository;

    public ContactService(ContactRepository contactRepository, EventRepository eventRepository) {
        this.contactRepository = contactRepository;
        this.eventRepository = eventRepository;
    }

    public List<Contact> findAllContactsForEvent(long eventId) {

        List<Contact> contacts = new ArrayList<>();
        contactRepository.findAll().forEach(contacts::add);

        return contacts.stream()
                       .filter(contact -> contact.getEvent().getId() == eventId)
                       .collect(Collectors.toList());

    }

    public Contact findNthContactForEvent(long eventId, int index) {
        List<Contact> contacts = new ArrayList<>();
        contactRepository.findAll().forEach(contacts::add);

        if(index < 0 || index > contacts.size()) {
            return new Contact();
        }

        return contacts.stream()
                       .filter(contact -> contact.getEvent().getId() == eventId)
                       .collect(Collectors.toList())
                       .get(index - 1);
    }
}
