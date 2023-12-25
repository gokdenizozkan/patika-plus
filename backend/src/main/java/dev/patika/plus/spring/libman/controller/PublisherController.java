package dev.patika.plus.spring.libman.controller;

import dev.patika.plus.spring.libman.dto.PublisherResponse;
import dev.patika.plus.spring.libman.entity.Loan;
import dev.patika.plus.spring.libman.entity.Publisher;
import dev.patika.plus.spring.libman.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    ResponseEntity<List<PublisherResponse>> getPublishers() {
        List<PublisherResponse> publishers = publisherService.getAll();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/{id}")
    ResponseEntity<Publisher> getPublisher(@PathVariable long id) {
        Publisher publisher  = publisherService.getById(id);
        if (publisher == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(publisher);
    }
}
