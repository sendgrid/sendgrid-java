#!/bin/bash

if [[ -z "$(command -v prism)" ]]; then
  curl https://raw.githubusercontent.com/stoplightio/prism/master/install.sh | sh
fi

prism run --mock --list --spec https://raw.githubusercontent.com/sendgrid/sendgrid-oai/master/oai_stoplight.json

