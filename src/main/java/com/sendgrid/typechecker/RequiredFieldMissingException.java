package com.sendgrid.typechecker;

class RequiredFieldMissingException extends TypeCheckException {
  RequiredFieldMissingException(String msg) {
    super(msg);
  }
}
