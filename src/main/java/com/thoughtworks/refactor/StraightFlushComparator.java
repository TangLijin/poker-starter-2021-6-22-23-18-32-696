package com.thoughtworks.refactor;

/**
 * @author Louis Tang
 * @version 1.0
 * @Date 2021/6/23 16:29
 */
public class StraightFlushComparator extends SameCategoryHandsComparator{
    public static String compareStraightFlush(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;//同花顺
        if (blackHandsObj.getDescendingHandsNumbers()[0] < whiteHandsObj.getDescendingHandsNumbers()[0]) {
            String sig = intNumber(whiteHandsObj.getDescendingHandsNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else if (blackHandsObj.getDescendingHandsNumbers()[0] > whiteHandsObj.getDescendingHandsNumbers()[0]) {
            String sig = intNumber(blackHandsObj.getDescendingHandsNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        } else {
            winResult = "tie";
        }
        return winResult;
    }


    public static String compareSameCategoryHands(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = compareStraightFlush(blackHandsObj, whiteHandsObj);
        return winResult;
    }
}
