# Credit-suisse-event-log-details
Coding Assignment of Credit-suisse

the service layered Architecture has been followed in this application where I am using two controllers 
one to save the events and other one to fetch all the saved events.

I have used In-memory HSQL DB. Details of it must be available in the application.properties file.

Here is the Endpoint Details:
1. http://localhost:8080/api/event/save-Event-Logs

![alt text](https://github.com/000GEV744/Credit-suisse-event-log-details/blob/master/app-related-Screenshots/savnig-All-events.JPG)

2. http://localhost:8080/api/event/

![alt text](https://github.com/000GEV744/Credit-suisse-event-log-details/blob/master/app-related-Screenshots/getting-all-events.JPG)


3.Incase none of the events are saved and we are hitting the same endpoint again i.e. http://localhost:8080/api/event/

![alt text](https://github.com/000GEV744/Credit-suisse-event-log-details/blob/master/app-related-Screenshots/If-no-events-saved.JPG)

4. Swagger-ui 

![alt text](https://github.com/000GEV744/Credit-suisse-event-log-details/blob/master/app-related-Screenshots/swagger-ui.JPG)
