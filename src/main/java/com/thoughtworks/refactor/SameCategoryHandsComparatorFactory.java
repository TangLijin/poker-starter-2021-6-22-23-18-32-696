package com.thoughtworks.refactor;


public class SameCategoryHandsComparatorFactory {


    public static SameCategoryHandsComparator getInstance(int categoryRanking) {
        if (categoryRanking == 0) {
            return new StraightFlushComparator();
        } else if (categoryRanking == 1) {
            return new FourOfAKindComparator();
        } else if (categoryRanking == 2) {
            return new FullHouseComparator();
        } else if (categoryRanking == 3) {
            return new FlushComparator();
        } else if (categoryRanking == 4) {
            return new StraightComparator();
        } else if (categoryRanking == 5) {
            return new ThreeOfAKindComparator();
        } else if (categoryRanking == 6) {
            return new TwoPairComparator();
        } else if (categoryRanking == 7) {
            return new OnePairComparator();
        }
        return new SameCategoryHandsComparator();
    }

    public static String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }
}
