package com.gucarsoft.ws.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ErrorHandler implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    ApiError handleError(WebRequest webRequest) {
        ApiError apiError = new ApiError();
        Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(webRequest, true);
        String message = (String) attributes.get("message");
        String path = (String) attributes.get("path");
        int status = (int) attributes.get("status");
        apiError.setMessage(message);
        apiError.setPath(path);
        apiError.setStatus(status);

        Map<String, String> validationError = new HashMap<>();

        List<FieldError> fieldErrors = (List<FieldError>) attributes.get("errors");

        for (FieldError fieldError : fieldErrors) {
            validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        apiError.setValidationErrors(validationError);

        return apiError;
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
