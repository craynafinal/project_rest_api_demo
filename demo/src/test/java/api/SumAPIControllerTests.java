package api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Tests the SumAPI class functionality.
 *
 * @author Jong Seong Lee
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SumAPIControllerTests {

	@Autowired
	private MockMvc mockMvc;

	// Tests if adding functionality works
	@Test
	public void shouldAddNewValue() throws Exception {
		resetValue();
		addValue(1);
		compareSum(1);
	}

	// Tests if removing functionality works
	@Test
	public void shouldResetValue() throws Exception {
		resetValue();
		addValue(1);
		compareSum(1);
		resetValue();
		compareSum(0);
	}

	// Add a given value and expect the OK status
	private void addValue(int value) throws Exception {
		this.mockMvc.perform(post("/api/values")
			.param("value", Integer.toString(value)))
			.andExpect(status().isOk());
	}

	// Removes all values and expects the OK status
	private void resetValue() throws Exception {
		this.mockMvc.perform(delete("/api/values"))
			.andExpect(status().isOk());
	}

	// Compares the sum value and the given value, they must match
	private void compareSum(int value) throws Exception {
		this.mockMvc.perform(get("/api/sum/values"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content").value(Integer.toString(value) + "\n"));
	}
}
