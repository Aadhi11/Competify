package com.springweb.demospringweb.Controller;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.springweb.demospringweb.model.Alien;
import com.springweb.demospringweb.model.Events;
import com.springweb.demospringweb.model.Registers;
import com.springweb.demospringweb.model.Users;
import com.springweb.demospringweb.repo.EventRepo;
import com.springweb.demospringweb.repo.UserRepo;
import com.springweb.demospringweb.service.AdminService;
import com.springweb.demospringweb.service.EventService;
import com.springweb.demospringweb.service.UserPrinciple;
import com.springweb.demospringweb.service.UserService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@Controller
public class HomeController {

     
    // // @Autowired
    // private AuthenticationManager authenticationManager;

    @Autowired
   private UserService userService;

   @Autowired
   private EventService eventService;

    @Autowired
    private EventRepo repo;

   
//    @Autowired
//    private AdminService adminservice;
   
    @GetMapping("/user/login")
    public String login() {
        return "user_login";
    }

    @GetMapping("/admin/login")
    public String admin_login() {
        return "admin_login";
    }
    
    
    @PostMapping("/addUser")
    public String add_user(@RequestParam String username,@RequestParam String emailid,@RequestParam int phno,@RequestParam String password ) {
        userService.registerUser(username,emailid,phno,password);
        System.out.println("addeduser");
        return "user_login";
    }
    
    @PostMapping("/check")
    @ResponseBody
    public String postMethodName() {
        return "good";
    }
    
    @PostMapping("/addAdmin")
    public String add_admin(@RequestParam String username,@RequestParam String emailid,@RequestParam int phno,@RequestParam String password ) {
        userService.registerAdmin(username,emailid,phno,password);
        return "admin_login";
    }
    
    @RequestMapping("/user_signup")
    public String user_signup() {
        return "user_signup";
    }

    @RequestMapping("/admin_signup")
    public String admin_signup() {
        return "admin_signup";
    }

    @GetMapping("/")
    public String home() {
        return "index";    
    }

    @GetMapping("/user/home")
    public String user_home(Model model,@AuthenticationPrincipal UserPrinciple user) {
    //    Authentication  authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    //    System.out.println(authenticate.isAuthenticated());
        List<Events> eventList = repo.findAll(); 
        for (Events i : eventList) {
 
            // Print all eents of ArrayList
            System.out.println(i.getRequired());
        }
        model.addAttribute("events", eventList);
         return "index";
    }

    @PostMapping("/user/register")
    public String postMethodName(@RequestParam String required,@RequestParam String id,@AuthenticationPrincipal UserPrinciple user) {
        System.out.println(required + "  " + id);
        eventService.registerEvent(required, id, user.getId(),user.getDetailId());
        return "user_register";
    }
    

    @GetMapping("/admin/home")
    public String admin_home() {
        return "admin_home";
    }
    
    @GetMapping("/admin/create_event")
    public String Create_event() {
        return "create_event";
    }

    @PostMapping("/admin/add_event")
    public String add_event(Events e,@AuthenticationPrincipal UserPrinciple user) {
  
        eventService.createEvent(e,user.getId());
        return "admin_home";
    }

    @GetMapping("/admin/view_event")
    public String userList(Model model,@AuthenticationPrincipal UserPrinciple user) {
        List<Events> userList = eventService.showevents(user.getId()); 
        model.addAttribute("events", userList);
        return "your_events"; 
    }

    @PostMapping("/admin/event_participants")
    public String postMethodName(Model model,@RequestParam String id) {
        System.out.println(id);
       List<Registers> reg =  eventService.showParticipants(id);
       System.out.println(reg);
       model.addAttribute("regis", reg);
        return "paricipants_list";
    }
    


   
}

