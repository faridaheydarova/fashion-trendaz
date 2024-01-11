package fashion.trendaz.fashiontrendazproject.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
	
	    @GetMapping("/admin")
	    public String adminDashboard(Principal principal) {
	   
	        principal.getName(); 
	        return "admin-dashboard";
	    }
	}


