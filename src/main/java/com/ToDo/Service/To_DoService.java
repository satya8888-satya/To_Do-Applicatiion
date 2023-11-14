package com.ToDo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDo.Repo.Repository;
import com.ToDo.entity.To_Do;

@Service
public class To_DoService {
	@Autowired
	Repository repo;
	public List<To_Do> getAllToDoItems(){
		ArrayList<To_Do> al = new ArrayList<>();
		repo.findAll().forEach(todo-> al.add(todo));
		return al;
		
	}
	public To_Do getItemById(Long Id) {
		return repo.findById(Id).get();
	}
	public boolean updateStatus(Long Id) {
		To_Do todo=getItemById(Id);
		todo.setStatus("Completed");
		return saveorUpdateItem(todo);
		
	}
	public boolean saveorUpdateItem(To_Do todo) {
		To_Do object = repo.save(todo);
		if(getItemById(object.getId())!=null){
			return true;
		}
		return false;
	}
	public boolean deleteToDoById(Long Id) {
		repo.deleteById(Id);
		if(getItemById(Id)==null) {
			return true;
		}
		return false;
		
	}
}
	
	


