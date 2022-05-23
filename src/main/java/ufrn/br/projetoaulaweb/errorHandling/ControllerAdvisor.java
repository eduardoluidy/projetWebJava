package ufrn.br.projetoaulaweb.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//filtra os controladores
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<Object> handleContraintViolationException(
            final ConstraintViolationException ex, final WebRequest request) {

        logger.info(ex.getClass().getName());

        final List<String> erros = new ArrayList<>();
        for(final ConstraintViolation<?> violation : ex.getConstraintViolations()){
            erros.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
        }
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error name", ex.getLocalizedMessage());
        body.put("errors", erros);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
/*
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<Object> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex, WebRequest request) {

        logger.info(ex.getClass().getName());

        final String error = ex.getParameterName() + " faltando parametro";
        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error name", ex.getLocalizedMessage());
        body.put("errors", erros);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

 */
}
