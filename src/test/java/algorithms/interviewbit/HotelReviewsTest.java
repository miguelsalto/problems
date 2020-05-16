package algorithms.interviewbit;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReviewsTest {

    @Test
    public void testHotelReviews() {
        HotelReviews hotelReviews = new HotelReviews();
        assertEquals(
            newArrayList(2, 0, 1), // expected
            hotelReviews.solve(
                "cool_ice_wifi",
                newArrayList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")
            )
        );
    }

}