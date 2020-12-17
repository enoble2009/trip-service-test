package com.daylight.tripservice.trip;

import com.daylight.tripservice.exception.CollaboratorCallException;
import com.daylight.tripservice.user.User;

import java.util.List;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new CollaboratorCallException(
				"TripDAO should not be invoked on an unit test.");
	}
	
}