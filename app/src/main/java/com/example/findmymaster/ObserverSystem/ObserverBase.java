package com.example.findmymaster.ObserverSystem;

public interface ObserverBase {
    void update();

    void onAttach();
    void onDetach();
}
