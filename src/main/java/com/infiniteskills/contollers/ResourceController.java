package com.infiniteskills.contollers;

import com.infiniteskills.data.entities.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("resource",new Resource());
        List<String> typeOptions = new LinkedList<>(Arrays.asList(new String[]{"Material", "Staff","Other"}));
        List<String> radioOptions = new LinkedList<>(Arrays.asList(new String[]{"100","200"}));
        List<String> checkOptions = new LinkedList<>(Arrays.asList(new String[]{"kilo", "liter","ounce"}));
        model.addAttribute("typeOptions", typeOptions);
        model.addAttribute("radioOptions", radioOptions);
        model.addAttribute("checkOptions", checkOptions);
        return "resource_add";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute Resource resource) {
        System.out.println(resource);
        return "redirect:/resource/add";
    }

}
