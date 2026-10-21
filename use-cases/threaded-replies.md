# Threaded Replies

This example goes over how to send a reply that stays in the same email thread as an earlier message. You can find documentation for the Event Webhook [here](https://sendgrid.com/docs/API_Reference/Webhooks/event.html), for the Webhooks API [here](https://www.twilio.com/docs/sendgrid/api-reference/webhooks), and for Mail Send [here](https://docs.sendgrid.com/api-reference/mail-send/mail-send).

A reply sent without threading headers shows up in Gmail as a new conversation. For example, a follow-up to an order confirmation lands as a separate message instead of under the original. Setting `In-Reply-To` and `References` to the original email's `smtp-id` keeps the reply in the same thread in Gmail, Outlook, and Apple Mail.

A complete two-step version is in [ThreadingExample.java](../examples/mail/ThreadingExample.java).

## Which ID to use

**Short answer:** reply with the `smtp-id` from the `delivered` webhook event.
The `X-Message-Id` from the send response is not the value that threads a
reply.

Mail clients group messages by the RFC 5322 `Message-ID` header. The webhook's
`smtp-id` is that `Message-ID`, so it's the value to use.

The reply's subject should be the original subject with `Re: ` in front. Gmail uses the subject as a second signal when grouping, so a mismatched subject is more likely to start a new conversation.

## Sequence

```
your app                       SendGrid                    webhook endpoint
   |  POST /mail/send            |                              |
   |---------------------------->|                              |
   |  response: X-Message-Id     |                              |
   |<----------------------------|                              |
   |  store X-Message-Id         |                              |
   |                             |  delivered (smtp-id)         |
   |                             |----------------------------->|
   |                             |                              |  match on sg_message_id,
   |                             |                              |  store smtp-id
   |  POST /mail/send            |                              |
   |  In-Reply-To: smtp-id       |                              |
   |---------------------------->|                              |
```

## Matching a webhook event to a send

`sg_message_id` in an event is the response's `X-Message-Id` followed by a
suffix. To match, take the part before the first `.` and compare it with the
stored `X-Message-Id`:

```
sg_message_id: abc123XYZ.recvd-example-1-0
               └──────┘
                 match against stored X-Message-Id: abc123XYZ
```

When it matches, save the event's `smtp-id` on the stored record. This rule is
based on one sample, so confirm it on several real sends before you depend on
it.

Example `delivered` event (trimmed):

```json
{
  "email": "recipient@example.com",
  "event": "delivered",
  "sg_event_id": "ZXhhbXBsZS1ldmVudC1pZA",
  "sg_message_id": "abc123XYZ.recvd-example-1-0",
  "smtp-id": "<abc123XYZ@example-ismtpd-10>",
  "timestamp": 1700000000
}
```

The `processed` event carries the same `smtp-id`, so it also works if you need
the ID before delivery.

## Troubleshooting

- **The reply starts a new thread.** Check which value you sent. The
  `X-Message-Id` will not thread. Send the `smtp-id`, and keep its angle
  brackets.
- **The reply is in a separate conversation.** Check that the subject is the original subject with `Re: ` in front, as well as the `smtp-id`.
- **There is no `smtp-id` yet.** The reply has to wait for the `delivered` or
  `processed` event. Don't send it from the API response alone.
- **No event matches the stored ID.** Compare the part of `sg_message_id` before
  the first `.` with the stored `X-Message-Id`, character for character.
- **The same event arrives twice.** Webhooks can repeat, so make the save
  idempotent: writing the same `smtp-id` twice should change nothing.

## Verify the thread in Gmail

Check the headers after the reply arrives. This shows whether the reply carries the right values.

1. Open the original email in Gmail and confirm the reply appears under it, in the same conversation.
2. On the reply, click the three-dot **More** menu next to the reply button, then choose **Show original**.
3. In the raw headers, find these lines:
   - `Message-ID:` on the original email. It should match the `smtp-id` from the `delivered` event, including the angle brackets.
   - `In-Reply-To:` on the reply. It should contain the same `smtp-id`.
   - `References:` on the reply. It should contain the same `smtp-id`.
4. If the reply shows in a separate conversation, compare its `In-Reply-To` and `References` values with the original's `Message-ID`. A mismatch means the reply was sent with the wrong ID.

## Viewing SendGrid deliverability webhook events

The Event Webhook needs a public URL to post to. For a first test, use a temporary endpoint:

1. Open [webhook.site](https://webhook.site) and copy the unique URL it gives you.
2. In the SendGrid dashboard, open the Event Webhook settings, paste the URL, and enable the `delivered` and `processed` events.
3. Run `ThreadingExample` to send the first email. Refresh webhook.site and look for the `delivered` event, then check its `sg_message_id` and `smtp-id`.

Other tools that work the same way include [Beeceptor](https://beeceptor.com), which can also mock responses, and the [Svix webhook testing guide](https://www.svix.com/resources/faq/best-webhook-testing-inspecting-and-debugging-tools-2026/), which compares several options.

Temporary endpoints are public, so anyone with the URL can read what is posted to it. Don't send real customer data through one.
