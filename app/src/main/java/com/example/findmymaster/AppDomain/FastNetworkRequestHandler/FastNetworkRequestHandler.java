package com.example.findmymaster.AppDomain.FastNetworkRequestHandler;
import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.gsonparserfactory.GsonParserFactory;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.findmymaster.AppDomain.APIClasses.Token;
import com.example.findmymaster.AppDomain.AppDomain;
import com.example.findmymaster.AppDomain.Error;
import com.example.findmymaster.AppDomain.WebAPIHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*
A network request handler implemented with fast networking library for java.
*/

public class FastNetworkRequestHandler extends WebAPIHandler {
    Token token;
    Gson gson;

    public FastNetworkRequestHandler(String baseURL, Context context)
    {
        super(baseURL);
        token = null;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();

        AndroidNetworking.initialize(context);
    }
    
    public String encodeString(String str)
    {
        String result = null;

        try {
            result = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        return result;
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
                        token = gson.fromJson(response.toString(), Token.class);

                        AppDomain.getInstance().handleLoginResult(null);

                    }
                    @Override
                    public void onError(ANError error) {
                        AppDomain.getInstance().handleLoginResult(new Error(error.getErrorCode()));
                    }
                });
    }

    @Override
    public void postSignUpRequest(String email, String password) {
        AndroidNetworking
                .post(super.baseURL + "auth/student/signup/")
                .addBodyParameter("email", email)
                .addBodyParameter("password",  password)

                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        AppDomain.getInstance().handleRegisterResult(null);
                        System.out.println(response.toString());
                    }
                    @Override
                    public void onError(ANError error) {
                        System.out.println(error);
                        AppDomain.getInstance().handleRegisterResult(new Error(error.getErrorCode()));

                    }
                });
    }
}
