package com.example.findmymaster.AppDomain;

import com.androidnetworking.error.ANError;

public class Error {
    private int errorCode;

    public Error(int errorCode)
    {
        this.errorCode = errorCode;
    }

    public int getErrorCode()
    {
        return errorCode;
    }
}
