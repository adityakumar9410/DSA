Given an array of integers and a target number. Find Two number in array whose sum is target.

C++ Impl.
```cpp
#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>
using namespace std;
// O(n^2) time | O(1) space  || Using Two for loop
vector<int> twoNumberSum(vector<int> array, int targetSum)
{
    for (int i = 0; i < array.size() - 1; i++)
    {
        int firstNum = array[i];
        for (int j = i + 1; j < array.size(); j++)
        {
            int secondNum = array[j];
            if (firstNum + secondNum == targetSum)
            {
                return vector<int>{firstNum, secondNum};
            }
        }
    }
    return {};
}

// O(nlog(n)) | O(1) space || Sorting and then two pointer
vector<int> twoNumberSumSorting(vector<int> array, int targetSum)
{
    sort(array.begin(), array.end());
    int left = 0;
    int right = array.size() - 1;
    while (left < right)
    {
        int currentSum = array[left] + array[right];
        if (currentSum == targetSum)
        {
            return {array[left], array[right]};
        }
        else if (currentSum < targetSum)
        {
            left++;
        }
        else if (currentSum > targetSum)
        {
            right--;
        }
    }
    return {};
}

// O(n) time | O(n) space  || Hashing
vector<int> twoNumberSumHashing(vector<int> array, int targetSum)
{
    unordered_set<int> nums;
    for (int num : array)
    {
        int potentialMatch = targetSum - num;
        if (nums.find(potentialMatch) != nums.end())
        {
            return vector<int>{potentialMatch, num};
        }
        else
        {
            nums.insert(num);
        }
    }
    return {};
}

int main()
{
    vector<int> arr{1, 2, 8, 5, 3};
    auto res = twoNumberSumSorting(arr, 11);
    cout << res[0] << "," << res[1] << endl;
}
```
Java Impl
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSum {

    // O(n^2) time | O(1) space || Using Two for loop
    public static List<Integer> twoNumberSum(List<Integer> array, int target) {
        for (int i = 0; i < array.size() - 1; i++) {
            int firstNum = array.get(i);
            for (int j = i + 1; j < array.size(); j++) {
                int secondNum = array.get(j);
                if (firstNum + secondNum == target) {
                    return new ArrayList<>(Arrays.asList(firstNum, secondNum));
                }
            }
        }
        return new ArrayList<>();
    }

    // O(nlog(n)) | O(1) space
    public static int[] twoNumberSumSorting(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum) {
                return new int[] { array[left], array[right] };
            } else if (currentSum < targetSum) {
                left++;
            } else if (currentSum > targetSum) {
                right--;
            }
        }
        return new int[0];
    }

    // O(n) time | O(n) space || Hashing
    public static List<Integer> twoNumberSumHashing(List<Integer> array, Integer target) {
        Set<Integer> seen = new HashSet<>();

        for (Integer num : array) {
            Integer potentialMatch = target - num;
            if (seen.contains(potentialMatch)) {
                return new ArrayList<>(Arrays.asList(potentialMatch, num));
            } else {
                seen.add(num);
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 8));
        List<Integer> result = twoNumberSumHashing(nums, 9);
        System.out.println(result.get(0) + ", " + result.get(1));

        int[] arr = new int[] { 1, 3, 6, 8, 2 };
        int[] res = twoNumberSumSorting(arr, 9);
        System.out.println(res[0] + ", " + res[1]);
    }
}
```
