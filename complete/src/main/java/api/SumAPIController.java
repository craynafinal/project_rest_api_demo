package api;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumAPIController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/api/values")
	public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
		 return "ok";
	}

	@RequestMapping("/api/sum/values")
	public int sumValues() {
		return 1;
	}
}
