This example contains spring boot java project that can receive and process [SendGrid Webhooks](https://sendgrid.com/docs/API_Reference/Event_Webhook/event.html)

This tutorial requires a macOS terminal, but the project can be started on any platform

### Local Run

For this step you will need:

 - JDK 8
 - [Docker](https://www.docker.com/get-started)

1. `cd` to sendgrid-java/examples/webhook-consumer

2. Build a docker image from sample project. Run in terminal: `./graldew docker`

3. After build is finished you can find new docker image with a `docker images` command
    
    Our image is called `example/sendgrid-consumer`
    
    Example output of `docker images`:
    ```
    REPOSITORY                  TAG                 IMAGE ID            CREATED             SIZE
    example/sendgrid-consumer   latest              5eff0950a8ed        4 seconds ago       119MB
    openjdk                     8-jdk-alpine        97bc1352afde        2 days ago          103MB
    ```
4. To run the image, execute:

    `docker run -p 80:80 example/sendgrid-consumer`

5. After that you can test consumer behavior with curl 
    
    `curl -X POST 'localhost/consumer' -H 'Content-Type:application/json' -d "[{\"email\":\"test@gmail.com\", \"timestamp\":12345}]"`

    Running docker container logs show received events. Example:
    
    `INFO 1 --- [p-nio-80-exec-1] c.e.sendgrid.demo.SendgridController     : SendgridEvent{email='test@gmail.com', timestamp='12345', smtpId='null', event='null', category='null'}`


### Remote Deployment

We will use [Heroku](https://www.heroku.com) cloud platform as an example

For this step you will need:
 - JDK 8
 - [Docker](https://www.docker.com/get-started)
 - [SendGrid](https://sendgrid.com) account
 - [Heroku](https://www.heroku.com) account
 - [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli#download-and-install)

1. Build docker image like as described in the Local Run section

2. Log into Heroku CLI in your terminal
    
    `heroku login`

3. Login to Heroku docker registry
    
    `heroku container:login`

4. Create Heroku application for tests

    `heroku create sandgridsample`

    `sandgridsample` is just an example name. You can name your application whatever you like, but remember to replace `sandgridsample` with your app's name in the next sections

5. Now we need to tag our docker image in a special way for Heroku

    `docker tag example/sendgrid-consumer registry.heroku.com/sandgridsample/web:latest`

6. Now we need to push the image to Heroku

    `docker push registry.heroku.com/sandgridsample/web`

7. Then run our container

    `heroku container:release web --app sandgridsample`

8. Check in Heroku logs for a successful start

    `heroku logs -tail --app sandgridsample`

    The following message will appear
    
    `heroku[web.1]: State changed from starting to up`

9. Check your app's URL

    `heroku info --app sandgridsample`

    We need the field `Web URL`

    In this case app's URL is `https://sendgridsample.herokuapp.com/`

10. We need to set the app to receive callbacks from SendGrid

    10.1 Go to [SendGrid settings page](https://app.sendgrid.com/settings/mail_settings)
    
    10.2 In the section `Event Notification` set `HTTP POST URL` as follows: `%APP_WEB_URL/consumer` (for example https://sendgridsample.herokuapp.com/consumer)
    
    10.3 Click the `Test your integration` button

11. Check logs in the Heroku app 
    
    `heroku logs -tail --app sandgridsample`
    
    Here you can see the SendGrid test event logs

Success!
### Project Structure

`DemoApplication.java`

Main class to run web application with spring boot

`SendgridController.java`

Spring MVC controller for receiving and consume events. Accept http POST requests on the `/consumer` URL.
In our example it just logs received events

`SendgridEvent.java`
 
Model object for SendGrid events. This particular implementation doesn't contain all available fields. More fields can be added if necessary. You may find full documentation [here](https://sendgrid.com/docs/API_Reference/Event_Webhook/event.html#-Events) 