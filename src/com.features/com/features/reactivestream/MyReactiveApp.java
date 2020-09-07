package com.features.reactivestream;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class MyReactiveApp {

    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

        MySubscriber subs = new MySubscriber();
        publisher.subscribe(subs);

        List<Employee> emps = EmpHelper.getEmps();

        System.out.println("Publishing Items to Subscriber");
        emps.stream().forEach(i -> publisher.submit(i));

        while (emps.size() != subs.getCounter()) {
            Thread.sleep(10);
        }
        publisher.close();

        System.out.println("Exiting the app");
    }

}
