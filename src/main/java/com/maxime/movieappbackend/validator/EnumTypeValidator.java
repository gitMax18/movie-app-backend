package com.maxime.movieappbackend.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.maxime.movieappbackend.annotation.EnumTypeAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumTypeValidator implements ConstraintValidator<EnumTypeAnnotation, String> {
    private List<String> acceptedValues;

    @Override
    public void initialize(EnumTypeAnnotation annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return acceptedValues.contains(value.toString());
    }
}