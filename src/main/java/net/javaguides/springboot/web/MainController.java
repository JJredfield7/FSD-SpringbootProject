package net.javaguides.springboot.web;

import net.javaguides.springboot.repository.ItemRepository;
import net.javaguides.springboot.repository.RestaurantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/menu")
	public ModelAndView getAllItems() {
		ModelAndView mav = new ModelAndView("menu");
		mav.addObject("items", itemRepository.findAll());
		return mav;
	}

<<<<<<< HEAD
	@GetMapping("/CartOrder")
	public ModelAndView getUserOrder(){
		ModelAndView mav = new ModelAndView("cartOrder");
		mav.addObject("orders",getUserOrder());
=======
	@Autowired
	private RestaurantInfoRepository restoRepository;

	@GetMapping({"/contactUs"})
	public ModelAndView getAllRestaurants() {
		ModelAndView mav = new ModelAndView("contactUs");
		mav.addObject("restaurants", restoRepository.findAll());
>>>>>>> 05525a59ad8149b07f2bcdc025700f244dda527a
		return mav;
	}
}
