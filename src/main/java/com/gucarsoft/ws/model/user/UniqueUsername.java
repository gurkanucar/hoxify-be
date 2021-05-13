package com.gucarsoft.ws.model.user;


@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD,})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@javax.validation.Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {

    java.lang.String message() default "Username must be unique";

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends javax.validation.Payload>[] payload() default {};


}
