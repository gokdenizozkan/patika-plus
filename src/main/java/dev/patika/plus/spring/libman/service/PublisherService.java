package dev.patika.plus.spring.libman.service;

import dev.patika.plus.spring.libman.dto.PublisherResponse;
import dev.patika.plus.spring.libman.entity.Publisher;
import dev.patika.plus.spring.libman.mapper.PublisherResponseMapper;
import dev.patika.plus.spring.libman.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherResponseMapper publisherResponseMapper;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository, PublisherResponseMapper publisherResponseMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherResponseMapper = publisherResponseMapper;
    }

    public List<PublisherResponse> getAll() {
        List<Publisher> publishers = publisherRepository.findAll();

        return publishers.stream()
                .map(publisherResponseMapper::apply)
                .collect(Collectors.toList());
    }

    public Publisher getById(long id) {
        return publisherRepository.findById(id).get();
    }
}
