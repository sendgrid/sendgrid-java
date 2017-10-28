![SendGrid Logo](https://uiux.s3.amazonaws.com/2016-logos/email-logo%402x.png)

This folder contains various examples on using the IPs endpoint of SendGrid with Java:

* [Retrieve all IP addresses (GET /ips)](retrieveallips.java)
* [Retrieve all assigned IPs (GET /ips/assigned)](retrieveassignedips.java)
* [Create an IP pool (POST /ips/pools)](createpool.java)
* [Retrieve all IP pools (GET /ips/pools)](retrieveallpools.java)
* [Update an IP pools name (PUT /ips/pools/{pool_name})](updatepoolname.java)
* [Retrieve all IPs in a specified pool (GET /ips/pools/{pool_name})](retrieveipsinpool.java)
* [Delete an IP pool. (DELETE /ips/pools/{pool_name})](deletepool.java)
* [Add an IP address to a pool (POST /ips/pools/{pool_name}/ips)](addtopool.java)
* [Remove an IP address from a pool (DELETE /ips/pools/{pool_name}/ips/{ip}](removefrompool.java)
* [Add an IP to warmup (POST /ips/warmup)](addtowarmup.java)
* [Retrieve all IPs currently in warmup (GET /ips/warmup)](retrieveipsinwarmup.java)
* [Retrieve warmup status for a specific IP address (GET /ips/warmup/{ip_address})](retrievewarmupstatus.java)
* [Remove an IP from warmup (DELETE /ips/warmup/{ip_address})](removefromwarmup.java)
* [Retrieve all IP pools an IP address belongs to (GET /ips/{ip_address})](retrievepoolsforip.java)