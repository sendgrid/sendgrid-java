#!/bin/bash

curl https://raw.githubusercontent.com/stoplightio/prism/master/install.sh | sh
prism run --mock --list --spec https://raw.githubusercontent.com/sendgrid/sendgrid-oai/master/oai_stoplight.json

