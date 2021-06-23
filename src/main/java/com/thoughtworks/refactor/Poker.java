package com.thoughtworks.refactor;

public class Poker {

    public static final String[] HANDS_CATEGORY = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};

    public String compareResult(String blackHands, String whiteHands) {
        String winResult = "";
        final Hands blackHandsObj = new Hands(blackHands);
        final Hands whiteHandsObj = new Hands(whiteHands);

        if (blackHandsObj.getCategory().getRanking() < whiteHandsObj.getCategory().getRanking()) {
            winResult = "black wins - " + HANDS_CATEGORY[blackHandsObj.getCategory().getRanking()];
        } else if (blackHandsObj.getCategory().getRanking() > whiteHandsObj.getCategory().getRanking()) {
            winResult = "white wins - " + HANDS_CATEGORY[whiteHandsObj.getCategory().getRanking()];
        } else {
            winResult = SameCategoryHandsComparatorFactory.getInstance(blackHandsObj.getCategory().getRanking()).compareSameCategoryHands(blackHandsObj, whiteHandsObj);
        }
        return winResult;
    }

}
