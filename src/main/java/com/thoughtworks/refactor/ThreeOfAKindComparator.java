package com.thoughtworks.refactor;


public class ThreeOfAKindComparator extends SameCategoryHandsComparator{
    public static String compareThreeOfAKind(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (blackHandsObj.getDescendingRepeatNumbers()[0] < whiteHandsObj.getDescendingRepeatNumbers()[0]) {
            String sig = SameCategoryHandsComparatorFactory.intNumber(whiteHandsObj.getDescendingRepeatNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = SameCategoryHandsComparatorFactory.intNumber(blackHandsObj.getDescendingRepeatNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
    }

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = ThreeOfAKindComparator.compareThreeOfAKind(blackHandsObj, whiteHandsObj);
        return winResult;
    }
}
