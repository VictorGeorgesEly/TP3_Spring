package isep.web.sakila.webapi.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isep.web.sakila.webapi.model.CredentialsWO;
import isep.web.sakila.webapi.security.JWTUtil;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private JWTUtil jwtUtil;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<String> refreshToken(@RequestBody CredentialsWO ids, HttpServletResponse response) {

		if(ids.getUserName().equals("admin") && ids.getPassword().equals("adminPwd")) {
			String token = jwtUtil.generateToken("Admin");
			response.addHeader("Authorization", "Bearer " + token);
			return new ResponseEntity<String>(token, HttpStatus.OK);
		}

		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

}
