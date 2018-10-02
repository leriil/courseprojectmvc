package com.infiniteskills.data.services;

import com.infiniteskills.data.entities.Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectService {

    List<Project>projects=new ArrayList<Project>();
    public ProjectService() {
        Project springProject = this.createProject(1L,"spring", "a web project");
        Project htmlProject = this.createProject(2L,"html", "for an online shop");
        Project designProject = this.createProject(3L,"game design", "for an online game");
        projects.addAll(Arrays.asList(new Project[]{springProject, htmlProject, designProject}));
    }

    public List<Project>findAll(){
        return this.projects;
    }

    public Project find(final Long projectId){
        return this.projects.stream().filter(p->{
            return p.getProjectId().equals(projectId);
        }).collect(Collectors.toList()).get(0);
    }

    private Project createProject(Long projectId, String name, String description){
        Project project=new Project();
        project.setProjectId(projectId);
        project.setName(name);
//        project.setSponsor("tsystems");
        project.setDescription(description);
        return project;
    }
}
