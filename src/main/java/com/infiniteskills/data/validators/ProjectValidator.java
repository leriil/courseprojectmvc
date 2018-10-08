package com.infiniteskills.data.validators;

import com.infiniteskills.data.entities.Project;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProjectValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Project.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Project project=(Project) o;
        if(project.getName().isEmpty()){
            errors.rejectValue("name","project.name","the name is obligatory");
        }
    }
}
