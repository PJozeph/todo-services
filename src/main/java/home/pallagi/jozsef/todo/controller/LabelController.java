package home.pallagi.jozsef.todo.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.pallagi.jozsef.todo.entity.Label;
import home.pallagi.jozsef.todo.service.LabelService;

@RestController
@RequestMapping("label")
@SecurityRequirement(name = "Bearer Authentication")
public class LabelController {

    @Autowired
    LabelService labelService;

    @GetMapping
    List<Label> getLabels() {
        return this.labelService.getAll();
    }

}
