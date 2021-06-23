package com.thoughtworks.refactor;


public class FullHouseComparator extends SameCategoryHandsComparator{

    public static String compareFullHouse(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;//葫芦
        if (blackHandsObj.getDistinctDescendingHandsNumbers()[0] < whiteHandsObj.getDistinctDescendingHandsNumbers()[0]) {
            String sig = SameCategoryHandsComparatorFactory.intNumber(whiteHandsObj.getDistinctDescendingHandsNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = SameCategoryHandsComparatorFactory.intNumber(blackHandsObj.getDistinctDescendingHandsNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
    }

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = FullHouseComparator.compareFullHouse(blackHandsObj, whiteHandsObj);
        return winResult;
    }
}
