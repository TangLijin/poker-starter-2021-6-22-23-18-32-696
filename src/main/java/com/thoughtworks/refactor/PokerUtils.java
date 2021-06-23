package com.thoughtworks.refactor;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Louis Tang
 * @version 1.0
 * @Date 2021/6/23 11:27
 */
public class PokerUtils {

    public static HashSet<String> getSuits(String hands) {
        String[] numbers = hands.split("");
        int i;
        String[] color = new String[5];
        for (i = 0; i < 5; i++) {
            color[i] = numbers[i * 3 + 1];
        }
        HashSet<String> suits = new HashSet<String>();
        for (i = 0; i < 5; i++) {
            suits.add(color[i]);
        }
        return suits;
    }


    public static HashSet<Integer> getDistinctNumbers(int[] number) {
        int i;
        HashSet<Integer> distinctNumbers = new HashSet<Integer>();
        for (i = 0; i < 5; i++) {
            distinctNumbers.add(number[i]);
        }
        return distinctNumbers;
    }

    //数字转化并将其从大到小排序
    public static int[] sortNumberDesc(String hands) {
        int[] number = new int[5];
        String[] strArray = hands.split("");
        int i;
        for (i = 0; i < 5; i++) {
            String c = strArray[i * 3];
            switch (c) {
                case "T":
                    number[i] = 10;
                    break;
                case "J":
                    number[i] = 11;
                    break;
                case "Q":
                    number[i] = 12;
                    break;
                case "K":
                    number[i] = 13;
                    break;
                case "A":
                    number[i] = 14;
                    break;
                default:
                    number[i] = Integer.valueOf(c);
                    break;
            }
        }

        Arrays.sort(number);
        int[] renumber = new int[number.length];
        for (i = 0; i < number.length; i++) {
            renumber[i] = number[number.length - i - 1];
        }
        return renumber;
    }

    public static String getCategory(int[] number, HashSet<Integer> distinctNumbers, HashSet<String> suits) {
        String type = "";
        if (distinctNumbers.size() == 5) {
            if ((number[0] - number[4] == 4) && (suits.size() == 1) && (distinctNumbers.size() == 5)) { //五个相邻的数字且花色一样——同花顺
                type = "StraightFlush";
            } else if (number[0] - number[4] == 4 && (distinctNumbers.size() == 5)) { //五个相邻数字——顺子
                type = "Straight";
            } else if (suits.size() == 1) { //同一花色——同花
                type = "Flush";
            } else { //五个不相邻的数字——散牌
                type = "HighCard";
            }
        } else if (distinctNumbers.size() == 4) { //一对相同，其余三个数字不同——对子
            type = "OnePair";
        } else if (distinctNumbers.size() == 3) {
            if ((number[0] == number[1] && number[2] == number[3]) || (number[1] == number[2] && number[3] == number[4]) || (number[0] == number[1] && number[3] == number[4])) { //两对
                type = "TwoPair";
            } else { //三个数字相同，另外两个数字不同——三条
                type = "ThreeOfAKind";
            }
        } else {
            if (number[0] != number[1] || number[3] != number[4]) { //三个数字相同，另外两个数字相同——葫芦
                type = "FourOfAKind";
            } else { //四个数字相同——铁支
                type = "FullHouse";
            }
        }
        return type;
    }
}
