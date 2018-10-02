package com.infiniteskills.contollers;

import com.infiniteskills.data.entities.Project;
import com.infiniteskills.data.entities.Sponsor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {
    private static final Logger log= Logger.getLogger("Log");

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
