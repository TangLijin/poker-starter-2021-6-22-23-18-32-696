package com.thoughtworks.refactor;

public class Poker {

    public static final String[] HANDS_CATEGORY = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};

    public String compareResult(String blackHands, String whiteHands) {
        String winResult = "";
        Hands blackHandsObj = new Hands(blackHands);
        Hands whiteHandsObj = new Hands(whiteHands);
        if (blackHandsObj.getCategory().judgeHandsCategoryRanking() < whiteHandsObj.getCategory().judgeHandsCategoryRanking()) {
            winResult = "black wins - " + HANDS_CATEGORY[blackHandsObj.getCategory().judgeHandsCategoryRanking()];
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() > whiteHandsObj.getCategory().judgeHandsCategoryRanking()) {
            winResult = "white wins - " + HANDS_CATEGORY[whiteHandsObj.getCategory().judgeHandsCategoryRanking()];
        } else {
            winResult = compareSameCategoryHands(winResult, blackHandsObj, whiteHandsObj);
        }
        return winResult;
    }

    private String compareSameCategoryHands(String winResult, Hands blackHandsObj, Hands whiteHandsObj) {
        if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 0) { //同花顺
            winResult = compareStraightFlush(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 1) { //铁支
            winResult = compareFourOfAKind(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 2) { //葫芦
            winResult = compareFullHouse(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 3) { //同花
            winResult = compareFlush(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 4) { //顺子
            winResult = compareStraight(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 5) { //三条
            winResult = compareThreeOfAKind(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 6) { //两对
            winResult = compareTwoPair(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 7) { //对子
            winResult = compareOnePair(blackHandsObj, whiteHandsObj);
        } else { //散牌
            winResult = compareHighCard(winResult, blackHandsObj, whiteHandsObj);
        }
        return winResult;
    }

    private String compareHighCard(String winResult, Hands blackHandsObj, Hands whiteHandsObj) {
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

    private String compareOnePair(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = "";
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

    private String compareTwoPair(Hands blackHandsObj, Hands whiteHandsObj) {
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

    private String compareThreeOfAKind(Hands blackHandsObj, Hands whiteHandsObj) {
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

    private String compareStraight(Hands blackHandsObj, Hands whiteHandsObj) {
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

    private String compareFlush(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = "";
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

    private String compareFullHouse(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (blackHandsObj.getDistinctDescendingHandsNumbers()[0] < whiteHandsObj.getDistinctDescendingHandsNumbers()[0]) {
            String sig = intNumber(whiteHandsObj.getDistinctDescendingHandsNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = intNumber(blackHandsObj.getDistinctDescendingHandsNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
    }

    private String compareFourOfAKind(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (blackHandsObj.getDistinctDescendingHandsNumbers()[0] < whiteHandsObj.getDistinctDescendingHandsNumbers()[0]) {
            String sig = intNumber(whiteHandsObj.getDistinctDescendingHandsNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = intNumber(blackHandsObj.getDistinctDescendingHandsNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
    }

    private String compareStraightFlush(Hands blackHandsObj, Hands whiteHandsObj) {
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

    private String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

}
