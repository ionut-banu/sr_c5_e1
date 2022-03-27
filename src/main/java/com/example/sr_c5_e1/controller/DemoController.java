package com.example.sr_c5_e1.controller;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.UUID;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

@RestController
public class DemoController {

    @GetMapping
    public void demo() {
        // Stream API vs Reactor

        //        Flux<Integer> f1 = Flux.just(1, 2, 3, 4, 5, 6); // publisher
        //
        //        f1.subscribe(c -> System.out.println(c)); // subscriber

        //        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6);
        //        s1.forEach(c -> System.out.println(c)); // subscriber pulls values

        //        var f1 = new DemoPublisher(List.of(1, 2, 3, 4, 5, 6)); //custom publisher
        //
        //        //subscriber requests values
        //        //publisher provides (pushes) the requested events
        //
        //        f1.subscribe(new DemoSubscriber()); // custom subscriber

        Flux<String> f1 = Flux.create(s -> {
            for (int i = 0; i < 10; i++) {
                s.next(UUID.randomUUID().toString());
            }
            s.complete();
        }); // publisher

        //        f1.log()
        //          .subscribe(c -> System.out.println(c)); // subscriber

//        f1.log().subscribe(new Subscriber<String>() {
//
//            private Subscription subscription;
//            private int i = 0;
//
//            @Override
//            public void onSubscribe(Subscription subscription) {
//                this.subscription = subscription;
//                this.subscription.request(2);
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println(s);
//                i++;
//                if (i % 2 == 0) {
//                    this.subscription.request(2);
//                }
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

//        f1.subscribe(c -> System.out.println(c));
//        f1.subscribe(c -> System.out.println(c));
//        f1.subscribe(c -> System.out.println(c));

        Stream<Integer> s = Stream.of(1,2,3,4,5);
        s.forEach(c-> System.out.println(c));
        s.forEach(c-> System.out.println(c)); //throws exception

    }
}
