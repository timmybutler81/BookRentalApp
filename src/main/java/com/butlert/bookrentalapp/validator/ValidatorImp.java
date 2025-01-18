package com.butlert.bookrentalapp.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidatorImp {

    private final Map<Class<?>, BaseValidator<?>> validators = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(ValidatorImp.class);

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
        logger.info("Validating for {}", object);
    }

    public Class<?> getGenericType(BaseValidator<?> validator) {
        ParameterizedType type = (ParameterizedType) validator.getClass().getGenericInterfaces()[0];
        return (Class<?>) type.getActualTypeArguments()[0];
    }
}
