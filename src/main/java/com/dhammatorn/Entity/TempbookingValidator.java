//package com.dhammatorn.Entity;
//
////import javax.validation.Validator;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//public class TempbookingValidator implements Validator {
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Student.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//
//        Tempbooking myClass = (Tempbooking) target;
//        int endTime = Integer.parseInt(myClass.getEndTime());
//        int length = endTime - Integer.parseInt(myClass.getStartTime());
//
//        if(length < 0) {
//            errors.rejectValue("startTime", "length.error", "Start time is not valid");
//        }
////                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "", "required.name","Field name is required.");
//    }
//}
