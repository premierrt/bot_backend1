package bot_backend1.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bot_backend1.service.VerificationService;


@RestController
@RequestMapping("/webhook")
public class WebhookController {

	

	@Autowired
	private VerificationService verificationService;
	private static final Log log = LogFactory.getLog(WebhookController.class);
	
	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<?> handleFBWebhook(String request){
		log.info("====================== webook post request mapping ===================");
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> verifyFBWebhook (@RequestParam("hub.mode") String mode,
											  @RequestParam("hub.verify_token") String verifyToken,
											  @RequestParam("hub.challenge") String challenge){
		
		log.info("==============fb verification get ======" + " mode =" +mode + " token="+verifyToken + " challange ="+challenge);
		if (verificationService.verifyWebhook(mode, verifyToken, challenge))
			return ResponseEntity.status(HttpStatus.OK).body(challenge);
		else 
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}


}
