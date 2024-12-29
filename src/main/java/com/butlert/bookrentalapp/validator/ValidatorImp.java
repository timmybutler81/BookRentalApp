package com.butlert.bookrentalapp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidatorImp {

    private final Map<Class<?>, BaseValidator<?>> validators = new HashMap<>();

    @Autowired
    public ValidatorImp(List<BaseValidator<?>> validatorList) {
        for (BaseValidator<?> validator : validatorList) {
            validators.put(getGenericType(validator), validator);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void validate(T object) {
        BaseValidator<T> validator = (BaseValidator<T>) validators.get(object.getClass());
        if (validator == null) {
            throw new IllegalArgumentException("No Validator found for class: " + object.getClass().getName());
        }
        validator.validate(object);
    }

    public Class<?> getGenericType(BaseValidator<?> validator) {
        ParameterizedType type = (ParameterizedType) validator.getClass().getGenericInterfaces()[0];
        return (Class<?>) type.getActualTypeArguments()[0];
    }
}
