package com.nfalcon.lambra.contact;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/api/events/{eventId}/contacts")
    public ResponseEntity<List<Contact>> get(@PathVariable long eventId) {
        List<Contact> contacts = new ArrayList<>(contactService.findAllContactsForEvent(eventId));
        if(!contacts.isEmpty()) {
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/api/events/{eventId}/contacts/{contactIndex}")
    public ResponseEntity<Contact> get(@PathVariable long eventId,
                                       @PathVariable int contactIndex) {
        return new ResponseEntity<>(contactService.findNthContactForEvent(eventId, contactIndex), HttpStatus.OK);
    }
}
