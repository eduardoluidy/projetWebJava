package ufrn.br.projetoaulaweb.errorHandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//filtra os controladores
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
}
