package com.thoughtworks.refactor;

public class Category {
  private final String hands;

  public Category(String strType) {
    this.hands = strType;
  }

  public String getHands() {
    return hands;
  }

  int judgeHandsCategoryRanking() {
      int index = -1;
      String[] type = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};
      for (int i = 0; i < 9; i++) {
          if (type[i].equals(getHands())) {
              index = i;
          }
      }
      return index;
  }
}
