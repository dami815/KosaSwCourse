package com.mycompany.myapp.dto;

import org.slf4j.*;
import org.springframework.validation.*;

public class LoginValidator implements Validator {
	private static final Logger logger = LoggerFactory.getLogger(LoginValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Login login = (Login) target;
		String memberId = login.getMemberId();
		/*if(memberId == null || memberId.equals("")) {
			errors.rejectValue("memberId", "required", "필수 항목입니다");
		}*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", "required", "필수 항목입니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberPW", "required", "필수 항목입니다");
		
		int passwordLength = login.getMemberPW().length();
		if(passwordLength<4) {
			errors.rejectValue("memberPW", "minlength", new Object[] {4, passwordLength}, "최소 4자리 이상 입력");
		}
	}

}
