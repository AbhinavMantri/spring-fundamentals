package com.mysocial.chat.controllers;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    private MessageSource source;

    public HelloWorldController(MessageSource source) {
        this.source = source;
    }

    // @RequestMapping(method = RequestMethod.GET, name = "/")
    @GetMapping(path = {"/", ""})
    public String retrieveValue() {
        return "Hello-world";
    }

    @GetMapping(path = "/{name}")
    public String greetingPerson(@PathVariable String name) {
        return "Hello, " + name;
    }

    @GetMapping(path = "/internation")
    public String retrieveInternationzationValue() {
        Locale locale = LocaleContextHolder.getLocale();
        return source.getMessage("good.morning.message", null, "Default Message", locale);
        // return "Hello-world";
    }
}
