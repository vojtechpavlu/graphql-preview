package com.example.springmongographql.model;


import lombok.Data;

import java.util.List;

/**
 * Mutual abstract parent of all the entities that can be tagged.
 */
@Data
public abstract class Taggable {

    protected List<String> tagIds;
}
