package assis.lucas.lojaroupas.seguranca.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception) {
		exception.printStackTrace();
		ErrorMessage mensagem = new ErrorMessage(exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
	}
	
}
