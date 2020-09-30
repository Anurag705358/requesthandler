package com.example.requesthandler.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.requesthandler.bean.Request;

@RestController
public class RequestController {
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

	@Autowired
	private RequestService requestService;

	@PostMapping("/process")
	public String processRequest(@RequestBody Request request) {
		logger.info(" process controller starts");
		try {
			requestService.processRequest(request);
		} catch (Exception e) {
			logger.info(e.getMessage());

			return e.getMessage();
		}
		logger.info(" process controller ends");

		return "Success";
	}

	@PutMapping("/end")
	public String endRequest(@RequestBody Request request) {
		logger.info(" end controller starts");

		try {
			requestService.endRequest(request);
		} catch (Exception e) {
			logger.info(e.getMessage());

			return e.getMessage();
		}
		logger.info(" end controller ends");

		return "Success Processed";
	}

}
