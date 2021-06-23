package com.thoughtworks.refactor;


public class StraightComparator extends SameCategoryHandsComparator{
    public static String compareStraight(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (blackHandsObj.getDescendingHandsNumbers()[0] < whiteHandsObj.getDescendingHandsNumbers()[0]) {
            String sig = SameCategoryHandsComparator.intNumber(whiteHandsObj.getDescendingHandsNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else if (blackHandsObj.getDescendingHandsNumbers()[0] > whiteHandsObj.getDescendingHandsNumbers()[0]) {
            String sig = SameCategoryHandsComparator.intNumber(blackHandsObj.getDescendingHandsNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        } else {
            winResult = "tie";
        }
        return winResult;
    }

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = StraightComparator.compareStraight(blackHandsObj, whiteHandsObj);
        return winResult;
    }
}
