#!/bin/bash

VERSION="4.0.1"

curl \
  -F "sdk=@./repo/com/sendgrid/sendgrid-java-$VERSION.jar" \
  -H "X-Key: $UPLOAD_SECRET" \
  http://dx.sendgrid.com/upload

curl \
  -F "sdk=@./repo/com/sendgrid/sendgrid-java-latest.jar" \
  -H "X-Key: $UPLOAD_SECRET" \
  http://dx.sendgrid.com/upload

exit 0
