package fashion.trendaz.fashiontrendazproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(path = "/home")
    public String showHomePage() {
       
        return "home"; // Bu, döndüğünüz view adını temsil etmeli
    }
}

//@Autowired
//private MySession mySession;


/*public String showHomePage(Model model) {

	String username=mySession.getUsername();
	if(username.equals("anonymousUser")){
	}else{
		model.addAttribute("username", username);
	}
	return "";
	
}*/