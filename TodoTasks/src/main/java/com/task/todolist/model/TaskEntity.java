package com.task.todolist.model;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TaskEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	
	private String taskName;
	
	private boolean isComplete;
	
	public TaskEntity(){
		
	}

	public TaskEntity(Long taskId, String taskName, boolean isComplete) {
		
		this.taskId = taskId;
		this.taskName = taskName;
		this.isComplete = isComplete;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	@Override

	public String toString() {
		return "[ id=" + this.taskId + ", description=" + this.taskName + ", complete=" + this.isComplete + " ]";
    }

	@Override
	public boolean equals(Object other) {
        if(other instanceof TaskEntity)
		return this.getTaskId().equals(((TaskEntity)other).getTaskId());
        else
        	return false;

	}

	

	@Override
	public int hashCode() {
		 return Objects.hashCode(this.taskId)+Objects.hashCode(this.taskName);

	}

}
