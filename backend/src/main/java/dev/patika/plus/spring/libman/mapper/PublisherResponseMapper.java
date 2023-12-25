package dev.patika.plus.spring.libman.mapper;

import dev.patika.plus.spring.libman.dto.PublisherResponse;
import dev.patika.plus.spring.libman.entity.Publisher;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PublisherResponseMapper implements Function<Publisher, PublisherResponse> {

        @Override
        public PublisherResponse apply(Publisher publisher) {
            return new PublisherResponse(
                    publisher.getId(),
                    publisher.getName(),
                    publisher.getEstablishmentYear()
            );
        }

}
