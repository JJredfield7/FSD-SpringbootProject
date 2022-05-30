package net.javaguides.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.springboot.model.RestaurantInfo;
import net.javaguides.springboot.repository.ItemRepository;
import net.javaguides.springboot.repository.OrderDetailsRepository;
import net.javaguides.springboot.repository.RestaurantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

	final RestaurantInfoService restaurantInfoService;

	private final ObjectMapper mapper = new ObjectMapper();

	public MainController(RestaurantInfoService restaurantInfoService) {
		this.restaurantInfoService = restaurantInfoService;
	}
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

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@GetMapping("/menu")
	public ModelAndView getAllItems() {
		ModelAndView mav = new ModelAndView("menu");
		mav.addObject("items", itemRepository.findAll());
		return mav;
	}


	@GetMapping("/cart")
	public ModelAndView getUserOrder() {
		ModelAndView mav = new ModelAndView("cartOrder");
		mav.addObject("orders", orderDetailsRepository.findAll());
		return mav;
	}


	@GetMapping("/contactUs")
	public String contactUs(Model model) {
		List<RestaurantInfo> restaurantInfoList = this.restaurantInfoService.getAll();
		List<RestaurantInfoDto> result = (List) restaurantInfoList.stream().map((data) -> {
			return (RestaurantInfoDto) this.mapper.convertValue(data, RestaurantInfoDto.class);
		}).collect(Collectors.toList());
		model.addAttribute("restaurantInfo", result);
		return "contactUs";
	}

	@Autowired
	private RestaurantInfoRepository restoRepository;

	@GetMapping("/contactUs")
	public ModelAndView getAllRestaurants() {
		ModelAndView mav = new ModelAndView("contactUs");
		mav.addObject("restaurants", restoRepository.findAll());
		return mav;

	}


}
