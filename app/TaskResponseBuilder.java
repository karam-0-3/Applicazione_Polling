public class TaskResponseBuilder {
    private String task_id;
    private String status;
    private String data;

    public TaskResponseBuilder(String task_id, String status, String data) {
        this.task_id = task_id;
        this.status = status;
        this.data = data;
    }
}
