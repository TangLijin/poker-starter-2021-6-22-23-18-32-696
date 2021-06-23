package com.thoughtworks.refactor;

import java.util.*;

public class Hands {
    private final String hands;

    public Hands(String hands) {
        this.hands = hands;
    }

    //先获得数组中每个元素出现的次数，然后再进行计算出现次数大于1的和出现次数等于1的
    static int[] noOrRepeatNumber(int[] number, int flag) {
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

    static int[] getDescendingRepeatNumbers(int[] blackDescendingHandsNumbers) {
        return noOrRepeatNumber(blackDescendingHandsNumbers, 0);
    }

    static int[] getDescendingNoRepeatNumbers(int[] blackDescendingHandsNumbers) {
        return noOrRepeatNumber(blackDescendingHandsNumbers, 1);
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

    int[] getDescendingRepeatNumbers() {
        return getDescendingRepeatNumbers(getDescendingHandsNumbers());
    }

    int[] getDescendingNoRepeatNumbers() {
        return getDescendingNoRepeatNumbers(getDescendingHandsNumbers());
    }
}
