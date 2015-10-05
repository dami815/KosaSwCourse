package com.mycompany.myapp.dto;

import org.slf4j.*;
import org.springframework.validation.*;

public class MemberValidator implements Validator {
	private static final Logger logger = LoggerFactory.getLogger(MemberValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", "required", "필수 항목입니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberName", "required", "필수 항목입니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberPassword", "required", "필수 항목입니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberBirthday", "required", "필수 항목입니다");
		
		int passwordLength = member.getMemberPassword().length();
		if(passwordLength<4) {
			errors.rejectValue("memberPassword", "minlength", new Object[] {4, passwordLength}, "최소 4자리 이상 입력");
		}
	}

}
