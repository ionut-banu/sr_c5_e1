package com.example.sr_c5_e1.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class DemoPublisher implements Publisher<Integer> {

    private final List<Integer> list;

    public DemoPublisher(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        var subscription = new Subscription() {

            private int lastRequestedElement = -1;

            @Override
            public void request(long n) {
                lastRequestedElement++;
                if (lastRequestedElement < list.size()) {
                    subscriber.onNext(list.get(lastRequestedElement));
                } else {
                    subscriber.onComplete();
                }
            }

            @Override
            public void cancel() {

            }
        };
        subscriber.onSubscribe(subscription);
    }
}
