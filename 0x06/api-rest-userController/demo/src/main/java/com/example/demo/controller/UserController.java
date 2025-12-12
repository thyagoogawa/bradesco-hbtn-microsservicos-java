
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@GetMapping("/user-id/{id}")
	public String findUserById(@PathVariable int id) {
	
	   String msg = "You have entered valid ID";
	   
	   if ( !isValidId(id)) {
		   throw new UserIdException(String.valueOf(id));
	   }
	   
	   return msg;
	}
	
	@GetMapping("/user-name/{userName}")
	public String findUserByName(@PathVariable String userName) {
	
	   String msg = "You have entered valid USERNAME";
	   
	   if ( !isValidName(userName)) {
		   throw new UserNameException(userName);
	   }
	   
	   return msg;
	}
	
	@GetMapping("/user-cpf/{cpf}")
	public String findUserByCPF(@PathVariable String cpf) {
	
	   String msg = "You have entered valid CPF";
	   if ( !isCPFValid(cpf)) {
		   throw new CPFException(cpf);
	   }
	   
	   return msg;
	
	}
	
	private boolean isValidId(int id) {
		if (Integer.compare(id, 0) > 0 || Integer.compare(id, -100) < 0) {
			return true;
		}
		return false;
	}
	
	private boolean isValidName(String userName) {
		if (userName.length() > 3 && userName.length() < 15) {
			return true;
		}
		return false;
	}
	
	private boolean isCPFValid(String CPF) {
		if (CPF.length() > 3 && CPF.length() < 15) {
			return true;
		}
		return false;
	}

}
