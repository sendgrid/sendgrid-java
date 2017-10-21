#!/bin/bash

curl \
  -F "sdk=@./repo/com/sendgrid/sendgrid-java-latest.jar" \
  -H "X-Key: $UPLOAD_SECRET" \
  https://dx.sendgrid.com/upload

exit 0
