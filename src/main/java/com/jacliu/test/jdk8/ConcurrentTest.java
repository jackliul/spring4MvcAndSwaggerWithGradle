package com.jacliu.test.jdk8;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConcurrentTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
			return "nihao";
		}).thenApplyAsync(s -> {
			return s + " aaa";
		}).
				thenApplyAsync(s -> {
					System.out.println(s);
					return s + " bbb";
				});

		String join = stringCompletableFuture.join();
		System.out.println(join);
	}
}
