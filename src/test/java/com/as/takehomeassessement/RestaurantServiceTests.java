package com.as.takehomeassessement;

import com.as.takehomeassessement.domain.Restaurant;
import com.as.takehomeassessement.dto.SearchBestMatchedRestaurantsRequestDTO;
import com.as.takehomeassessement.mapper.RestaurantMapper;
import com.as.takehomeassessement.repository.RestaurantRepository;
import com.as.takehomeassessement.service.RestaurantService;
import com.as.takehomeassessement.util.JsonParseUtil;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RestaurantServiceTests {

	private static final int NUMBER_OF_RESTAURANTS_TO_MATCH = 5;
	private static final String[] EXPECTED_CHINESE_ARRAY = {"Deliciouszilla", "Chow Table", "Grill Tasty", "Gusto Delicious", "Crisp Kitchen"};
	private static final String[] EXPECTED_DISTANCE_1_ARRAY = {"Deliciousgenix", "Deliciouszilla", "Fodder Table", "Dished Grill", "Sizzle Yummy"};
	private static final String[] EXPECTED_RATING_5_DISTANCE_2_PRICE_15_ARRAY = {"Grove Table", "Bang Delicious", "Traditional Chow"};
	private static final String[] EXPECTED_NAME_CONTAINS_DEL_ARRAY = {"Deliciousgenix", "Deliciouszilla", "Havana Delicious", "Bang Delicious", "Crisp Delicious"};

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private RestaurantMapper restaurantMapper;

	private RestaurantService restaurantService;

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@BeforeEach
	void setup() {
		List<Restaurant> restaurants = JsonParseUtil.parseToListOfObjects("src/test/resources/mock/restaurants.json", Restaurant[].class);
		RestaurantRepository restaurantRepositorySpy = Mockito.spy(restaurantRepository);
		Mockito.when(restaurantRepositorySpy.findAll()).thenReturn(restaurants);
		restaurantService = Mockito.spy(new RestaurantService(restaurantRepositorySpy, restaurantMapper));
	}

	@Test
	@DisplayName("Find Top 5 Best Matched Restaurants {Cuisine=Chinese}")
	void findTopNBestMatchedRestaurantsChinese() {

		SearchBestMatchedRestaurantsRequestDTO requestDTO = SearchBestMatchedRestaurantsRequestDTO.builder()
				.cuisine("Chinese")
				.build();

		List<Restaurant> restaurants = restaurantService.findTopNBestMatchedRestaurants(requestDTO, NUMBER_OF_RESTAURANTS_TO_MATCH);

		for (int i = 0; i < restaurants.size(); i++) {
			Assertions.assertEquals(EXPECTED_CHINESE_ARRAY[i], restaurants.get(i).getName());
		}
	}

	@Test
	@DisplayName("Find Top 5 Best Matched Restaurants {Distance=1}")
	void findTopNBestMatchedRestaurantsDistance1() {
		SearchBestMatchedRestaurantsRequestDTO requestDTO = SearchBestMatchedRestaurantsRequestDTO.builder()
				.distance(1)
				.build();

		List<Restaurant> restaurants = restaurantService.findTopNBestMatchedRestaurants(requestDTO, NUMBER_OF_RESTAURANTS_TO_MATCH);

		for (int i = 0; i < restaurants.size(); i++) {
			Assertions.assertEquals(EXPECTED_DISTANCE_1_ARRAY[i], restaurants.get(i).getName());
		}
	}

	@Test
	@DisplayName("Find Top 5- Best Matched Restaurants {Rating=5, Distance=2, Price=15}")
	void findTopNBestMatchedRestaurantsRating5Distance2Price15() {
		SearchBestMatchedRestaurantsRequestDTO requestDTO = SearchBestMatchedRestaurantsRequestDTO.builder()
				.customerRating(5)
				.distance(2)
				.price(15)
				.build();

		List<Restaurant> restaurants = restaurantService.findTopNBestMatchedRestaurants(requestDTO, NUMBER_OF_RESTAURANTS_TO_MATCH);

		for (int i = 0; i < restaurants.size(); i++) {
			Assertions.assertEquals(EXPECTED_RATING_5_DISTANCE_2_PRICE_15_ARRAY[i], restaurants.get(i).getName());
		}
	}

	@Test
	@DisplayName("Find Top 5- Best Matched Restaurants {Name=Del}")
	void findTopNBestMatchedRestaurantsNameContainsDel() {
		SearchBestMatchedRestaurantsRequestDTO requestDTO = SearchBestMatchedRestaurantsRequestDTO.builder()
				.restaurantName("Del")
				.build();

		List<Restaurant> restaurants = restaurantService.findTopNBestMatchedRestaurants(requestDTO, NUMBER_OF_RESTAURANTS_TO_MATCH);

		for (int i = 0; i < restaurants.size(); i++) {
			Assertions.assertEquals(EXPECTED_NAME_CONTAINS_DEL_ARRAY[i], restaurants.get(i).getName());
		}
	}

}
