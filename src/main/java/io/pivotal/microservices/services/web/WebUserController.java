package io.pivotal.microservices.services.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client controller, fetches User info from the microservice via
 * {@link WebUserService}.
 * 
 * @author Paul Chapman
 */
@Controller
public class WebUserController {

	@Autowired
	protected WebUserService usersService;

	protected Logger logger = Logger.getLogger(WebUserController.class
			.getName());

	public WebUserController(WebUserService usersService) {
		this.usersService = usersService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("userNumber", "searchText");
	}

	@RequestMapping("/users")
	public String goHome() {
		return "index";
	}


	@RequestMapping("/user/{text}")
	public String ownerSearch(Model model, @PathVariable("text") String name) {
		logger.info("web-service byOwner() invoked: " + name);

		List<User> users = usersService.byNameContains(name);
		logger.info("web-service byOwner() found: " + users);
		model.addAttribute("search", name);
		if (users != null)
			model.addAttribute("users", users);
		return "user";
	}

	@RequestMapping(value = "/users/search", method = RequestMethod.GET)
	public String searchForm(Model model) {
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "userSearch";
	}


}
