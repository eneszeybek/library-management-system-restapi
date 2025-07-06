package com.enes.library.controller;

import com.enes.library.dto.PublisherResponseDTO;
import com.enes.library.entity.Publisher;
import com.enes.library.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherRepository publisherRepository;

    @GetMapping
    public ResponseEntity<List<PublisherResponseDTO>> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();

        List<PublisherResponseDTO> dtoList = publishers.stream()
                .map(p -> new PublisherResponseDTO(p.getId(), p.getName(), p.getEstablishmentYear()))
                .toList();

        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return ResponseEntity.ok(publisherRepository.save(publisher));
    }
}
