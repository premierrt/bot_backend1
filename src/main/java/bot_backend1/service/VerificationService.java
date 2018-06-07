package bot_backend1.service;

import org.springframework.stereotype.Service;

@Service
public class VerificationService {

	
	private static final String tokenFB = "bot_verify_token";
	private static final String modeFB = "subscribe";
	public boolean verifyWebhook(String mode, String token, String challange){
		
		if  ( tokenFB.equals(token) && modeFB.equals(mode))
			return true;
		else
			return false;
			
	}
}
