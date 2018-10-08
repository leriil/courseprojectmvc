package com.infiniteskills.contollers;

import com.infiniteskills.data.entities.Project;
import com.infiniteskills.data.entities.Sponsor;
import com.infiniteskills.data.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class HomeController {
    @Autowired
    private ProjectService service;
    private static final Logger log= Logger.getLogger("Log");

@RequestMapping(value = "/",params = "projectId")
    public String goHomeAgain(Model model, @RequestParam ("projectId") Long projectId){
        model.addAttribute("currentProject",this.service.find(projectId));
        return "home";
    }
    @RequestMapping("/")
//    @ResponseBody
    public String goHome(Model model){
        Project project=new Project();
        project.setName("myfirstproject");
        project.setSponsor(new Sponsor("NASA", "555-555-5555", "nasa@nasa.com"));
        project.setDescription("my first serious spring project");
        model.addAttribute("currentProject",project);
        return "home";
    }
}
