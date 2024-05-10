package com.sendgrid.base;

import com.sendgrid.http.RestClient;

// This is used for operations which are not identified. Use dynamic file name while generating.
// Example: OperationId: CancelStudent, className: StudentCancel
public interface Sender<T> {
    T send();
    T send(final RestClient client);
}
