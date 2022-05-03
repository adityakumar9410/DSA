Given a binary tree . Find sum of each branch form root to leaf.

Java Impl
```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Time: O(n) | Space: O(n)
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        return branchSums(root, 0, sums);
    }

    private static List<Integer> branchSums(BinaryTree root, int sum, List<Integer> sumsList) {
        if (root == null) {
            return sumsList;
        }
        // sum = sum + root.value
        sum += root.value;
        if (root.left == null && root.right == null) {
            // Then we've hit a leaf node
            sumsList.add(sum);
        }
        if (root.left != null) {
            branchSums(root.left, sum, sumsList);
        }
        if (root.right != null) {
            branchSums(root.right, sum, sumsList);
        }
        // When everything's done, return sumsList
        return sumsList;

    }

    static class BinaryTree {

        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;

        }
    }

    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(5);
        root.left.left = new BinaryTree(2);
        root.left.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(15);
        root.right.left = new BinaryTree(13);
        root.right.left.right = new BinaryTree(14);
        root.right.right = new BinaryTree(22);

        List<Integer> res = branchSums(root);
        System.out.println(res);
    }
}
```

C++ Impl
```cpp

#include <iostream>
#include <vector>
using namespace std;

class BinaryTree
{
public:
    int value;
    BinaryTree *left;
    BinaryTree *right;
    BinaryTree(int value)
    {
        this->value = value;
        left = nullptr;
        right = nullptr;
    }
};

vector<int> branchSums(BinaryTree *root);
void calculateBranchSums(BinaryTree *node, int runningSum, vector<int> &sums);
// O(n) time | O(n) space - where n is the number of nodes in the Bina

vector<int> branchSums(BinaryTree *root)
{
    vector<int> sums;
    calculateBranchSums(root, 0, sums);
    return sums;
}

void calculateBranchSums(BinaryTree *node, int runningSum, vector<int> &sums)
{
    if (node == nullptr)
        return;
    runningSum = runningSum + node->value;
    if (node->left == nullptr && node->right == nullptr)
    {
        sums.push_back(runningSum);
        return;
    }

    calculateBranchSums(node->left, runningSum, sums);
    calculateBranchSums(node->right, runningSum, sums);
}

int main()
{
    BinaryTree *root = new BinaryTree(10);
    root->left = new BinaryTree(5);
    root->left->left = new BinaryTree(2);
    root->left->left->left = new BinaryTree(1);
    root->left->right = new BinaryTree(5);
    root->right = new BinaryTree(15);
    root->right->left = new BinaryTree(13);
    root->right->left->right = new BinaryTree(14);
    root->right->right = new BinaryTree(22);
    vector<int> res = branchSums(root);

    for (int i = 0; i < res.size(); i++)
    {
        cout << res[i] << endl;
    }
}
```
