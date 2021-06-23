package com.thoughtworks.refactor;

public class Hands {
  private final String hands;

  public Hands(String hands) {
    this.hands = hands;
  }

  public String getHands() {
    return hands;
  }

  Category getCategory() {
      return new Category(PokerUtil.judgeHandCategory(this));
  }

  int[] getDescendingHandsNumbers() {
      return PokerUtil.getDescendingHandsNumbers(this);
  }

  int[] getDistinctDescendingHandsNumbers() {
      return PokerUtil.getDistinctDescendingHandsNumbers(getDescendingHandsNumbers());
  }

  int[] getDescendingNoRepeatNumbers() {
      return PokerUtil.getDescendingNoRepeatNumbers(getDescendingHandsNumbers());
  }

  int[] getDescendingRepeatNumbers() {
      return PokerUtil.getDescendingRepeatNumbers(getDescendingHandsNumbers());
  }
}
