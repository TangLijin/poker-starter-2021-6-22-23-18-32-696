package com.thoughtworks.refactor;


public class FlushComparator extends SameCategoryHandsComparator{
    public static String compareFlush(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = null;
        for (int i = 0; i < 5; i++) {
            if (blackHandsObj.getDescendingHandsNumbers()[i] < whiteHandsObj.getDescendingHandsNumbers()[i]) {
                String sig = SameCategoryHandsComparatorFactory.intNumber(whiteHandsObj.getDescendingHandsNumbers()[i]);
                winResult = "white wins - high card:" + sig;
                break;
            } else if (blackHandsObj.getDescendingHandsNumbers()[i] > whiteHandsObj.getDescendingHandsNumbers()[i]) {
                String sig = SameCategoryHandsComparatorFactory.intNumber(blackHandsObj.getDescendingHandsNumbers()[i]);
                winResult = "black wins - high card:" + sig;
                break;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = FlushComparator.compareFlush(blackHandsObj, whiteHandsObj);
        return winResult;
    }
}
