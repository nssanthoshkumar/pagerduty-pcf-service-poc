## PagerDuty PCF Service POC
If PageDuty is offered as PCF Service, then this POC will help you to get started with it.  As part of this POC, PagerDuty API key will be injected into the application and that will be used to send notification to PagerDuty.


### Test your application
1. Create a Service Instance of PagerDuty Service from the PCF Marketplace and Bind it to the your application. Once bound to your app, the integration key will be available in the below environment variable. If it is different, update the same in EventController class and rebuild your application.

```
vcap.services.PagerDutyService.credentials.integration_key
```

2. Build the application and Push it to PCF.

3. Once the application is up and running, Send the below POST request to create Event in PagerDuty.

```
Request URL: http://localhost:8080/event
Request Method: POST
Request Body: "Test incident. Please ignore."
```

4. All the org users will get the email notification. You can click the link in the email to view the event in PagerDuty console.

### Further Reference
This POC is based on PagerDuty Incidents for Java Library. This is a recommended library by PagerDuty for Java. You can refer the below github repository for further details.

https://github.com/square/pagerduty-incidents
