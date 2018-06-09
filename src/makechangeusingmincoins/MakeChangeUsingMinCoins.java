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

    public static int minCoins(int[] coins, int sum){
      if (sum == 0) {
        return 0;
      }

      int[] memo = new int[sum+1];
      for (int i=0; i<sum+1; i++) {
        memo[i] = Integer.MAX_VALUE;
      }

      memo[0] = 0;
      for (int i=1; i<sum+1; i++){
        for (int j=0; j<coins.length; j++){
          if (coins[j] <= i) {
            int sub_res = memo[i - coins[j]];
            if (sub_res != Integer.MAX_VALUE
                && sub_res + 1 < memo[i])
              memo[i] = sub_res + 1;

          }
        }
      }

      return memo[sum];
    }
}
