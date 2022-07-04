package de.tum.in.ase.eist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebPageResource {

	private final QueryProcessor queryProcessor;

	public WebPageResource(QueryProcessor queryProcessor) {
		this.queryProcessor = queryProcessor;
	}

	@GetMapping("/*")
	public String frontpage(@RequestParam(value = "q", required = false) String query, Model model) {
		if (query == null) {
			return "index";
		}
		String answer = queryProcessor.process(query);
		model.addAttribute("query", query);
		model.addAttribute("answer", answer);
		return "answer";

	}
}
