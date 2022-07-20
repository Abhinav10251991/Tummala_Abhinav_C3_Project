import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE
    LocalTime openingTime;
    LocalTime closingTime;
    @BeforeEach
    public void before_each_test() {
        openingTime = LocalTime.parse("10:30:00");
        closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
//        Restaurant restaurants = Mockito.mock(Restaurant.class);
//        LocalTime presentTime = LocalTime.parse("11:00:00");
//        Mockito.when(restaurants.getCurrentTime()).thenReturn(presentTime);
        //restaurant.getCurrentTime();
//        //openingTime = restaurants.getCurrentTime();
//        openingTime = LocalTime.parse("10:00:00");
//        restaurants.isRestaurantOpen();
//        openingTime = restaurants.getCurrentTime();
 //       openingTime = LocalTime.parse("01:30:00");
  //      closingTime = LocalTime.parse("23:59:00");
        assertTrue(restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
//      restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        Restaurant restaurants = Mockito.mock(Restaurant.class);
        LocalTime presentTime = LocalTime.parse("23:30:00");
        //LocalTime openingTime = LocalTime.now();
        Mockito.when(restaurants.getCurrentTime()).thenReturn(presentTime);
        //restaurant.getCurrentTime();
        closingTime = restaurants.getCurrentTime();
        assertFalse(restaurants.isRestaurantOpen());
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);
        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //<<<<<<<<<<<<<<<<<<<<<<<Adding TDD testcase>>>>>>>>>>>>>>
    @Test
    public void Select_item_Calculate_total_price_should_return_TotalPrice(){
        restaurant.addToMenu("Sizzling brownie",319);
        restaurant.getOrderValue("Sweet corn soup","Vegetable lasagne");
        assertEquals(388,restaurant.getOrderValue("Sweet corn soup","Vegetable lasagne"));
    }
}