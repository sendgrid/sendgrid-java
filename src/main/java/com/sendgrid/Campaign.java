package com.sendgrid;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * A class allowing multiple emails to be sent simultaneously.
 */
public class Campaign {
    private final List<Mail> mail = new ArrayList<>();

    /**
     * Get the mail objcts in this campaign.
     * @return the list of mail objects.
     */
    public List<Mail> getMail() {
        return this.mail;
    }

    /**
     * Add a mail object to this campaign.
     * @param mail a mail to add to the campaign.
     * @return this campaign.
     */
    public Campaign mail(Mail mail) {
        this.mail.add(mail);
        return this;
    }

    /**
     * Send all the email in this campaign.
     * @param sg a Sendgrid object.
     * @return the list of responses from sending the mail.
     * @throws IOException in the event of a network error. Note that
     * if any messages throws an error, the remaining members of the
     * campaign will not be sent.
     */
    public List<Response> send(SendGrid sg) throws IOException {
        List<Response> ret = new ArrayList<>();
        for(Mail m: this.mail) {
            ret.add(m.send(sg));
        }
        return ret;
    }
}
