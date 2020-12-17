package com.daylight.tripservice;

import com.daylight.tripservice.exception.UserNotLoggedInException;
import com.daylight.tripservice.trip.Trip;
import com.daylight.tripservice.trip.TripDAO;
import com.daylight.tripservice.user.User;
import com.daylight.tripservice.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService_Original {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<Trip>();
        User loggedUser = UserSession.getInstance().getLoggedUser();
        boolean isFriend = false;
        if (loggedUser != null) {
            for (User friend : user.getFriends()) {
                if (friend.equals(loggedUser)) {
                    isFriend = true;
                    break;
                }
            }
            if (isFriend) {
                tripList = TripDAO.findTripsByUser(user);
            }
            return tripList;
        } else {
            throw new UserNotLoggedInException();
        }
    }

}
