package com.ToDo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ToDo.Service.To_DoService;
import com.ToDo.entity.To_Do;

@Controller
public class To_Do_Controller {
	@Autowired
	private To_DoService service;
	@GetMapping("/")
	public String viewAllItems(Model model) {
		model.addAttribute("list",service.getAllToDoItems());
		return "ViewToDoList";
	}
	@PostMapping("/updateStatus/{Id}")
	public String updateToDoStatus(@PathVariable Long Id,RedirectAttributes redirect) {
		if(service.updateStatus(Id)) {
			redirect.addFlashAttribute("Message:","Status Updated Successfully");
			return"redirect:/viewToDoList";
		}
		redirect.addFlashAttribute("Message:"," Status Updated Failed");
		return("redirect:/viewToDoList");
	}
	@GetMapping("/addToDo")
		public String addToItem() {
			return "AddToDoItem";
		
	}
	@PostMapping("/saveToDoItem")
	public String saveToDoItem(To_Do todo,RedirectAttributes redirect) {
		if(service.saveorUpdateItem(todo)) {
			redirect.addFlashAttribute("Message:","Saved SuccessFully");
			return"redirect:/ViewToDoList";
		}
		return"redirect:/addToDoItem";
	}
	@GetMapping("/editToDo/{Id}")
	public String editToDoItem(@PathVariable Long Id,Model model) {
		model.addAttribute("todo",service.getItemById(Id));
		return"EditToDoItem";
	}
	@PostMapping("editSaveToDoItem")
	public String editSaveToDoItem(To_Do todo, RedirectAttributes redirect) {
		if(service.saveorUpdateItem(todo)) {
			redirect.addFlashAttribute("Message:","Status Updated Successfully");
			return"redirect:/viewToDoList";
		}
		redirect.addFlashAttribute("Message:"," Status Updated Failed");
		return("redirect:/editToDoItem"+todo.getId());
	}
	@GetMapping("/deleteToDoItem")
	public String deleToDoItem(@PathVariable Long Id,RedirectAttributes redirect) {
		if(service.deleteToDoById(Id)) {
			redirect.addFlashAttribute("Message:","Delete SuccessFul");
		}
		redirect.addFlashAttribute("Message:","Delete Failed");
		return("redirect:/viewToDoList");
	}
	}
	
	
	


