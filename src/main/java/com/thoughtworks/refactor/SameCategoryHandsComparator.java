package com.thoughtworks.refactor;


public class SameCategoryHandsComparator {

    public static String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

    public static SameCategoryHandsComparator getInstance(int categoryRanking) {
        if (categoryRanking == 0) {
            return new StraightFlushComparator();
        }
        return new SameCategoryHandsComparator();
    }

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        winResult = HighCardComparator.compareHighCard(blackHandsObj, whiteHandsObj);
        return winResult;
    }

}
