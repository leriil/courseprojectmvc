package com.infiniteskills.contollers;

import com.infiniteskills.data.entities.Project;
import com.infiniteskills.data.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@Controller
@RequestMapping("/project")
public class ProjectController {

    Logger logger=Logger.getLogger("log");

    @Autowired
    ProjectService projectService;

    @RequestMapping("/find")
    public String find(Model model){
        model.addAttribute("projects",this.projectService.findAll());
        return "projects";
    }

    @RequestMapping(value = "/{projectId}")
    public String findProject(Model model, @PathVariable Long projectId){
        model.addAttribute("project",this.projectService.find(projectId));
    return "project";
    }

    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String addProject(Model model){
        model.addAttribute("project", new Project());
        model.addAttribute("type","");
        model.addAttribute("types", new ArrayList<String>(Arrays.asList(new String[]{"","one year","two years"})));
        logger.info("add project has been rendered");
        return "project_add";
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String saveProject(@ModelAttribute Project project){
        logger.info("a new project has been submitted");
        System.out.println(project);
        System.out.println("save project has been rendered");
        return "project_add";
    }
}
