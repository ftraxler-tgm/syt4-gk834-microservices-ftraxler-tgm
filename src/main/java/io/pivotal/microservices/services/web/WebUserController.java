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
<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/web/WebUserController.java
 * {@link WebUserService}.
=======
 * {@link WebAccountsService}.
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/web/WebAccountsController.java
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

	@RequestMapping("/users/{userNumber}")
	public String byNumber(Model model,
			@PathVariable("userNumber") String userNumber) {

		logger.info("web-service byNumber() invoked: " + userNumber);

<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/web/WebUserController.java
		User user = usersService.findByNumber(userNumber);
		logger.info("web-service byNumber() found: " + user);
		model.addAttribute("user", user);
=======
		User user = accountsService.findByNumber(accountNumber);
		logger.info("web-service byNumber() found: " + user);
		model.addAttribute("account", user);
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/web/WebAccountsController.java
		return "user";
	}

	@RequestMapping("/users/owner/{text}")
	public String ownerSearch(Model model, @PathVariable("text") String name) {
		logger.info("web-service byOwner() invoked: " + name);

<<<<<<< HEAD:src/main/java/io/pivotal/microservices/services/web/WebUserController.java
		List<User> users = usersService.byOwnerContains(name);
		logger.info("web-service byOwner() found: " + users);
		model.addAttribute("search", name);
		if (users != null)
			model.addAttribute("users", users);
		return "user";
=======
		List<User> users = accountsService.byOwnerContains(name);
		logger.info("web-service byOwner() found: " + users);
		model.addAttribute("search", name);
		if (users != null)
			model.addAttribute("accounts", users);
		return "users";
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2:src/main/java/io/pivotal/microservices/services/web/WebAccountsController.java
	}

	@RequestMapping(value = "/users/search", method = RequestMethod.GET)
	public String searchForm(Model model) {
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "userSearch";
	}

	@RequestMapping(value = "/users/dosearch")
	public String doSearch(Model model, SearchCriteria criteria,
			BindingResult result) {
		logger.info("web-service search() invoked: " + criteria);

		criteria.validate(result);

		if (result.hasErrors())
			return "userSearch";

		String userNumber = criteria.getUserNumber();
		if (StringUtils.hasText(userNumber)) {
			return byNumber(model, userNumber);
		} else {
			String searchText = criteria.getSearchText();
			return ownerSearch(model, searchText);
		}
	}
}
