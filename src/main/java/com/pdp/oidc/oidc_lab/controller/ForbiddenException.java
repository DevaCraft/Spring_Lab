package com.pdp.oidc.oidc_lab.controller;

public class ForbiddenException extends Throwable {
    private String message;
    public ForbiddenException(String s) {
        super(s);
        this.message=s;

    }
}
