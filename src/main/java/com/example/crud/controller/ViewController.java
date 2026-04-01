package com.example.crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entities.View;
import com.example.crud.service.ViewService;

@RestController
public class ViewController {
    private final ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @GetMapping("/members/{id}/view")
    public List<View> getView(@PathVariable Long id) {
        return viewService.getView(id);
    }
}
