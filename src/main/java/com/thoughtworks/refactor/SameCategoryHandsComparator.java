package com.thoughtworks.refactor;


public class SameCategoryHandsComparator {

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        winResult = HighCardComparator.compareHighCard(blackHandsObj, whiteHandsObj);
        return winResult;
    }

}
