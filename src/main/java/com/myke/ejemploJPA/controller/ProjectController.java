package com.myke.ejemploJPA.controller;

import com.myke.ejemploJPA.model.Project;
import com.myke.ejemploJPA.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getProjects() {
        return this.projectService.getProjects();
    }

    @GetMapping(path = "/{id}")
    public Optional<Project> getProject(@PathVariable("id") Long id) {
        return this.projectService.getProjectById(id);
    }

    @PostMapping("/add")
    public Project addProject(@RequestBody Project project) {
        return this.projectService.addProject(project);
    }

    @PutMapping(path = "/update")
    public Project updateProject(@RequestBody Project project) {
        return this.projectService.addProject(project);
    }

    @DeleteMapping(path = "/delite/{id}")
    public String deleteProject(@PathVariable("id") Long id) {
        if (this.projectService.deleteProject(id)){
            return "Role deleted!";
        } else {
            return "Not found!";
        }
    }

}
