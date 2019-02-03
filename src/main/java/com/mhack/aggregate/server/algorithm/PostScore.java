package com.mhack.aggregate.server.algorithm;

import com.mhack.aggregate.server.api.post.domain.Post;
import com.mhack.aggregate.server.api.user.UserAPI;
import com.mhack.aggregate.server.api.user.domain.User;
import com.mhack.aggregate.server.api.user.domain.profile.FarmEquipment;
import com.mhack.aggregate.server.api.user.domain.profile.FarmType;

import java.util.Map;

public class PostScore {

    private static double timeScore = 2.0;
    private static double farmTypeScore = 2.0;
    private static double farmSizeScore = 2.0;
    private static double locationScore = 2.0;
    private static double farmEquipmentScore = 2.0;

    public static double calculatePostScore(User user, Post post, Map<String, User> cache) {
        try {
            User poster = cache.computeIfAbsent(post.getUserId(), UserAPI::getUserById);
            int diff = Math.abs(user.getProfile().getFarmSize().getSize() - poster.getProfile().getFarmSize().getSize());
            return Math.pow(1000 -  diff, 5);
        }
        catch (Throwable e){
            e.printStackTrace();
        }
        return 0;
    }

    private static double calculateTimeScore(Post post) {
        int hoursDifference = (int) (System.currentTimeMillis() - post.getTime() / 3.6e+6);
        return timeScore - (hoursDifference * .05);
    }

    private static double calculateTypeScore(User user, User poster) {
        for (FarmType ft : user.getProfile().getFarmTypes()) {
            for (FarmType posterFt : poster.getProfile().getFarmTypes()) {
                if (ft.equals(posterFt)) {
                    return 2.0;
                }
            }
        }
        return 0.5;
    }

    private static double calculateSizeScore(User user, User poster) {
        int difference =
                Math.abs(user.getProfile().getFarmSize().getSizeBracket() - poster.getProfile().getFarmSize().getSizeBracket());

        if (difference == 0) {
            return 2.0;
        } else if (difference == 1) {
            return 1.75;
        } else if (difference == 2) {
            return 1.25;
        } else if (difference == 3) {
            return .5;
        } else {
            return 0;
        }
    }

    private static double calculateLocationScore(User user, User poster) {
        double userLocTotal =
                (Math.abs(user.getProfile().getLocation().getCoordinatesMap().get(user.getProfile().getLocation().getState()).getX())
                        + Math.abs(user.getProfile().getLocation().getCoordinatesMap().get(user.getProfile().getLocation().getState()).getY()));
        double posterLocTotal =
                (Math.abs(poster.getProfile().getLocation().getCoordinatesMap().get(poster.getProfile().getLocation().getState()).getX())
                        + Math.abs(poster.getProfile().getLocation().getCoordinatesMap().get(poster.getProfile().getLocation().getState()).getY()));
        double total = Math.abs(userLocTotal - posterLocTotal);
        if (total <= 10) {
            return 2.0 - (total / 1000);
        } else if (total <= 25) {
            return 1.99 - ((total - 10) / 75);
        } else if (total <= 75) {
            return 1.79 - ((total - 25) / 50);
        } else if (total <= 100) {
            return 0.79 - ((total - 75) / 30);
        } else {
            return 0;
        }
    }

    private static double caclulateFarmEquipmentScore(User user, User poster) {
        for(FarmEquipment fe : user.getProfile().getEquipment()) {
            for(FarmEquipment posterfe : poster.getProfile().getEquipment()) {
                if(fe.equals(posterfe)) {
                    return 2.0;
                }
            }
        }
        return 0;
    }

}
