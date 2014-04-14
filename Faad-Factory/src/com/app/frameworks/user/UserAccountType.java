package com.app.frameworks.user;

import com.app.core.AppEngine;

public enum UserAccountType {
	ACTOR,DIRECTOR,PRODUCER,CHOREGRAPHER,CAMERAMAN,OTHERS;
	
	private String actualUserAccountType;
	private UserAccountType(){
		this.actualUserAccountType = AppEngine.getInstance().changeToPoperCase(this.name());
	}
	public String toString() {
		return actualUserAccountType;
	}

	public void specifyUserAccountType(String userAccountType) {
		this.actualUserAccountType = userAccountType;
	}
	public static UserAccountType getUserAcountTypeFromString(String type)
	{
		for(UserAccountType userAccountType: UserAccountType.values())
			if(userAccountType.actualUserAccountType.equals(AppEngine.getInstance().changeToPoperCase(type)))
				return userAccountType;
			
		throw new UserAccountTypeException("User Account Type : " + type + " not found");
		
	}
	
}
