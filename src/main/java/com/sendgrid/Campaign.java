package com.sendgrid;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * A utility for conducting a campaign, allowing for
 * multiple emails to be sent simultaneously.
 */
public class Campaign {
    private final List<Mail> mail = new ArrayList<>();

    /**
     * Gets the emails of which should be sent.
     *
     * @return the list of mail models.
     */
    public List<Mail> getMail() {
        return this.mail;
    }

    /**
     * Adds an email to this campaign.
     *
     * @param mail a mail model
     * @return {@code this} for chaining.
     */
    public Campaign mail(Mail mail) {
        this.mail.add(mail);
        return this;
    }

    /**
     * Send all the emails in this campaign.
     *
     * @param sg the SendGrid wrapper.
     * @return the list of responses, having sent the emails.
     * @throws IOException in the event of a network error. Note that if
     *                     any messages throws an error, the remaining members
     *                     of the campaign will not be sent.
     */
    public List<Response> send(SendGrid sg) throws IOException {
        List<Response> ret = new ArrayList<>();
        for(Mail m: this.mail) {
            ret.add(m.send(sg));
        }
        return ret;
    }
}
