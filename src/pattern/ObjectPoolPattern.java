package pattern;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

abstract class ObjectPool<T> {
    private ConcurrentLinkedQueue<T> pool;
    private ScheduledExecutorService executorService;
    public ObjectPool(final int minObjects) {
        initialize(minObjects);
    }

    public ObjectPool(final int minObjects, final int maxObjects, final long validationInterval){
        initialize(minObjects);
        // check pool conditions in a separate thread
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(() ->  {
            int size = pool.size();

            if (size < minObjects) {
                int sizeToBeAdded = minObjects - size;
                for (int i = 0; i < sizeToBeAdded; i++) {
                    pool.add(createObject());
                }
            } else if (size > maxObjects) {
                int sizeToBeRemoved = size - maxObjects;
                for (int i = 0; i < sizeToBeRemoved; i++) {
                    pool.poll();
                }
            }
        }, validationInterval, validationInterval, TimeUnit.SECONDS);
    }

    public T borrowObject() {
        T object;
        if ((object = pool.poll()) == null)
        {
            object = createObject();
        }
        return object;
    }
    /*
         Returns object back to the pool.
         @param object object to be returned
     */
    public void returnObject(T object) {
        if (object == null) {
            return;
        }
        this.pool.offer(object);
    }
    /*
         Shutdown this pool.
     */
    public void shutdown(){
        if (executorService != null){
            executorService.shutdown();
        }
    }

    protected abstract T createObject();

    private void initialize(final int minObjects)  {
        pool = new ConcurrentLinkedQueue<T>();
        for (int i = 0; i < minObjects; i++) {
            pool.add(createObject());
        }
    }
}

class ExportingProcess {
    private long processNo;

    public ExportingProcess(long processNo)  {
        this.processNo = processNo;
        // do some  expensive calls / tasks here in future
        // .........
        System.out.println("Object with process no. " + processNo + " was created");
    }

    public long getProcessNo() {
        return processNo;
    }
}

class ExportingTask implements Runnable {
    private ObjectPool<ExportingProcess> pool;
    private int threadNo;
    public ExportingTask(ObjectPool<ExportingProcess> pool, int threadNo){
        this.pool = pool;
        this.threadNo = threadNo;
    }

    public void run() {
        // get an object from the pool
        ExportingProcess exportingProcess = pool.borrowObject();
        System.out.println("Thread " + threadNo + ": Object with process no. "
                + exportingProcess.getProcessNo() + " was borrowed");

        //you can  do something here in future
        // .........

        // return ExportingProcess instance back to the pool
        pool.returnObject(exportingProcess);

        System.out.println("Thread " + threadNo +": Object with process no. "
                + exportingProcess.getProcessNo() + " was returned");
    }

}

public class ObjectPoolPattern {
    private ObjectPool<ExportingProcess> pool;
    private AtomicLong processNo=new AtomicLong(0);
    public void setUp() {
        // Create a pool of objects of type ExportingProcess.
           /*Parameters:
             1) Minimum number of special ExportingProcess instances residing in the pool = 4
             2) Maximum number of special ExportingProcess instances residing in the pool = 10
             3) Time in seconds for periodical checking of minObjects / maxObjects conditions
                in a separate thread = 5.
             -->When the number of ExportingProcess instances is less than minObjects,
                 missing instances will be created.
             -->When the number of ExportingProcess instances is greater than maxObjects,
                  too many instances will be removed.
            -->If the validation interval is negative, no periodical checking of
                  minObjects / maxObjects conditions in a separate thread take place.
              These boundaries are ignored then.
           */
        pool = new ObjectPool<ExportingProcess>(4, 10, 5)
        {
            protected ExportingProcess createObject()
            {
                // create a test object which takes some time for creation
                return new ExportingProcess( processNo.incrementAndGet());
            }
        };
    }
    public void tearDown() {
        pool.shutdown();
    }
    public void testObjectPool() {
        ExecutorService executor = Executors.newFixedThreadPool(8);

        // execute 8 tasks in separate threads

        executor.execute(new ExportingTask(pool, 1));
        executor.execute(new ExportingTask(pool, 2));
        executor.execute(new ExportingTask(pool, 3));
        executor.execute(new ExportingTask(pool, 4));
        executor.execute(new ExportingTask(pool, 5));
        executor.execute(new ExportingTask(pool, 6));
        executor.execute(new ExportingTask(pool, 7));
        executor.execute(new ExportingTask(pool, 8));

        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e)

        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])  {
        ObjectPoolPattern op=new ObjectPoolPattern();
        op.setUp();
        op.tearDown();
        op.testObjectPool();
    }
}
