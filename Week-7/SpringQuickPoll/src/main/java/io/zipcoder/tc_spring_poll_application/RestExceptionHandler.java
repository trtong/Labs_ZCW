package io.zipcoder.tc_spring_poll_application;

import io.zipcoder.tc_spring_poll_application.error.ErrorDetail;
import io.zipcoder.tc_spring_poll_application.error.ValidationError;
import io.zipcoder.tc_spring_poll_application.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe, HttpServletRequest request) {

        ErrorDetail ed = new ErrorDetail();

        ed.setTimeStamp(new Date().getTime());
        ed.setTitle("Resource Not Found.");
        ed.setStatus(404);
        ed.setDetail("Unable to complete request or entity was not found.");
        ed.setDeveloperMessage(Arrays.toString(rnfe.getStackTrace()));

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>
    handleValidationError(MethodArgumentNotValidException manve, HttpServletRequest request){
        ErrorDetail ed = new ErrorDetail();

        ed.setTimeStamp(new Date().getTime());
        ed.setTitle("Validation Failure");
        ed.setStatus(404);
        ed.setDetail("Unable to complete request.");
        ed.setDeveloperMessage(Arrays.toString(manve.getStackTrace()));


        List<FieldError> fieldErrors =  manve.getBindingResult().getFieldErrors();
        for(FieldError fe : fieldErrors) {

            List<ValidationError> validationErrorList = ed.getErrors().computeIfAbsent(fe.getField(), k -> new ArrayList<>());
            ValidationError validationError = new ValidationError();
            validationError.setCode(fe.getCode());
            validationError.setMessage(messageSource.getMessage(fe,null));
            validationErrorList.add(validationError);
        }

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }
}
