package com.example.springmongographql.controller;

import com.example.springmongographql.model.Tag;
import com.example.springmongographql.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @QueryMapping(name = "allTags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @QueryMapping(name = "tagById")
    public Optional<Tag> getTagByID(@Argument String id) {
        return tagService.getTagById(id);
    }
}
