package com.viewlift;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.viewlift.locks.ReadWriteLock;

public class BasicReadWriteLockTest {

	ReadWriteLock lock = new ReadWriteLock();

	static ExecutorService service;
	boolean threadsDead = false;

	
	@After
	public void resetReadWriteLockParameters(){
		ReadWriteLock.setReaders(0);
		ReadWriteLock.setWriteRequests(0);
		ReadWriteLock.setWriters(0);
	}

	@Test
	public void testReadLock() throws InterruptedException {
		service = Executors.newCachedThreadPool();

		service.execute(lock.background_reader_lock_thread);
		service.execute(lock.background_reader_lock_thread);
		service.execute(lock.background_reader_lock_thread);

		
		service.shutdownNow();
		while (!service.isTerminated())
			;

		Assert.assertEquals(3, ReadWriteLock.getReaders());
	}
	
	@Test
	public void testReadWrite() throws InterruptedException {
		service = Executors.newCachedThreadPool();

		service.execute(lock.background_reader_lock_thread);
		service.execute(lock.background_writer_lock_thread);
		service.execute(lock.background_reader_lock_thread);

		service.shutdownNow();
		while (!service.isTerminated())
			;
		Assert.assertEquals(1, ReadWriteLock.getWriteRequests());
		Assert.assertEquals(0, ReadWriteLock.getWriters());
		Assert.assertEquals(1, ReadWriteLock.getReaders());
	}

	@Test
	public void testWriteLock() throws InterruptedException {
		service = Executors.newCachedThreadPool();

		service.execute(lock.background_writer_lock_thread);
		service.execute(lock.background_writer_lock_thread);
		service.execute(lock.background_writer_lock_thread);

		service.shutdownNow();
		while (!service.isTerminated())
			;

		Assert.assertEquals(2, ReadWriteLock.getWriteRequests());
		Assert.assertEquals(1, ReadWriteLock.getWriters());
	}

}
