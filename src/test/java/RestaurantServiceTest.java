import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RestaurantServiceTest {

    RestaurantService service = new RestaurantService();
    Restaurant restaurant;
    LocalTime openingTime;
    LocalTime closingTime;
    //REFACTOR ALL THE REPEATED LINES OF CODE
    @BeforeEach
            public void before_each_test() {
        openingTime = LocalTime.parse("10:30:00");
        closingTime = LocalTime.parse("22:00:00");
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }
    //>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() throws restaurantNotFoundException {
        //WRITE UNIT TEST CASE HERE
        //LocalTime openingTime = LocalTime.parse("10:30:00");
        //LocalTime closingTime = LocalTime.parse("22:00:00");
        //restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        Restaurant expected = service.findRestaurantByName("Amelie's cafe");
        Restaurant actual = null;
        int i;
        for(i = 0; i<service.getRestaurants().size();i++){
            if(service.getRestaurants().get(i).equals(expected)){
                actual = service.getRestaurants().get(i);
            }
        }
       assertEquals(expected,actual);
    }

    //You may watch the video by Muthukumaran on how to write exceptions in Course 3: Testing and Version control: Optional content
    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() throws restaurantNotFoundException {
        //WRITE UNIT TEST CASE HERE
        //LocalTime openingTime = LocalTime.parse("10:30:00");
        //LocalTime closingTime = LocalTime.parse("22:00:00");
        //restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        assertThrows(restaurantNotFoundException.class, ()-> service.findRestaurantByName("Udi"));

    }
    //<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>

    //>>>>>>>>>>>>>>>>>>>>>>ADMIN: ADDING & REMOVING RESTAURANTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1() throws restaurantNotFoundException {
        //LocalTime openingTime = LocalTime.parse("10:30:00");
        //LocalTime closingTime = LocalTime.parse("22:00:00");
        //restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
       // restaurant.addToMenu("Sweet corn soup",119);
       // restaurant.addToMenu("Vegetable lasagne", 269);

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.removeRestaurant("Amelie's cafe");
        assertEquals(initialNumberOfRestaurants-1, service.getRestaurants().size());
    }

    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception() throws restaurantNotFoundException {
        //LocalTime openingTime = LocalTime.parse("10:30:00");
        //LocalTime closingTime = LocalTime.parse("22:00:00");
        //restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        //restaurant.addToMenu("Sweet corn soup",119);
        //restaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(restaurantNotFoundException.class,()->service.removeRestaurant("Pantry d'or"));
    }

    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1(){
       // LocalTime openingTime = LocalTime.parse("10:30:00");
       // LocalTime closingTime = LocalTime.parse("22:00:00");
        //restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        //restaurant.addToMenu("Sweet corn soup",119);
        //restaurant.addToMenu("Vegetable lasagne", 269);

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.addRestaurant("Pumpkin Tales","Chennai",LocalTime.parse("12:00:00"),LocalTime.parse("23:00:00"));
        assertEquals(initialNumberOfRestaurants + 1,service.getRestaurants().size());
    }
    //<<<<<<<<<<<<<<<<<<<<ADMIN: ADDING & REMOVING RESTAURANTS>>>>>>>>>>>>>>>>>>>>>>>>>>
}