package timer;

public class timerDemo {
    public static void main(String[] args) {
        AuditTimerTask timerTask1 = new AuditTimerTask("审批任务1","1","1");
        AuditTimerTask timerTask2 = new AuditTimerTask("审批任务2","2","1");
        TimerUtil.schedule(timerTask1,3 * TimerUtil.second);
        TimerUtil.schedule(timerTask2,6 * TimerUtil.second);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuditTimerTask timerTask3 = new AuditTimerTask("审批任务3","3","2");
        AuditTimerTask timerTask4 = new AuditTimerTask("审批任务4","4","2");
        TimerUtil.schedule(timerTask3,6 * TimerUtil.second);
        TimerUtil.schedule(timerTask4,3 * TimerUtil.second);
        System.out.println("main thread is finished");
    }
}
