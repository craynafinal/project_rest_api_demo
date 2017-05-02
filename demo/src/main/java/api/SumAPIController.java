package api;
import org.springframework.web.bind.annotation.*;

/**
 * Route controller for SumAPI api.
 *
 * @author Jong Seong Lee
 *
 */

@RestController
public class SumAPIController {
	private static SumAPI sumApi = new SumAPI();

	// Deliver a value to api to add for sum calculation
	@RequestMapping(method = RequestMethod.POST, value = "/api/values")
	public String values(@ModelAttribute("value") int value) {
		sumApi.addValue(value);
		return "ok\n";
	}

	// Reset sum value from SumAPI
	@RequestMapping(method = RequestMethod.DELETE, value = "/api/values")
  public String resetValue() {
    sumApi.removeAll();
    return "ok\n";
  }

	// Prints the sum value
	@RequestMapping(value = "/api/sum/values")
	public String sumValues() {
		return sumApi.getSum() + "\n";
	}


}
