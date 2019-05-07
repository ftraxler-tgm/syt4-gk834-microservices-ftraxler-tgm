package io.pivotal.microservices.services.user;

import io.pivotal.microservices.user.User;
import io.pivotal.microservices.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.logging.Logger;

/**
 * Home page controller.
 * 
 * @author Paul Chapman
 */
@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String home() {
		return "index";
	}




}
