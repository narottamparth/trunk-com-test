package com.task.todolist.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.RequestContext;

import com.task.todolist.model.TaskEntity;

@Service
public class TaskManager {
  
	//List<TaskEntity> listoftask=new ArrayList<TaskEntity>();
	Map<Long,TaskEntity> hm=new HashMap<Long, TaskEntity>();
	
	TaskManager(){
		
		/*listoftask.add(new TaskEntity(1L,"Start break",false));
		listoftask.add(new TaskEntity(1L,"Start break 2",false));*/
	}
	
/*	public List<TaskEntity> listResources(RequestContext requestContext)
            throws Exception {
            
		      return this.listoftask;
            
	}*/
	
	

	public TaskEntity save(TaskEntity taskentity) {
		// TODO Auto-generated method stub
		
		hm.put(taskentity.getTaskId(),taskentity);
		return taskentity;
	}



	public List<TaskEntity> findAll() {
		// TODO Auto-generated method stub
		
		List<TaskEntity> l = new ArrayList<TaskEntity>(); 
		
		for (Map.Entry<Long, TaskEntity> entry : hm.entrySet())
		{  
			l.add(entry.getValue()); 
	    }
		return l;
	}
	
	public TaskEntity find(long taskid) {
		// TODO Auto-generated method stub
		
		return hm.get(taskid);
	}



	public void delete(long taskid) {
		// TODO Auto-generated method stub
		hm.remove(taskid);
				
		
	}
	
	public boolean setComplete(long taskid){
		
		TaskEntity t=hm.get(taskid);
		t.setComplete(true);
		hm.put(taskid, t);
		return false;
		
		
	}

	
	
	
	
}
