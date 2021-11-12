package com.example.findmymaster.AppDomain.FastNetworkRequestHandler;
import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.findmymaster.AppDomain.AppDomain;
import com.example.findmymaster.AppDomain.WebAPIHandler;

import org.json.JSONObject;

/*
A network request handler implemented with fast networking library for java.
*/

public class FastNetworkRequestHandler extends WebAPIHandler {


    public FastNetworkRequestHandler(String baseURL, Context context)
    {
        super(baseURL);

        AndroidNetworking.initialize(context);
    }

    @Override
    public void postLoginRequest(String email, String password) {
        AndroidNetworking
                .post(super.baseURL + "auth/student/login/")
                .addBodyParameter("email", email)
                .addBodyParameter("password", password)
                .setTag("request")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        AppDomain.getInstance().handleLoginResult(true);
                    }
                    @Override
                    public void onError(ANError error) {
                        AppDomain.getInstance().handleLoginResult(false);
                    }
                });
    }

    @Override
    public void postSignUpRequest(String email, String password) {

        AndroidNetworking
                .post(super.baseURL + "auth/student/signup/")
                .addBodyParameter("email", email)
                .addBodyParameter("password", password)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        AppDomain.getInstance().handleRegisterResult(true);
                        System.out.println(response.toString());
                    }
                    @Override
                    public void onError(ANError error) {
                        System.out.println(error.toString());
                        AppDomain.getInstance().handleRegisterResult(false);
                    }
                });
    }
}
