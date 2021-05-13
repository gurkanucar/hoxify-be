package com.gucarsoft.ws.utils;

import com.gucarsoft.ws.model.user.UniqueUsernameValidator;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@AuthenticationPrincipal
public @interface CurrentUser {
}
