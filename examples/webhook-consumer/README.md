This example contains spring boot java project, that can receive and process [SendGrid Webhooks](https://sendgrid.com/docs/API_Reference/Event_Webhook/event.html)

This tutorial depends on macOS terminal, but project can be started on any platform

### Local run

For this step you will need:

 - jdk 8
 - [docker](https://www.docker.com/get-started)

1. cd to sendgrid-java/examples/webhook-consumer

2. Build a docker image from sample project. Run in terminal: `./graldew docker`

3. After build finished you can find new docker image with command 
    `docker images`. 
    
    Our image have name `example/sendgrid-consumer`
    
    example output of `docker images`:
    ```
    REPOSITORY                  TAG                 IMAGE ID            CREATED             SIZE
    example/sendgrid-consumer   latest              5eff0950a8ed        4 seconds ago       119MB
    openjdk                     8-jdk-alpine        97bc1352afde        2 days ago          103MB
    ```
4. Run image with command 
    
    `docker run -p 80:80 example/sendgrid-consumer`

5. After that you can test consumer behavior with curl 
    
    `curl -X POST 'localhost/consumer' -H 'Content-Type:application/json' -d "[{\"email\":\"test@gmail.com\", \"timestamp\":12345}]"`

    In logs of running docker container you will see events logging. Example:
    
    `INFO 1 --- [p-nio-80-exec-1] c.e.sendgrid.demo.SendgridController     : SendgridEvent{email='test@gmail.com', timestamp='12345', smtpId='null', event='null', category='null'}`


### Remote deployment

For example we will use [heroku](https://www.heroku.com) cloud platform

For this step you will need:
 - jdk 8
 - [docker](https://www.docker.com/get-started)
 - account at [sendgrid](https://sendgrid.com)
 - account at [heroku](https://www.heroku.com)
 - [heroku cli](https://devcenter.heroku.com/articles/heroku-cli#download-and-install)

1. Build docker image like decribed in "Local run" section

2. Login to heroku cli in your terminal
    
    `heroku login`

3. Login to heroku docker registry (needed to push our docker image to hosting)
    
    `heroku container:login`

4. Create heroku application for tests

    `heroku create sandgridsample`

    sandgridsample - just example name of a project. You can name your application as you want. 
    But remember to replace `sandgridsample` to your app name in next sections.

5. Now we need to tag our docker image in special way for heroku

    `docker tag example/sendgrid-consumer registry.heroku.com/sandgridsample/web:latest`

6. Now we need to push image to heroku

    `docker push registry.heroku.com/sandgridsample/web`

7. And now run our container

    `heroku container:release web --app sandgridsample`

8. Check in heroku logs for successfull start

    `heroku logs -tail --app sandgridsample`

    You should see message like
    
    `heroku[web.1]: State changed from starting to up`

9. Know your app url

    `heroku info --app sandgridsample`

    We need field `Web URL`

    For sample app it `https://sendgridsample.herokuapp.com/`

10. We need to set your app to receive callbacks from SendGrid
10.1 Go to [SendGrid settings page](https://app.sendgrid.com/settings/mail_settings)
10.2 In section `Event Notification` setup `HTTP POST URL` like `%APP_WEB_URL/consumer` (for example https://sendgridsample.herokuapp.com/consumer)
10.3 Click on `Test your integration` button

11. Check logs in heroku app 
    
    `heroku logs -tail --app sandgridsample`
    
    Where you can see logging for test events from sendgrid.

You are done!
### Project Structure

`DemoApplication.java`

Main class to run web application with spring boot.

`SendgridController.java`

Spring MVC controller for receiving and consume events. Accept http POST requests on url `/consumer`.
In our example it just log received events.

`SendgridEvent.java`
 
Model object for sendgrid events. This concrete implementation contains not all available fields. You can add fields you needed Full documentation on it you can find [here](https://sendgrid.com/docs/API_Reference/Event_Webhook/event.html#-Events) 