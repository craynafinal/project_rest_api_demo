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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SumAPIControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldAddNewValue() throws Exception {
		removeAllValues();
		addValue(1);
		compareSum(1);
	}

	@Test
	public void shouldRemoveValues() throws Exception {
		removeAllValues();
		addValue(1);
		compareSum(1);
		removeAllValues();
		compareSum(0);
	}

	private void addValue(int value) throws Exception {
		this.mockMvc.perform(post("/api/values")
      .param("value", Integer.toString(value)))
      .andExpect(status().isOk());
	}

	private void removeAllValues() throws Exception {
		this.mockMvc.perform(delete("/api/values"))
      .andExpect(status().isOk());
	}

	private void compareSum(int value) throws Exception {
		this.mockMvc.perform(get("/api/sum/values"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content").value(Integer.toString(value) + "\n"));
	}
}
