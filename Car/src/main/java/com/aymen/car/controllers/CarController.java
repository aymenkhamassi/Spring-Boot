package com.aymen.car.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.aymen.car.models.Car;
import com.aymen.car.models.User;
import com.aymen.car.services.CarService;
import com.aymen.car.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CarController {
	
	@Autowired
	private CarService carServ;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/home")
	public String home(@ModelAttribute("car")Car car, Model model,HttpSession session) {
		
		Long userID = (Long) session.getAttribute("user_id");
		if(userID== null) return "redirect:/";
		model.addAttribute("user", userServ.getUser(userID));
		
		List<Car> allDaCars = carServ.allCars();
		model.addAttribute("allCars",allDaCars);
		
		return "home.jsp";
	}
	
	@PostMapping("/cars")
	public String makeCars(@Valid @ModelAttribute("car") Car car, BindingResult result,HttpSession session,
			Model model) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		if(result.hasErrors()) {
			
			List<Car> allDaCars = carServ.allCars();
			model.addAttribute("allCars",allDaCars);
			
			return "home.jsp";
		}else {
			Long userID = (Long) session.getAttribute("user_id");
			User loggedInUser = userServ.getUser(userID);
			car.setDriver(loggedInUser);
			carServ.createCar(car);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/cars/{carID}/edit")
	public String updateForm(@ModelAttribute("car")Car car,@PathVariable("carID")Long carID,Model model){
		
		Car carToUpdate = carServ.findCar(carID);
		model.addAttribute("car", carToUpdate);
		return "edit.jsp";
	}
	
	@PutMapping("/cars/{id}/edit")
	public String processCar(@Valid @ModelAttribute("car") Car car, BindingResult result,HttpSession session,
			@PathVariable("id") Long carID) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		if(result.hasErrors()) {
			return "home.jsp";
		}else {
			Car oldCar = carServ.findCar(carID);
			car.setDriver(oldCar.getDriver());
			carServ.updateCar(car);
			return "redirect:/home";
		}
	}
	@DeleteMapping("/cars/{id}/delete")
	public String destroy(@PathVariable("id") Long carID) {
		carServ.deleteCar(carID);
		return "redirect:/home";
	}
	
	@GetMapping("/cars/{id}")
	public String showOne(@PathVariable("id") Long carID,Model model) {
		Car thisCar = carServ.findCar(carID);
		model.addAttribute("thisCar", thisCar);
		return "one.jsp";
	}

}
