package concurrent.liveness;

/**
 * @author zhangyong created on 2019/9/27
 **/
public class LiveLock {
    /**
     * Starvation describes a situation where a thread is unable to gain regular access to shared resources and is unable to make progress.
     * This happens when shared resources are made unavailable for long periods by "greedy" threads.
     * For example, suppose an object provides a synchronized method that often takes a long time to return.
     * If one thread invokes this method frequently,
     * other threads that also need frequent synchronized access to the same object will often be blocked.
     */
}
