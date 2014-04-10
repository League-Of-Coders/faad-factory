package com.app.core.registration.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class EmailAlreadyRegisteredValidator extends FieldValidatorSupport{

	@Override
	public void validate(Object arg0) throws ValidationException {
		String fieldName = getFieldName();
		Object value = getFieldValue(fieldName,arg0);
		
	}

}
