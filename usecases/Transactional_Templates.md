# Transactional Templates

For this example, we assume you have created a [transactional template](https://sendgrid.com/docs/User_Guide/Transactional_Templates/index.html). Following is the template content we used for testing.

Template ID (replace with your own):

```text
d-2c214ac919e84170b21855cc129b4a5f
```
Email Subject:

```text
{{subject}}
```
Template Body:

```html
<html>
  <head>
    <title></title>
  </head>
  <body>
    Hello {{name}},
    <br/><br/>
    I'm glad you are trying out the template feature!
    <br/><br/>
    I hope you are having a great day in {{city}} :)
    <br/><br/>
  </body>
</html>
```