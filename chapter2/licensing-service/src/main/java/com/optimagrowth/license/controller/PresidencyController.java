package com.optimagrowth.license.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimagrowth.license.model.Presidency;
import com.optimagrowth.license.service.PresidencyService;

@RestController
@RequestMapping("/api/presidencies")
public class PresidencyController {
    @Autowired
    private PresidencyService presidencyService;

    @GetMapping
    public List<Presidency> getAllPresidencies() {
        return presidencyService.getAllPresidencies();
    }

    @PostMapping
    public Presidency createPresidency(@RequestBody Presidency presidency) {
        return presidencyService.createPresidency(presidency);
    }

    @DeleteMapping("/{personId}/{organizationId}")
    public ResponseEntity<Void> deletePresidency(
            @PathVariable Long personId,
            @PathVariable Long organizationId) {
        presidencyService.deletePresidency(personId, organizationId);
        return ResponseEntity.ok().build();
    }
}