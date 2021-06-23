package com.thoughtworks.refactor;

import java.util.*;

public class Poker {

    public static final String[] CARD_TYPES = new String[]{"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};
    public static final String WHITE_WINS_HIGH_CARD = "white wins - high card:";
    public static final String BLACK_WINS_HIGH_CARD = "black wins - high card:";
    public static final String BLACK_WINS = "black wins - ";
    public static final String WHITE_WINS = "white wins - ";

    public String compareResult(String blackHands, String whiteHands) {
        String winResult = "";
        String blackCategoty = judgeCategoty(blackHands);
        String whiteCategoty = judgeCategoty(whiteHands);
        int[] blackNumber = sortNumberDesc(blackHands);
        int[] whiteNumber = sortNumberDesc(whiteHands);
        int blackRanking = judgeRanking(blackCategoty);
        int whiteRanking = judgeRanking(whiteCategoty);
        int[] blackArraySort = arraySort(blackNumber);
        int[] whiteArraySort = arraySort(whiteNumber);
        int[] blackRepeat = noOrRepeatNumber(blackNumber, 0);
        int[] whiteRepeat = noOrRepeatNumber(whiteNumber, 0);
        int[] blackNoRepeat = noOrRepeatNumber(blackNumber, 1);
        int[] whiteNoRepeat = noOrRepeatNumber(whiteNumber, 1);
        if (blackRanking < whiteRanking) {
            winResult = BLACK_WINS + CARD_TYPES[blackRanking];
        } else if (blackRanking > whiteRanking) {
            winResult = WHITE_WINS + CARD_TYPES[whiteRanking];
        } else {
            if (blackRanking == 0) { //同花顺
                if (blackNumber[0] < whiteNumber[0]) {
                    String sig = intNumber(whiteNumber[0]);
                    winResult = WHITE_WINS_HIGH_CARD + sig;
                } else if (blackNumber[0] > whiteNumber[0]) {
                    String sig = intNumber(blackNumber[0]);
                    winResult = BLACK_WINS_HIGH_CARD + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackRanking == 1) { //铁支
                if (blackArraySort[0] < whiteArraySort[0]) {
                    String sig = intNumber(whiteArraySort[0]);
                    winResult = WHITE_WINS_HIGH_CARD + sig;
                } else {
                    String sig = intNumber(blackArraySort[0]);
                    winResult = BLACK_WINS_HIGH_CARD + sig;
                }
            } else if (blackRanking == 2) { //葫芦

                if (blackArraySort[0] < whiteArraySort[0]) {
                    String sig = intNumber(whiteArraySort[0]);
                    winResult = WHITE_WINS_HIGH_CARD + sig;
                } else {
                    String sig = intNumber(blackArraySort[0]);
                    winResult = BLACK_WINS_HIGH_CARD + sig;
                }
            } else if (blackRanking == 3) { //同花
                for (int i = 0; i < 5; i++) {
                    if (blackNumber[i] < whiteNumber[i]) {
                        String sig = intNumber(whiteNumber[i]);
                        winResult = WHITE_WINS_HIGH_CARD + sig;
                        break;
                    } else if (blackNumber[i] > whiteNumber[i]) {
                        String sig = intNumber(blackNumber[i]);
                        winResult = BLACK_WINS_HIGH_CARD + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackRanking == 4) { //顺子
                if (blackNumber[0] < whiteNumber[0]) {
                    String sig = intNumber(whiteNumber[0]);
                    winResult = WHITE_WINS_HIGH_CARD + sig;
                } else if (blackNumber[0] > whiteNumber[0]) {
                    String sig = intNumber(blackNumber[0]);
                    winResult = BLACK_WINS_HIGH_CARD + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackRanking == 5) { //三条
                if (blackRepeat[0] < whiteRepeat[0]) {
                    String sig = intNumber(whiteRepeat[0]);
                    winResult = WHITE_WINS_HIGH_CARD + sig;
                } else {
                    String sig = intNumber(blackRepeat[0]);
                    winResult = BLACK_WINS_HIGH_CARD + sig;
                }
            } else if (blackRanking == 6) { //两对
                for (int i = 0; i < 2; i++) {
                    if (blackRepeat[i] < whiteRepeat[i]) {
                        String sig = intNumber(whiteRepeat[i]);
                        winResult = WHITE_WINS_HIGH_CARD + sig;
                        break;
                    } else if (blackRepeat[i] > whiteRepeat[i]) {
                        String sig = intNumber(blackRepeat[i]);
                        winResult = BLACK_WINS_HIGH_CARD + sig;
                        break;
                    }
                }
                if (winResult == "") {
                    if (blackNoRepeat[0] < whiteNoRepeat[0]) {
                        String sig = intNumber(whiteNoRepeat[0]);
                        winResult = WHITE_WINS_HIGH_CARD + sig;
                    } else if (blackNoRepeat[0] > whiteNoRepeat[0]) {
                        String sig = intNumber(blackNoRepeat[0]);
                        winResult = BLACK_WINS_HIGH_CARD + sig;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackRanking == 7) { //对子
                if (blackRepeat[0] < whiteRepeat[0]) {
                    String sig = intNumber(whiteRepeat[0]);
                    winResult = WHITE_WINS_HIGH_CARD + sig;
                } else if (blackRepeat[0] > whiteRepeat[0]) {
                    String sig = intNumber(blackRepeat[0]);
                    winResult = BLACK_WINS_HIGH_CARD + sig;
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (blackNoRepeat[i] < whiteNoRepeat[i]) {
                            String sig = intNumber(whiteNoRepeat[i]);
                            winResult = WHITE_WINS_HIGH_CARD + sig;
                            break;
                        } else if (blackNoRepeat[i] > whiteNoRepeat[i]) {
                            String sig = intNumber(blackNoRepeat[i]);
                            winResult = BLACK_WINS_HIGH_CARD + sig;
                            break;
                        } else {
                            winResult = "tie";
                        }
                    }
                }
            } else { //散牌
                for (int i = 0; i < 5; i++) {
                    if (blackNumber[i] < whiteNumber[i]) {
                        String sig = intNumber(whiteNumber[i]);
                        winResult = WHITE_WINS_HIGH_CARD + sig;
                        break;
                    } else if (blackNumber[i] > whiteNumber[i]) {
                        String sig = intNumber(blackNumber[i]);
                        winResult = BLACK_WINS_HIGH_CARD + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            }
        }
        return winResult;
    }

    private String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

    private int[] arraySort(int[] number) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
            } else {
                map.put(number[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> arg0, Map.Entry<Integer, Integer> arg1) {
                return arg1.getValue().compareTo(arg0.getValue());
            }
        });
        int[] arrayresult = new int[list.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            arrayresult[i] = entry.getKey();
            i++;
        }
        return arrayresult;
    }

    //先获得数组中每个元素出现的次数，然后再进行计算出现次数大于1的和出现次数等于1的
    private int[] noOrRepeatNumber(int[] number, int flag) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
            } else {
                map.put(number[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> arg0, Map.Entry<Integer, Integer> arg1) {
                return arg1.getValue().compareTo(arg0.getValue());
            }
        });
        int[] repeatnumber = new int[list.size()];
        int[] norepeatnumber = new int[list.size()];
        int i = 0;
        if (flag == 0) {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() > 1) {
                    repeatnumber[i] = entry.getKey();
                    i++;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() == 1) {
                    norepeatnumber[i] = entry.getKey();
                    i++;
                }
            }
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (flag == 0) {
            for (i = 0; i < repeatnumber.length; i++) {
                hashSet.add(repeatnumber[i]);
            }
        } else {
            for (i = 0; i < norepeatnumber.length; i++) {
                hashSet.add(norepeatnumber[i]);
            }
        }
        hashSet.remove(0);
        int[] result = new int[hashSet.size()];
        i = 0;
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        int[] reResult = new int[result.length];
        for (i = 0; i < result.length; i++) {
            reResult[i] = result[result.length - i - 1];
        }
        return reResult;
    }

    private int judgeRanking(String strType) {
        int index = -1;
        String[] type = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};
        for (int i = 0; i < 9; i++) {
            if (type[i].equals(strType)) {
                index = i;
            }
        }
        return index;
    }

    //判断是什么牌
    private String judgeCategoty(String hands) {
        String type = "";
        String[] strArray = hands.split("");
        int[] number = sortNumberDesc(hands);
        int i;
        String[] color = new String[5];
        for (i = 0; i < 5; i++) {
            color[i] = strArray[i * 3 + 1];
        }
        HashSet<Integer> distinctNumbers = new HashSet<Integer>();
        for (i = 0; i < 5; i++) {
            distinctNumbers.add(number[i]);
        }
        HashSet<String> suits = new HashSet<String>();
        for (i = 0; i < 5; i++) {
            suits.add(color[i]);
        }
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

    //数字转化并将其从大到小排序
    private int[] sortNumberDesc(String str) {
        int[] number = new int[5];
        String[] strArray = str.split("");
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
}
