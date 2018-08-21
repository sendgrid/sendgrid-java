![SendGrid Logo](https://uiux.s3.amazonaws.com/2016-logos/email-logo%402x.png)
 +
 +This folder contains various examples on using the ACCESS_SETTINGS endpoint of SendGrid with Java:
 +
 +* [Retrieve a list of currently whitelisted IPs (GET /access_settings/whitelist)](GetAccessSettings.java)
 +* [Retrieve a specific whitelisted IP (GET /access_settings/whitelist/{rule_id})](GetIPFromAccessSettings.java)
 +* [Retrieve a list of currently whitelisted IPs (GET /access_settings/whitelist)](GetAccessSettingsActivity.java)
 +* [Remove a specific IP from the whitelist (DELETE /access_settings/whitelist/{rule_id}](DeleteIPFromAccessSettings.java)
 +* [Remove one or more IPs from the whitelist (DELETE /access_settings/whitelist)](DeleteAccessSettings.java)
 +* [Add one or more IPs to the whitelist (POST /access_settings/whitelist)](CreateAccessSettings.java)