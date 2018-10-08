package com.infiniteskills.contollers;

import com.infiniteskills.data.entities.Resource;
import com.infiniteskills.data.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

//    @Autowired
//    private ResourceRepository resourceRepository;
    @Autowired
    ResourceService resourceService;


    private static final Logger log=Logger.getLogger("Log");

    @ExceptionHandler(NullPointerException.class)
    public String handleError(){
        return "controller_error";
    }

    @ModelAttribute("resource")
    public Resource getResource(){
        log.info("adding a resource to the model");
        return new Resource();
    }

    @ModelAttribute("typeOptions")
    public List<String> getTypes(){
        return new LinkedList<>(Arrays.asList(new String[]{"Material", "Staff","Other"}));
    }

    @ModelAttribute("radioOptions")
    public List<String> getRadios(){
        return new LinkedList<>(Arrays.asList(new String[]{"100","200"}));
    }

    @ModelAttribute("checkOptions")
    public List<String> getChecks(){
        return new LinkedList<>(Arrays.asList(new String[]{"kilo", "liter","ounce"}));
    }

    @RequestMapping("/review")
    public String review(@ModelAttribute Resource resource){
        log.info("making a review");
        return "resource_review";
    }
    @ResponseBody
    @RequestMapping("/request")
    public String request(@RequestBody String formSerialized){
        System.out.println(formSerialized);
        return "request sent back";
    }
    @RequestMapping("/add")
    public String add(Model model) {

//        model.addAttribute("resource",new Resource());
//        List<String> typeOptions = new LinkedList<>(Arrays.asList(new String[]{"Material", "Staff","Other"}));
//        List<String> radioOptions = new LinkedList<>(Arrays.asList(new String[]{"100","200"}));
//        List<String> checkOptions = new LinkedList<>(Arrays.asList(new String[]{"kilo", "liter","ounce"}));
//        model.addAttribute("typeOptions", typeOptions);
//        model.addAttribute("radioOptions", radioOptions);
//        model.addAttribute("checkOptions", checkOptions);
        return "resource_add";
    }

//    @RequestMapping("/save")
//    public String save(@ModelAttribute Resource resource, SessionStatus status) {
//        System.out.println(resource);
//        status.setComplete();
//        return "redirect:/resource/add";
//    }

    @RequestMapping("/save")
    public String save(@ModelAttribute Resource resource, SessionStatus status) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.getTransaction().begin();
//            session.save(resource);
//            session.getTransaction().commit();
//            System.out.println(resource);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//            HibernateUtil.getSessionFactory().close();
//        }
//        resourceRepository.save(resource);
        resourceService.save(resource);
        status.setComplete();
        return "redirect:/resource/add";
    }
    @RequestMapping("/find/{resourceId}")
    public @ResponseBody Resource find(@PathVariable("resourceId") Long resourceId){
        Optional<Resource> resource = this.resourceService.find(resourceId);
        if(resource.isPresent()){
            return resource.get();
        }
        throw new RuntimeException("resource not found");
}

    @RequestMapping("/find/{name}")
    public @ResponseBody Resource findByName( @PathVariable("name") String name){
        Resource resource = this.resourceService.findByName(name);
        if(resource!=null){
            System.out.println("found by name: "+resource);
            return resource;
        }
        throw new RuntimeException("resource not found");
    }

    @RequestMapping("find/findResources")
    public @ResponseBody List<Resource> findAllResources(){
        for(Resource resource:this.resourceService.findResources()){
            System.out.println("found resource: "+resource);
        }
        return this.resourceService.findResources();
    }
}
