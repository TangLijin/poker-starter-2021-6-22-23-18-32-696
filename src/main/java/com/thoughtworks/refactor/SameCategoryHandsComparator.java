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
         if (blackHandsObj.getCategory().getRanking() == 2) {
            winResult = SameCategoryHandsComparator.compareFullHouse(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().getRanking() == 3) { //同花
            winResult = SameCategoryHandsComparator.compareFlush(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().getRanking() == 4) { //顺子
            winResult = SameCategoryHandsComparator.compareStraight(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().getRanking() == 5) { //三条
            winResult = SameCategoryHandsComparator.compareThreeOfAKind(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().getRanking() == 6) { //两对
            winResult = SameCategoryHandsComparator.compareTwoPair(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().getRanking() == 7) { //对子
            winResult = SameCategoryHandsComparator.compareOnePair(blackHandsObj, whiteHandsObj);
        } else {
            winResult = SameCategoryHandsComparator.compareHighCard(blackHandsObj, whiteHandsObj);
        }
        return winResult;
    }

    public static String compareThreeOfAKind(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (blackHandsObj.getDescendingRepeatNumbers()[0] < whiteHandsObj.getDescendingRepeatNumbers()[0]) {
            String sig = intNumber(whiteHandsObj.getDescendingRepeatNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = intNumber(blackHandsObj.getDescendingRepeatNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
    }

    public static String compareStraight(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
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

    public static String compareFlush(Hands blackHandsObj, Hands whiteHandsObj) {
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

    public static String compareFullHouse(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;//葫芦
        if (blackHandsObj.getDistinctDescendingHandsNumbers()[0] < whiteHandsObj.getDistinctDescendingHandsNumbers()[0]) {
            String sig = intNumber(whiteHandsObj.getDistinctDescendingHandsNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = intNumber(blackHandsObj.getDistinctDescendingHandsNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        }
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

    public static String compareOnePair(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = null;
        if (blackHandsObj.getDescendingRepeatNumbers()[0] < whiteHandsObj.getDescendingRepeatNumbers()[0]) {
            String sig = intNumber(whiteHandsObj.getDescendingRepeatNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else if (blackHandsObj.getDescendingRepeatNumbers()[0] > whiteHandsObj.getDescendingRepeatNumbers()[0]) {
            String sig = intNumber(blackHandsObj.getDescendingRepeatNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        } else {
            for (int i = 0; i < 3; i++) {
                if (blackHandsObj.getDescendingNoRepeatNumbers()[i] < whiteHandsObj.getDescendingNoRepeatNumbers()[i]) {
                    String sig = intNumber(whiteHandsObj.getDescendingNoRepeatNumbers()[i]);
                    winResult = "white wins - high card:" + sig;
                    break;
                } else if (blackHandsObj.getDescendingNoRepeatNumbers()[i] > whiteHandsObj.getDescendingNoRepeatNumbers()[i]) {
                    String sig = intNumber(blackHandsObj.getDescendingNoRepeatNumbers()[i]);
                    winResult = "black wins - high card:" + sig;
                    break;
                } else {
                    winResult = "tie";
                }
            }
        }
        return winResult;
    }

    public static String compareTwoPair(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = "";
        for (int i = 0; i < 2; i++) {
            if (blackHandsObj.getDescendingRepeatNumbers()[i] < whiteHandsObj.getDescendingRepeatNumbers()[i]) {
                String sig = intNumber(whiteHandsObj.getDescendingRepeatNumbers()[i]);
                winResult = "white wins - high card:" + sig;
                break;
            } else if (blackHandsObj.getDescendingRepeatNumbers()[i] > whiteHandsObj.getDescendingRepeatNumbers()[i]) {
                String sig = intNumber(blackHandsObj.getDescendingRepeatNumbers()[i]);
                winResult = "black wins - high card:" + sig;
                break;
            }
        }
        if (winResult == "") {
            if (blackHandsObj.getDescendingNoRepeatNumbers()[0] < whiteHandsObj.getDescendingNoRepeatNumbers()[0]) {
                String sig = intNumber(whiteHandsObj.getDescendingNoRepeatNumbers()[0]);
                winResult = "white wins - high card:" + sig;
            } else if (blackHandsObj.getDescendingNoRepeatNumbers()[0] > whiteHandsObj.getDescendingNoRepeatNumbers()[0]) {
                String sig = intNumber(blackHandsObj.getDescendingNoRepeatNumbers()[0]);
                winResult = "black wins - high card:" + sig;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }

}
