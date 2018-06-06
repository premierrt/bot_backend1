package bot_backend1.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/webhook")
public class WebhookController {

	private static final Log log = LogFactory.getLog(WebhookController.class);
	
	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<?> handleFBWebhook(String request){
		log.info("====================== webook post request mapping ===================");
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
