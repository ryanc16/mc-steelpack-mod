package com.grouptwosoftworks.progressionplus.utils;

import java.util.Arrays;

public class StringUtils {

    public static String splitAndTake(String original, String splitOn, int take) {
        var split = original.split(splitOn);

        var sliced = (take > 0)
                ? Arrays.copyOfRange(split, 0, take)
                : Arrays.copyOfRange(split, 0, split.length + take);

        return String.join(splitOn, sliced);
    }
}
