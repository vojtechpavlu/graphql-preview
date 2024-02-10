package com.example.springmongographql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PingController {

    @QueryMapping(name = "ping")
    public String ping() {
        return "pong";
    }
}
