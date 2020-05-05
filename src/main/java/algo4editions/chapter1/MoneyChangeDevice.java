package algo4editions.chapter1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoneyChangeDevice {

    Map<Integer, Integer> remainCoins = new HashMap<>();

    /**
     * Constructor for MoneyChangeDevice class defining its initial slots state
     *
     * @param initialSetup the initial money change device slots setup following the format described in this test description. *
     */
    public MoneyChangeDevice(String initialSetup) {
        String[] firstArray = initialSetup.split(" ");
        for(String s : firstArray) {
            String[] split = s.split(":");
            String value = split[0];
            String quantity = split[1];
            remainCoins.put(Integer.valueOf(value), Integer.valueOf(quantity));
        }
    }

    public static int[] minChange(Integer[] denom, Integer changeAmount) {
        int n = denom.length;
        int[] count = new int[changeAmount + 1];
        int[] from = new int[changeAmount + 1];
        count[0] = 1;
        for(int i = 0; i < changeAmount; i++)
            if (count[i] > 0)
                for(int j = 0; j < n; j++) {
                    int p = i + denom[j];
                    if (p <= changeAmount) {
                        if (count[p] == 0 || count[p] > count[i] + 1) {
                            count[p] = count[i] + 1;
                            from[p] = j;
                        }
                    }
                }
        if (count[changeAmount] == 0) {
            return null;
        }

        int[] result = new int[count[changeAmount] - 1];
        int k = changeAmount;
        while (k > 0) {
            result[count[k] - 2] = denom[from[k]];
            k = k - denom[from[k]];
        }

        return result;
    }

    /**
     * Calculates the money change for a given amount, <b>returning the least amount of bills</b>.<br />
     * A successful call to this method will change the current money slots state, comprising of the remaining bills for each slot.
     *
     * @param amount The amount to be changed following the format described in this test description.
     * @return The money change and the resulting change slots setup as per this test description.<br />
     * In case of no possible change, please also refer this test description
     */
    public String makeChangeForAmount(String amount) {
        Integer am = Integer.parseInt(amount);
        int[] coins = minChange(remainCoins.keySet().toArray(new Integer[remainCoins.size()]), am);
        Map<Integer, Integer> changedCoins = new HashMap<>();
        for(int coin : coins) {
            if (changedCoins.containsKey(coin)) {
                changedCoins.put(coin, changedCoins.get(coin) + 1);
            } else {
                changedCoins.put(coin, 1);
            }
            remainCoins.put(coin, remainCoins.get(coin) - 1);
        }

        String resultingState = "";


        List<Integer> changedCoinSortedKeys = changedCoins.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(Integer c : changedCoinSortedKeys) {
            resultingState += c + ":" + changedCoins.get(c) + " ";
        }
        resultingState = resultingState.substring(0, resultingState.length() - 1);
        resultingState += "; ";
        List<Integer> remainCoinsSortedKeys = remainCoins.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(Integer c : remainCoinsSortedKeys) {
            resultingState += c + ":" + remainCoins.get(c) + " ";
        }
        return resultingState;
    }

    // You are allowed to create more methods to solve the challenge
    public static void main(String[] args) {
        MoneyChangeDevice moneyChangeDevice = new MoneyChangeDevice("6:10 5:10 3:10");
        String s = moneyChangeDevice.makeChangeForAmount("16");
        System.out.println(s);
    }
}
