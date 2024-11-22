package com.example.mobifog_polling;

public class TaskResponseBuilder {
    final String task_id;
    final String status;
    final String data;

    public TaskResponseBuilder(String task_id, String status, String data) {
        this.task_id = task_id;
        this.status = status;
        this.data = data;
    }
}
