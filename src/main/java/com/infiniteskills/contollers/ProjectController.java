package com.infiniteskills.contollers;

import com.infiniteskills.data.entities.Project;
import com.infiniteskills.data.services.ProjectService;
import com.infiniteskills.data.validators.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@Controller
@RequestMapping("/project")
public class ProjectController {

    Logger logger=Logger.getLogger("log");

    @Autowired
    ProjectService projectService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new ProjectValidator());
    }

    @RequestMapping("/find")
    public String find(Model model){
        model.addAttribute("projects",this.projectService.findAll());
        return "projects";
    }
@RequestMapping("/find/{projectId}")
    public @ResponseBody Project findProjectObject(Model model, @PathVariable("projectId") Long projectId){
       return this.projectService.find(projectId);
    }

    @RequestMapping(value = "/{projectId}")
    public String findProject(Model model, @PathVariable Long projectId){
        model.addAttribute("project",this.projectService.find(projectId));
    return "project";
    }

    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String addProject(Model model){
        model.addAttribute("project", new Project());
        model.addAttribute("types", new ArrayList<String>(Arrays.asList(new String[]{"","one year","two years"})));
        logger.info("add project has been rendered");
        return "project_add";
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String saveProject(@Valid @ModelAttribute Project project, Errors errors, RedirectAttributes redirectAttributes){
//        logger.info("a new project has been submitted");
//        if(!errors.hasErrors()){
//            logger.info("project is valid");
//            System.out.println(project);
//        }
//        else {
//            logger.info("project is not valid");
//            return "project_add";
//        }
        project.setProjectId(55L);
        this.projectService.save(project);
        redirectAttributes.addAttribute("projectId",project.getProjectId().toString());
        return "redirect:/";
    }
}
