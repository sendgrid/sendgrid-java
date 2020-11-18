package com.sendgrid.helpers.ips;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IPAddress {

    /**
     * An IP address.
     */
    @JsonProperty("ip")
    private String ip;

    /**
     * The subusers that are able to send email from this IP.
     */
    @JsonProperty("subusers")
    private List<String> subUsers;

    /**
     * The reverse DNS record for this IP address.
     */
    @JsonProperty("rdns")
    private String rdns;

    /**
     * The IP pools that this IP has been added to.
     */
    @JsonProperty("pools")
    private List<String> pools;

    /**
     * Indicates if this IP address is currently warming up.
     */
    @JsonProperty("warmup")
    private boolean warmup;

    /**
     * The date that the IP address was entered into warmup.
     */
    @JsonProperty("start_date")
    private long startDate;

    /**
     * Indicates if this IP address has been whitelabeled.
     */
    @JsonProperty("whitelabeled")
    private boolean whitelabeled;

    /**
     * The date that the IP address was assigned to the user.
     */
    @JsonProperty("assigned_at")
    private long assignedAt;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<String> getSubUsers() {
        return subUsers;
    }

    public void setSubUsers(List<String> subUsers) {
        this.subUsers = subUsers;
    }

    public String getRdns() {
        return rdns;
    }

    public void setRdns(String rdns) {
        this.rdns = rdns;
    }

    public List<String> getPools() {
        return pools;
    }

    public void setPools(List<String> pools) {
        this.pools = pools;
    }

    public boolean isWarmup() {
        return warmup;
    }

    public void setWarmup(boolean warmup) {
        this.warmup = warmup;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public boolean isWhitelabeled() {
        return whitelabeled;
    }

    public void setWhitelabeled(boolean whitelabeled) {
        this.whitelabeled = whitelabeled;
    }

    public long getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(long assignedAt) {
        this.assignedAt = assignedAt;
    }
}
