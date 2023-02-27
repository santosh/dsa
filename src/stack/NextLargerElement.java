package stack;

import java.util.Arrays;

/*
Given an array arr of size n. Your task is to find the next larger element for each element in an array arr[i]. If no next larger element exist then return -1.

A next larger element for an element i is the first larger element to the right of i.


Example 1:

Input:
n = 4
arr = [1, 3, 2, 4]

Output:
[3, 4, 4, -1]

Explanation:
The next larger element for 1 is 3, and for 3 and 2 is 4. For element 4 there is no next larger element so it is -1.

Example 2:

Input:
n = 6
arr = [1, 1, 1, 1, 1, 1]

Output:
[-1, -1, -1, -1, -1, -1]

Explanation:
All the elements in the array have same value 1 so there is no next larger element. So the result will have -1 in all the position.
*/
class NextLargerElement {
    public static int[] nextLargerElement(int[] arr) {
        int[] result = new int[arr.length];
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String args[]) {
        int[] arr = {1, 3, 2, 4};
        int[] result = nextLargerElement(arr);
        System.out.println(Arrays.toString(result));
    }
}
