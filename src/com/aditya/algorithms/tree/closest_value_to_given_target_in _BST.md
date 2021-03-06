Given a BST and a target value. Find the closest value to given target in BST.

> Initialise a global variable closestNum with infinity </br>
> If (target - closestNum) > (target-currNode.val) then closestNum=currNode.val </br>
> If target < currNode.val then search in left subtree  else  if target > currNode.val then search in rst else return closest.

Java Impl
```java

public class Solution {
    // Average: O(log(n)) time | O(log(n)) space
    // Worst: O(n) time | O(n) space

    public static int findClosestValueInBstRecursive(BST tree, int target) {

        return findClosestValueInBstHelper(tree, target, Double.MAX_VALUE);
    }

    public static int findClosestValueInBstHelper(BST tree, int target, double closest) {

        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {

            closest = tree.value;

        }

        if (target < tree.value && tree.left != null) {

            return findClosestValueInBstHelper(tree.left, target, closest);

        } else if (target > tree.value && tree.right != null) {

            return findClosestValueInBstHelper(tree.right, target, closest);

        } else {
            return (int) closest;
        }
    }

    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space

    public static int findClosestValueInBstItr(BST tree, int target) {

        return findClosestValueInBstItr(tree, target, Double.MAX_VALUE);
    }

    private static int findClosestValueInBstItr(BST tree, int target, double closest) {

        BST currentNode = tree;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
                closest = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }

        }
        return (int) closest;
    }

    static class BST {

        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;

        }
    }

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.left.left = new BST(2);
        tree.left.left.left = new BST(1);
        tree.left.right = new BST(5);
        tree.right = new BST(15);
        tree.right.left = new BST(13);
        tree.right.left.right = new BST(14);
        tree.right.right = new BST(22);

        System.out.println("Closest Value :" + findClosestValueInBstItr(tree, 12));

    }
}

```

C++ Impl
```cpp
#include <iostream>
#include <cmath>
#include <float.h>
using namespace std;
class BST
{
public:
    int value = 0;
    BST *left;
    BST *right;

    BST(int val)
    {
        value = val;
        left = right = nullptr;
    }
};

int findClosestValueInBstRecur(BST *tree, int target);
int findClosestValueInBstItr(BST *tree, int target);
int findClosestValueInBstRecurHelper(BST *tree, int target, double closest);
int findClosestValueInBstItrHelper(BST *tree, int target, double closest);

// Average: O(log(n)) time | O(log(n)) space
// Worst: O(n) time | O(n) space
int findClosestValueInBstRecur(BST *tree, int target)
{
    return findClosestValueInBstRecurHelper(tree, target, DBL_MAX);
}
int findClosestValueInBstRecurHelper(BST *tree, int target, double closest)
{
    if (abs(target - closest) > abs(target - tree->value))
    {
        closest = tree->value;
    }
    if (target < tree->value && tree->left != NULL)
    {
        return findClosestValueInBstRecurHelper(tree->left, target, closest);
    }
    else if (target > tree->value && tree->right != NULL)
    {
        return findClosestValueInBstRecurHelper(tree->right, target, closest);
    }
    else
    {
        return closest;
    }
}

// Average: O(log(n)) time | O(1) space
// Worst: O(n) time | O(1) space
int findClosestValueInBstItr(BST *tree, int target)
{
    return findClosestValueInBstItrHelper(tree, target, DBL_MAX);
}
int findClosestValueInBstItrHelper(BST *tree, int target, double closest)
{
    BST *currentNode = tree;
    while (currentNode != NULL)
    {
        if (abs(target - closest) > abs(target - currentNode->value))
        {
            closest = currentNode->value;
        }
        if (target < currentNode->value)
        {
            currentNode = currentNode->left;
        }
        else if (target > currentNode->value)
        {
            currentNode = currentNode->right;
        }
        else
        {
            break;
        }
    }
    return closest;
}

int main()
{
    BST *root = new BST(10);
    root->left = new BST(5);
    root->left->left = new BST(2);
    root->left->left->left = new BST(1);
    root->left->right = new BST(5);
    root->right = new BST(15);
    root->right->left = new BST(13);
    root->right->left->right = new BST(14);
    root->right->right = new BST(22);

    cout << "Closest Val ITR: " << findClosestValueInBstItr(root, 12) << endl;
}

```
