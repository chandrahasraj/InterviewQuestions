package com.viewlift.locks;

/**
 * 
 * @author Chandrahas Raj
 *
 *
 *This program should perform a basic read write lock mechanism. 
 *Consider there is a resource which can be read by any thread any number of times
 *But if the resource is blocked for writing all the threads which want to read or write have to wait
 *every time a lockread is granted increase the count of readers and every time a lockwrite is granted increase writers
 *reduce the reader and writers count on unlock. Increase the writerequests count if the resource is blocked for writing
 */
public class ReadWriteLock {

	private static int readers = 0;
	private static int writers = 0;
	private static int writeRequests = 0;

	
	public Runnable background_writer_lock_thread = new Runnable() {
		public void run() {
			try {
				lockWrite();
				Thread.sleep(1000);
				unlockWrite();
			} catch (InterruptedException e) {
			}
		}
	};

	public Runnable background_reader_lock_thread = new Runnable() {
		public void run() {
			try {
				lockRead();
				Thread.sleep(1000);
				unlockRead();
			} catch (InterruptedException e) {
			}
		}
	};


	/**
	 * locks thread for reading
	 * @throws InterruptedException
	 */
	public synchronized void lockRead() throws InterruptedException {
	}

	/**
	 * unblocks any blocked thread
	 */
	public synchronized void unlockRead() {
	}

	/**
	 * locks thread for writing
	 * @throws InterruptedException
	 */
	public synchronized void lockWrite() throws InterruptedException {
	}

	/**
	 * unlocks blocked waiting thread for writing
	 * @throws InterruptedException
	 */
	public synchronized void unlockWrite() throws InterruptedException {
	}

	public static int getReaders() {
		return readers;
	}

	public static int getWriters() {
		return writers;
	}

	public static int getWriteRequests() {
		return writeRequests;
	}

	public static void setReaders(int readers) {
		ReadWriteLock.readers = readers;
	}

	public static void setWriters(int writers) {
		ReadWriteLock.writers = writers;
	}

	public static void setWriteRequests(int writeRequests) {
		ReadWriteLock.writeRequests = writeRequests;
	}

	public ReadWriteLock() {
	}
}
