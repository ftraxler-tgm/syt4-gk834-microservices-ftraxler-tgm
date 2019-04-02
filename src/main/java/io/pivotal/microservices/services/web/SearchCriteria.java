package io.pivotal.microservices.services.web;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public class SearchCriteria {
	private String userNumber;

	private String searchText;

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public boolean isValid() {
		if (StringUtils.hasText(userNumber))
			return !(StringUtils.hasText(searchText));
		else
			return (StringUtils.hasText(searchText));
	}

	public boolean validate(Errors errors) {
<<<<<<< HEAD
		if (StringUtils.hasText(userNumber)) {
			if (userNumber.length() != 9)
				errors.rejectValue("userNumber", "badFormat",
=======
		if (StringUtils.hasText(accountNumber)) {
			if (accountNumber.length() != 9)
				errors.rejectValue("accountNumber", "badFormat",
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2
						"User number should be 9 digits");
			else {
				try {
					Integer.parseInt(userNumber);
				} catch (NumberFormatException e) {
<<<<<<< HEAD
					errors.rejectValue("userNumber", "badFormat",
=======
					errors.rejectValue("accountNumber", "badFormat",
>>>>>>> 82d1aca89fbada94304afc599ec1c0e8ca21bad2
							"User number should be 9 digits");
				}
			}

			if (StringUtils.hasText(searchText)) {
				errors.rejectValue("searchText", "nonEmpty",
						"Cannot specify user number and search text");
			}
		} else if (StringUtils.hasText(searchText)) {
			; // Nothing to do
		} else {
			errors.rejectValue("userNumber", "nonEmpty",
					"Must specify either an user number or search text");

		}

		return errors.hasErrors();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (StringUtils.hasText(userNumber) ? "number: " + userNumber
				: "")
				+ (StringUtils.hasText(searchText) ? " text: " + searchText
						: "");
	}
}
