package com.sendgrid.typechecker;

import com.sun.istack.internal.NotNull;

public class TypeCheckException extends Exception {
    public TypeCheckException(@NotNull String message) {
        super(message);
    }
}
