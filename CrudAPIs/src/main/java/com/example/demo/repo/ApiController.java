package com.example.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;


@RestController
public class ApiController {
	
	@Autowired
	private UserRepo userRepo;

	
	@GetMapping("/userList")
	public java.util.List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public int getById(@PathVariable int id) {
		User q=userRepo.findById(id).get();
		userRepo.findById(id);
		return id;
		
	}
	
	//to insert the data into table
	@PostMapping(value = "/insert")
	   public String saveUser (@RequestBody User user) {
		 userRepo.save(user);
		  return "Data Inserted ";
	}
	
	
	//update all columns
	@PutMapping(value = "/updateAll/{id}")
	public String updateuser(@PathVariable int id,@RequestBody User user) {
		User updatedUsers = userRepo.findById(id).get();
		updatedUsers.setMail(user.getMail());
		updatedUsers.setName(user.getName());
		userRepo.save(updatedUsers);
		return"updated all user details";
		
	}
	
	//update Email
	@PutMapping(value = "/updateMail/{id}")
	public String updateUser(@PathVariable int id , @RequestBody User user) {
		User updatedUser = userRepo.findById(id).get();
		updatedUser.setMail(user.getMail());
		userRepo.save(updatedUser);
		return "email updated";
	}
	
	//update name
	@PutMapping(value = "/updateName/{id}")
	public String updateUsername(@PathVariable int id, @RequestBody User user) {
		User updateUsername = userRepo.findById(id).get();
		updateUsername.setName(user.getName());
		userRepo.save(updateUsername);
		return "userName Updated";
		
	}
	//update Phone Number
	@PutMapping(value="/updatePhone/{id}")
	public String updatePhone(@PathVariable int id, @RequestBody User user) {
	User updatePhone = userRepo.findById(id).get();
	updatePhone.setPhone(user.getPhone());
	userRepo.save(updatePhone);
	return"Phone Updated";
	}
	//Delete Employee
	@DeleteMapping(value="/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		User x=userRepo.findById(id).get();
		userRepo.delete(x);
		return "Employee Deleted";
	}
}
