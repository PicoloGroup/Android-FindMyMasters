package com.example.findmymaster.AppDomain;

import android.content.Context;

public abstract class WebAPIHandler {

    protected String baseURL;

    protected WebAPIHandler(String baseURL)
    {
        this.baseURL = baseURL;
    }

    public abstract void postLoginRequest(String email, String passWord);

    public abstract void postSignUpRequest(String email, String password);
}