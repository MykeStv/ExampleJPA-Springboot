package com.myke.ejemploJPA.service;

import com.myke.ejemploJPA.model.Project;
import com.myke.ejemploJPA.repository.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private IProjectJpaRepository iProjectJpaRepository;

    public List<Project> getProjects() {
        return this.iProjectJpaRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return this.iProjectJpaRepository.findById(id);
    }

    public Project addProject(Project project) {
        return this.iProjectJpaRepository.save(project);
    }

    public boolean deleteProject(Long id) {
        try {
            this.iProjectJpaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
