package com.maxime.movieappbackend.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.maxime.movieappbackend.validator.EnumTypeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumTypeValidator.class)
public @interface EnumTypeAnnotation {

    Class<? extends Enum<?>> enumClass();

    String message() default "Not a valid Value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
