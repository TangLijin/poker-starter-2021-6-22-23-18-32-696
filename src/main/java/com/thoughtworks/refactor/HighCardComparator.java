package com.thoughtworks.refactor;


public class HighCardComparator extends SameCategoryHandsComparator{

    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = compareHighCard(blackHandsObj, whiteHandsObj);
        return winResult;
    }

    public static String compareHighCard(Hands blackHandsObj, Hands whiteHandsObj) {
        //散牌
        String winResult = null;

        for (int i = 0; i < 5; i++) {
            if (blackHandsObj.getDescendingHandsNumbers()[i] < whiteHandsObj.getDescendingHandsNumbers()[i]) {
                String sig = intNumber(whiteHandsObj.getDescendingHandsNumbers()[i]);
                winResult = "white wins - high card:" + sig;
                break;
            } else if (blackHandsObj.getDescendingHandsNumbers()[i] > whiteHandsObj.getDescendingHandsNumbers()[i]) {
                String sig = intNumber(blackHandsObj.getDescendingHandsNumbers()[i]);
                winResult = "black wins - high card:" + sig;
                break;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }
}
