package com.task.todolist.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.task.todolist.manager.TaskManager;
import com.task.todolist.model.TaskEntity;

@Controller
@RequestMapping("/tasks")
public class TaskController {
      
	private TaskManager _taskmanager=null;
	
	 @Autowired
	    public void setTaskManager(TaskManager taskManager) {
		_taskmanager = taskManager;
	       
	    }
	 
	   @RequestMapping(method = RequestMethod.GET, value ="/all",
			 produces = "application/json")
        
		public ResponseEntity<Iterable<TaskEntity>> list() {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Accept-Patch", "application/json-patch+json");
			return new ResponseEntity<Iterable<TaskEntity>>(_taskmanager.findAll(), headers, HttpStatus.OK);

		}
	 
	    @RequestMapping(method = RequestMethod.POST, value ="/add")
		public TaskEntity create(@RequestBody TaskEntity taskentity) {
	    	System.out.println("In POST method");
			return _taskmanager.save(taskentity);
		}
	 
	    @RequestMapping(value = "/{taskid}", method = RequestMethod.PUT)
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void update(@RequestBody TaskEntity updateTask, @PathVariable("taskid") long taskid) throws IOException {

			if (taskid != updateTask.getTaskId()) {

				_taskmanager.delete(taskid);

			}

			_taskmanager.save(updateTask);

		}
	 
}
