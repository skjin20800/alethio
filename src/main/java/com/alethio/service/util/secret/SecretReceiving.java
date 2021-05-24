package com.alethio.service.util.secret;

public class SecretReceiving {
	
	// 쿠망 암호화
	public static String ItemNameToCoumang(String receiving) {
		return "123"+receiving;		
	}
	
	// 아마돈 암호화
	public static String ItemNameToAmadon(String receiving) {
		return receiving+"123";		
	}


}
