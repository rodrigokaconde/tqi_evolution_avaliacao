package br.com.rfoliveira.clientapi.validationLoan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateInstallmentInstallmentValidation implements ConstraintValidator<DateFirstInstallment, LocalDate> {

    @Override
    public void initialize(DateFirstInstallment constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate maxDate = LocalDate.now().plusMonths(3);//add 3 months

        if(localDate.isAfter(LocalDate.now()) && localDate.isBefore(maxDate))
            return true;

        return false;
    }
}
