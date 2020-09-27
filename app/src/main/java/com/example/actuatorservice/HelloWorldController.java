package com.example.actuatorservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    @ResponseBody
    public String indexPageHandler() {
        return "index page";
    }

    @GetMapping("/ping")
    @ResponseBody
    public String pingHandler() {
        return "Pong";
    }

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping(path = "/sum", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JsonNode fSum(@RequestBody JsonNode requestBody) {
        JsonNode x_node = requestBody.get("x");
        JsonNode y_node = requestBody.get("y");
        long x = x_node.asLong();
        long y = y_node.asLong();
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode res = factory.objectNode();
        res.put("sum", x + y);
        return res;
    }
}
