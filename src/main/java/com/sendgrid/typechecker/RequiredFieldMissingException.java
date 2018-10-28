package com.sendgrid.typechecker;

import com.sun.istack.internal.NotNull;

class RequiredFieldMissingException extends TypeCheckException {
  RequiredFieldMissingException(@NotNull String msg) {
    super(msg);
  }
}
