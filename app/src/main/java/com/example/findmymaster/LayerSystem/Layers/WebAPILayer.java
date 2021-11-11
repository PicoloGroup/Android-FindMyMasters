package com.example.findmymaster.LayerSystem.Layers;

import com.example.findmymaster.AppDomain.AppDomain;
import com.example.findmymaster.AppDomain.WebAPIHandler;
import com.example.findmymaster.EventSystem.EventBase;
import com.example.findmymaster.EventSystem.Events.LoginEvent;
import com.example.findmymaster.LayerSystem.LayerBase;

public class WebAPILayer implements LayerBase {

    private AppDomain appDomain;
    private WebAPIHandler webAPIHandler;

    public WebAPILayer(WebAPIHandler webAPIHandler)

    {
        appDomain = AppDomain.getInstance();
        this.webAPIHandler = webAPIHandler;
    }

    @Override
    public void processEvent(EventBase event) {
        if(event.getEventType() == EventBase.EventType.LOGIN_EVENT)
        {
          processLoginEvent((LoginEvent) event);
          event.handle();
        }
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDetach() {

    }

    private void processLoginEvent(LoginEvent loginEvent)
    {
        //WebserviceHandler.login(loginEvent.getUserName(), loginEvent.getPassword());
    }



}
