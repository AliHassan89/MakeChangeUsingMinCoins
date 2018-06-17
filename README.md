# MakeChangeUsingMinCoins
You are given an array of coins and an interger k. Return min number of coins to make value k.

Given an array of integers as coins and a number k. Return minimum number of
coins that can be used to make k. You may consider that coins will always have
1 cent in there so that there will be no such case that the combination is 
not possible.

# Solution:

1. We will receive and array of coins and an integer sum

2. We will initialize a memo table of length sum+1. That is because in the end we will have result in memo[sum]

3. Initialize memo array with Integer.MAX_VALUE. Since we are interested in min number of coins we are initializing with max value of integer.

4. We will be using bottom up approach that means we will first calculate min number of ways to make 1 coin, followed by 2 coins, 3 coins etc until we reach sum.

5. In this case we know that to achieve 0 sum we need 0 coins. This memo[0] = 0.

6. Then we will start a loop from 1 to sum+1. Followed this loop we need to take one coin from the array of coins and subtract from i until we reach 0.

7. Thus we will have a nested loop starting from 0 to end of coins array.

8. In this loop we are going to check if the coin value is less than or equal to i value then we will take the previously calculated value from memo table 
int sub_res = memo[i - coins[j]];

9. Lastly we will do this
if (sub_res != Integer.MAX_VALUE
	&& sub_res + 1 < memo[i])
	  memo[i] = sub_res + 1;
