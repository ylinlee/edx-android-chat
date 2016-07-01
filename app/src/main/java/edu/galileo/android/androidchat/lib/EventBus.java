package edu.galileo.android.androidchat.lib;

/**
 * Created by kiryu on 1/07/16.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
