package com.thoughtworks.refactor;

public class TwoPairComparator extends SameCategoryHandsComparator{

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = compareTwoPair(blackHandsObj, whiteHandsObj);
        return winResult;
    }

    public static String compareTwoPair(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = "";
        for (int i = 0; i < 2; i++) {
            if (blackHandsObj.getDescendingRepeatNumbers()[i] < whiteHandsObj.getDescendingRepeatNumbers()[i]) {
                String sig = SameCategoryHandsComparatorFactory.intNumber(whiteHandsObj.getDescendingRepeatNumbers()[i]);
                winResult = "white wins - high card:" + sig;
                break;
            } else if (blackHandsObj.getDescendingRepeatNumbers()[i] > whiteHandsObj.getDescendingRepeatNumbers()[i]) {
                String sig = SameCategoryHandsComparatorFactory.intNumber(blackHandsObj.getDescendingRepeatNumbers()[i]);
                winResult = "black wins - high card:" + sig;
                break;
            }
        }
        if (winResult == "") {
            if (blackHandsObj.getDescendingNoRepeatNumbers()[0] < whiteHandsObj.getDescendingNoRepeatNumbers()[0]) {
                String sig = SameCategoryHandsComparatorFactory.intNumber(whiteHandsObj.getDescendingNoRepeatNumbers()[0]);
                winResult = "white wins - high card:" + sig;
            } else if (blackHandsObj.getDescendingNoRepeatNumbers()[0] > whiteHandsObj.getDescendingNoRepeatNumbers()[0]) {
                String sig = SameCategoryHandsComparatorFactory.intNumber(blackHandsObj.getDescendingNoRepeatNumbers()[0]);
                winResult = "black wins - high card:" + sig;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }
}
