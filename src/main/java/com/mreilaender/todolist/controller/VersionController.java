package com.mreilaender.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author manuel
 * @version 12/11/16
 */
@RestController
@RequestMapping("/version")
public class VersionController {
    private static final String VERSION = "0.1.1";

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getVersion() {
        return new ResponseEntity<>(VERSION, HttpStatus.OK);
    }
}
