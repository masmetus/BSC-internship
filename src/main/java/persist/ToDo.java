package persist;

import java.util.List;

public class ToDo {

    private Integer id;
    private String Task;
    private String Status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        this.Task = task;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ToDo task = (ToDo) obj;
        return id == task.id
                && (Task == task.Task
                || (Task != null && Task.equals(task.getTask())))
                && (Status == task.Status
                || (Status != null && Status.equals(task.getStatus())
        ));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Task == null) ? 0 : Task.hashCode());
        result = prime * result + id;
        result = prime * result + ((Status == null) ? 0 : Status.hashCode());
        return result;

    }

    @Override
    public String toString()
    {
        return  id +"." + " " + "["+ Status + "]" + " " +  Task + "\n";
    }
}


