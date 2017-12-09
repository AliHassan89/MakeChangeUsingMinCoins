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
        System.out.println(makeMinimumChange(6, arr));
    }
    
    public static int makeMinimumChange(int amount, int[] arr)
    {
        if (arr.length == 0)
            return 0;
            
        int minChange = Integer.MAX_VALUE;
        int index = arr.length-1;
        for (int i=index; i>= 0; i--)
        {
            int change = makeMinimumChangeUtil(amount, arr, i, 0);
            minChange = Math.min(minChange, change);
        }
        
        return minChange;
    }
    
    private static int makeMinimumChangeUtil(int amount, int[] arr, int index, int coinCount)
    {
        if (amount == 0 || index<0)
        {
            return coinCount;
        }
        
        int leftOver = amount - arr[index];
        
        if (leftOver == 0)
        {
            return ++coinCount;
        }
        
        else if (leftOver < 0)
        {
            coinCount = makeMinimumChangeUtil(amount, arr, --index, coinCount);
        }
        else
        {
            ++coinCount;
            coinCount = makeMinimumChangeUtil(leftOver, arr, index, coinCount);
        }
        
        return coinCount;
    }
    
}
