package com.nsskumar.cf.service.pagerdutycfservicepoc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.squareup.pagerduty.incidents.NotifyResult;
import com.squareup.pagerduty.incidents.PagerDuty;
import com.squareup.pagerduty.incidents.Trigger;

@RestController
public class EventController {

	@Value("vcap.services.PagerDutyService.credentials.integration_key")
	public static String apiKey;
	
	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public String createEvent(@RequestBody String message) {
		PagerDuty pagerDuty = PagerDuty.create(apiKey);
		Trigger trigger = new Trigger.Builder(message).build();
		NotifyResult result = null;
		try {
			result = pagerDuty.notify(trigger);
		} catch (IOException e) {
			System.err.println("There was a problem while sending the event to PagerDuty. Event message is: " + message );
			e.printStackTrace();
			return "Status: Failed to send event";
		}
		return result.message();
	}
}