package com.thoughtworks.refactor;

/**
 * @author TangLijin
 * @version 1.0
 * @Date 2021/6/23 16:49
 */
public class OnePairComparator extends SameCategoryHandsComparator{

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = compareOnePair(blackHandsObj, whiteHandsObj);
        return winResult;
    }

    public static String compareOnePair(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = null;
        if (blackHandsObj.getDescendingRepeatNumbers()[0] < whiteHandsObj.getDescendingRepeatNumbers()[0]) {
            String sig = SameCategoryHandsComparatorFactory.intNumber(whiteHandsObj.getDescendingRepeatNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else if (blackHandsObj.getDescendingRepeatNumbers()[0] > whiteHandsObj.getDescendingRepeatNumbers()[0]) {
            String sig = SameCategoryHandsComparatorFactory.intNumber(blackHandsObj.getDescendingRepeatNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        } else {
            for (int i = 0; i < 3; i++) {
                if (blackHandsObj.getDescendingNoRepeatNumbers()[i] < whiteHandsObj.getDescendingNoRepeatNumbers()[i]) {
                    String sig = SameCategoryHandsComparatorFactory.intNumber(whiteHandsObj.getDescendingNoRepeatNumbers()[i]);
                    winResult = "white wins - high card:" + sig;
                    break;
                } else if (blackHandsObj.getDescendingNoRepeatNumbers()[i] > whiteHandsObj.getDescendingNoRepeatNumbers()[i]) {
                    String sig = SameCategoryHandsComparatorFactory.intNumber(blackHandsObj.getDescendingNoRepeatNumbers()[i]);
                    winResult = "black wins - high card:" + sig;
                    break;
                } else {
                    winResult = "tie";
                }
            }
        }
        return winResult;
    }
}
