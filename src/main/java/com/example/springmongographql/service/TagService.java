package com.example.springmongographql.service;

import com.example.springmongographql.model.Tag;
import com.example.springmongographql.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Optional<Tag> getTagById(String id) {
        return tagRepository.findById(id);
    }

    public List<Tag> getMultipleTags(List<String> tagIds) {
        return tagRepository.findAllByIdIn(tagIds);
    }
}
