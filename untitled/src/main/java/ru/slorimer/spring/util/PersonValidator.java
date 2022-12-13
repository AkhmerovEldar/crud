package ru.slorimer.spring.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.slorimer.spring.DAO.userDAO;
import ru.slorimer.spring.model.User;

@Component
public class PersonValidator implements Validator {
    private userDAO userdAO;
    public PersonValidator(userDAO userdAO) {
        this.userdAO = userdAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (userdAO.show(user.getEmail()).isPresent()){
            errors.rejectValue("email", "", "this email is already exist");
        }
    }
}
