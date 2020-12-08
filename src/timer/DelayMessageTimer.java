package timer;

import java.util.*;

/**
 * @author zhangyong created on 2020/4/30
 * 高效延时消息
 **/
public class DelayMessageTimer {

    private static final Set<Task>[] taskSetArr = new HashSet[3600];
    private static final Timer timer = new Timer();
    private static int currentSlot = 0;

    static {
        for (int i = 0, len = taskSetArr.length; i < len; i++) {
            taskSetArr[i] = new HashSet<>();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                executeTask();
            }
        }, 1000,1000);
    }

    public static void addTask(Operation operation, int delay) {
        Task task = new Task() {
            @Override
            void operation() {
                operation.action();
            }
        };
        int len = taskSetArr.length;
        task.cycleNum = delay / len;
        int slot = (currentSlot + delay) % len;
        taskSetArr[slot].add(task);
    }

    public static void executeTask() {
        Set<Task> taskSet = taskSetArr[currentSlot];
        Iterator<Task> taskIterator = taskSet.iterator();
        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();
            if (task.cycleNum <= 0) {
                new Thread(task::operation).start();
                taskIterator.remove();
            } else {
                task.cycleNum--;
            }
        }
        currentSlot = (currentSlot + 1) % taskSetArr.length;
    }

    static abstract class Task {
        int cycleNum = 0;
        abstract void operation();
    }

    interface Operation {
        void action();
    }

    public static void main(String[] args) {
        addTask(() -> System.out.println("after 10 seconds"), 10);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addTask(() -> System.out.println("after 20 seconds"), 10);
//        addTask(() -> System.out.println("after 3605 seconds"), 3605);
    }
}
