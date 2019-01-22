package timer;


public class AuditTimerTask extends TimerUtil.TimerTask {
    private String auditTaskName;
    private String auditTaskId;
    private String auditProcessId;

    public AuditTimerTask(String auditTaskName, String auditTaskId, String auditProcessId) {
        this.auditTaskName = auditTaskName;
        this.auditTaskId = auditTaskId;
        this.auditProcessId = auditProcessId;
    }

    public String getAuditTaskName() {
        return auditTaskName;
    }

    public void setAuditTaskName(String auditTaskName) {
        this.auditTaskName = auditTaskName;
    }

    public String getAuditTaskId() {
        return auditTaskId;
    }

    public void setAuditTaskId(String auditTaskId) {
        this.auditTaskId = auditTaskId;
    }

    public String getAuditProcessId() {
        return auditProcessId;
    }

    public void setAuditProcessId(String auditProcessId) {
        this.auditProcessId = auditProcessId;
    }

    @Override
    public void execute() {
        System.out.printf("Auto audit task %s start execute......%n",getAuditTaskName());
        System.out.printf("Thread name is : %s%n",Thread.currentThread().getName());
        System.out.printf("Doing auto audit task : auditTaskName is %s; auditTaskId is %s; auditProcessId is %s%n",
                getAuditTaskName(),getAuditTaskId(),getAuditProcessId());
        System.out.printf("Auto audit task %s finished%n",getAuditTaskName());
    }
}
