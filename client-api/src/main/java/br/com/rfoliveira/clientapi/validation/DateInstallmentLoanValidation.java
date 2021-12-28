package br.com.rfoliveira.clientapi.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.time.LocalDate;

public class DateInstallmentLoanValidation implements ConstraintValidator<DateFirstLoan, LocalDate> {

    @Override
    public void initialize(DateFirstLoan constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate maxDate = LocalDate.now().plusMonths(3);//add 3 months
        System.out.println("hoje"+ LocalDate.now() +" || 3 meses depois: "+maxDate);

        if(localDate.isAfter(LocalDate.now()) && localDate.isBefore(maxDate))
            return true;

        return false;
    }
}
