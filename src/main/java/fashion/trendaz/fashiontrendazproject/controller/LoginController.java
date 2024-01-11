package fashion.trendaz.fashiontrendazproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path="/login")
@CrossOrigin(origins = "*")
public class LoginController {

	  @GetMapping("/admin")
	    public String login() {
	        return "admin-login";
	    }
}
