
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

	@ExceptionHandler
	ResponseEntity<UserErrorResponse> handleIdException(UserIdException ex){
		UserErrorResponse uer = new UserErrorResponse();
		uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
		uer.setMessage("You have entered id " + ex.getMessage() + " invalid.");
		return new ResponseEntity<>(uer, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler
	ResponseEntity<UserErrorResponse> handleNameException(UserNameException ex){
		UserErrorResponse uer = new UserErrorResponse();
		uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
		uer.setMessage("You have entered name " + ex.getMessage() + " invalid.");
		return new ResponseEntity<>(uer, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler
	ResponseEntity<UserErrorResponse> handleCPFException(CPFException ex){
		UserErrorResponse uer = new UserErrorResponse();
		uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
		uer.setMessage("You have entered CPF " + ex.getMessage() + " invalid.");
		return new ResponseEntity<>(uer, HttpStatus.BAD_REQUEST); 
	}
	
}
