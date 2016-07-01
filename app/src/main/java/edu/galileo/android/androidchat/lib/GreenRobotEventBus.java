package edu.galileo.android.androidchat.lib;

/**
 * Created by kiryu on 1/07/16.
 */
public class GreenRobotEventBus implements EventBus {
    de.greenrobot.event.EventBus eventBus;

    private static class SinglenHolder {
        private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
    }

    private static GreenRobotEventBus getInstance() {
        return SinglenHolder.INSTANCE;
    }

    public GreenRobotEventBus() {
        this.eventBus = de.greenrobot.event.EventBus.getDefault();
    }
    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override 
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
