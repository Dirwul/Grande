package tech.dirwul.grande.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/home")
	public String mainPage() {
		return "main-page";
	}
}
