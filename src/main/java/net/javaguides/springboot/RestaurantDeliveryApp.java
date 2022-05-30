package net.javaguides.springboot;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;



@SpringBootApplication
public class RestaurantDeliveryApp implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestaurantInfoRepository restaurantInfoRepository ;

	@Autowired
	private OrderRepository orderRepository ;

	@Autowired
	private OrderDetailsRepository orderDetailsRepository ;

	@Autowired
	private ItemRepository itemRepository;


	public static void main(String[] args) {
		SpringApplication.run(RestaurantDeliveryApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//userRepository.deleteAllInBatch();
		restaurantInfoRepository.deleteAllInBatch();
		orderRepository.deleteAllInBatch();
		orderDetailsRepository.deleteAllInBatch();
		itemRepository.deleteAllInBatch();

		//====================================
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		//generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		double double_random=rand.nextDouble();
		float float_random=rand.nextFloat();
		//====================================

		Item sPizza = Item.builder().item_name("Small Pizza").item_price(4.99).itemSize(FoodSize.SMALL).itemType(ItemType.MAIN_DISH).itemDescription("A classic italian meal. 12").build();
		itemRepository.save(sPizza);
		Item mPizza = Item.builder().item_name("Medium Pizza").item_price(5.99).itemSize(FoodSize.MEDIUM).itemType(ItemType.MAIN_DISH).itemDescription("A classic italian meal. 14").build();
		itemRepository.save(mPizza);
		Item lPizza = Item.builder().item_name("Large Pizza").item_price(6.99).itemSize(FoodSize.LARGE).itemType(ItemType.MAIN_DISH).itemDescription("A classic italian meal. 16").build();
		itemRepository.save(lPizza);
		Item sCoke = Item.builder().item_name("Small Coke").item_price(1.99).itemSize(FoodSize.SMALL).itemType(ItemType.DRINK).itemDescription("A small drink").build();
		itemRepository.save(sCoke);
		Item mCoke = Item.builder().item_name("Medium Coke").item_price(2.99).itemSize(FoodSize.MEDIUM).itemType(ItemType.DRINK).itemDescription("A medium drink").build();
		itemRepository.save(mCoke);
		Item lCoke = Item.builder().item_name("Large Coke").item_price(3.99).itemSize(FoodSize.LARGE).itemType(ItemType.DRINK).itemDescription("A huge drink").build();
		itemRepository.save(lCoke);
		Item sCheesyBread = Item.builder().item_name("Small Cheesy Bread").item_price(3.99).itemSize(FoodSize.SMALL).itemType(ItemType.SIDE_DISH).itemDescription("A small cheesy treat").build();
		itemRepository.save(sCheesyBread);
		Item mCheesyBread = Item.builder().item_name("Medium Cheesy Bread").item_price(4.99).itemSize(FoodSize.MEDIUM).itemType(ItemType.SIDE_DISH).itemDescription("A medium cheesy treat").build();
		itemRepository.save(mCheesyBread);
		Item lCheesyBread = Item.builder().item_name("Large Cheesy Bread").item_price(6.99).itemSize(FoodSize.LARGE).itemType(ItemType.SIDE_DISH).itemDescription("A large cheesy treat").build();
		itemRepository.save(lCheesyBread);

		RestaurantInfo firstLocation = RestaurantInfo.builder().restaurantName("Super Pizza").address("1234 Sainte-Catherine").phoneNumber("414 526 8698").build();
		restaurantInfoRepository.save(firstLocation);
	}
}
