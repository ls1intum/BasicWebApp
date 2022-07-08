package de.tum.in.ase.eist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api", produces = {MediaType.TEXT_PLAIN_VALUE})
public class AnswerResource {

	private final Logger logger = LoggerFactory.getLogger(AnswerResource.class);

	private final QueryProcessor queryProcessor;

	public AnswerResource(QueryProcessor queryProcessor) {
		this.queryProcessor = queryProcessor;
	}

	@GetMapping("*")
	public ResponseEntity<String> answer(@RequestParam("q") String query) {
		logger.info("Received query \"{}\"", query);
		String answer = queryProcessor.process(query);
		return ResponseEntity.ok(answer);
	}

}
