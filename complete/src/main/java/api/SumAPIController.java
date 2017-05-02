package api;
import org.springframework.web.bind.annotation.*;

@RestController
public class SumAPIController {
	private static SumAPI sumApi = new SumAPI();

	@RequestMapping(method = RequestMethod.POST, value = "/api/values")
	public String values(@ModelAttribute("value") int value) {
		sumApi.addValue(value);
		return "ok\n";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/values")
  public String deleteValues() {
    sumApi.removeAll();
    return "ok\n";
  }

	@RequestMapping(value = "/api/sum/values")
	public String sumValues() {
		return sumApi.getSum() + "\n";
	}


}
