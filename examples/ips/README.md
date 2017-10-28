![SendGrid Logo](https://uiux.s3.amazonaws.com/2016-logos/email-logo%402x.png)

This folder contains various examples on using the IPs endpoint of SendGrid with Java:

* [Retrieve all IP addresses (GET /ips)](RetrieveAllIPs.java)
* [Retrieve all assigned IPs (GET /ips/assigned)](RetrieveAssignedIPs.java)
* [Create an IP pool (POST /ips/pools)](CreatePool.java)
* [Retrieve all IP pools (GET /ips/pools)](RetrieveAllPools.java)
* [Update an IP pools name (PUT /ips/pools/{pool_name})](UpdatePoolName.java)
* [Retrieve all IPs in a specified pool (GET /ips/pools/{pool_name})](RetrieveIPsInPool.java)
* [Delete an IP pool. (DELETE /ips/pools/{pool_name})](DeletePool.java)
* [Add an IP address to a pool (POST /ips/pools/{pool_name}/ips)](AddToPool.java)
* [Remove an IP address from a pool (DELETE /ips/pools/{pool_name}/ips/{ip}](RemoveFromPool.java)
* [Add an IP to warmup (POST /ips/warmup)](AddToWarmup.java)
* [Retrieve all IPs currently in warmup (GET /ips/warmup)](RetrieveIPsInWarmup.java)
* [Retrieve warmup status for a specific IP address (GET /ips/warmup/{ip_address})](RetrieveWarmupStatus.java)
* [Remove an IP from warmup (DELETE /ips/warmup/{ip_address})](RemoveFromWarmup.java)
* [Retrieve all IP pools an IP address belongs to (GET /ips/{ip_address})](RetrievePoolsForIP.java)