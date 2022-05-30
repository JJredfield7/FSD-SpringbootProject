package net.javaguides.springboot.web;

import net.javaguides.springboot.repository.ItemRepository;
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

	@GetMapping("/CartOrder")
	public ModelAndView getUserOrder(){
		ModelAndView mav = new ModelAndView("cartOrder");
		mav.addObject("orders",getUserOrder());
		return mav;
	}
}
