package com.features;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

public class Http2 {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // Synchronous
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS).build();
        System.out.println(client.version());
        URI uri = new URI("http://www.oracle.com");
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .GET()
                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());
//        System.out.println(String.format("Status code: %d", response.statusCode()));
//        System.out.println(String.format("Body length: %d", response.body().length()));

        // Asynchronous
        HttpClient client1 = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS).build();
        URI uri1 = new URI("http://www.oracle.com");
        HttpRequest request1 = HttpRequest
                .newBuilder()
                .uri(uri)
                .GET()
                .build();
        CompletableFuture<HttpResponse<String>> response1 = client1.sendAsync(request1, HttpResponse.BodyHandler.asString());
        response1.whenComplete((HttpResponse<String> resp, Throwable exception) -> {
            if (exception == null) {
                System.out.println(String.format("Status code: %d", resp.statusCode()));
                System.out.println(String.format("Body length: %d", resp.body().length()));
            } else {
                System.out.println(String.format("Something went wrong. %s", exception.getMessage()));
            }
        });
        Thread.sleep(2000);
    }

}
