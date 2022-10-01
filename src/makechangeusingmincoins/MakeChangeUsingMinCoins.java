/*

Given an array of integers as coins and a number k. Return minimum number of
coins that can be used to make k. You may consider that coins will always have
1 cent in there so that there will be no such case that the combination is 
not possible.



 */
package makechangeusingmincoins;

/**
 *
 * @author Ali
 */
public class MakeChangeUsingMinCoins
{
    public static void main(String args[])
    {
        int[] arr = {1,3,4};
        //Output of following case should be ====>  2
        System.out.println(minCoins(arr, 6));
    }

    public static int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        int coinCount = coinChangeHelper(coins, amount, map);
        return coinCount == Integer.MAX_VALUE ? -1 : coinCount;
    }
    
    private static int coinChangeHelper(int[] coins, int amount, Map<Integer, Integer> map)
    {
        if (map.get(amount) != null)
        {
            return map.get(amount);
        }
        if (amount == 0)
        {
            return 0;
        }
        int coinCount = Integer.MAX_VALUE;

        for (int coin : coins)
        {
            if (coin <= amount)
            {
                int tempCoinCount = coinChangeHelper(coins, amount - coin, map);
                if (tempCoinCount != Integer.MAX_VALUE && tempCoinCount + 1 < coinCount) {
                    coinCount = tempCoinCount + 1;
                }
            }
        }
        map.put(amount, coinCount);
        return map.get(amount);
    }
}
