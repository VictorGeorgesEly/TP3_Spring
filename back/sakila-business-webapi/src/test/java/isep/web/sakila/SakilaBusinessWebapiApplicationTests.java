package isep.web.sakila;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SakilaBusinessWebapiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void loginWithValidUser() throws Exception {
		FormLoginRequestBuilder login = formLogin()
				.user("login")
				.password("password");

		mockMvc.perform(login)
		.andExpect(authenticated().withUsername("login"));
	}

	@Test
	public void loginWithInvalidUser() throws Exception {
		FormLoginRequestBuilder login = formLogin()
				.user("invalid")
				.password("invalidpassword");

		mockMvc.perform(login)
		.andExpect(unauthenticated());
	}

}
