package com.sambaash.platform.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * For use in submitting short live tasks only.
 * DO NOT USE for long-running tasks.
 * Use for tasks like for submitting asyncrhonous API request (Submit and Forget).
 */
@SuppressWarnings("rawtypes")
public final class ShortLiveTaskExecutor {
	private static ShortLiveTaskExecutor instance;
	private ExecutorService executor;
	
	private ShortLiveTaskExecutor() {
		executor = Executors.newCachedThreadPool();
	}
	
	public static ShortLiveTaskExecutor getInstance() {
		if (instance==null) {
			instance = new ShortLiveTaskExecutor();
		}
		return instance;
	}
	
	public Future submit(Runnable task) {
		return executor.submit(task);
	}
	
	@SuppressWarnings("unchecked")
	public Future submit(Callable task) {
		return executor.submit(task);
	}
	
}
