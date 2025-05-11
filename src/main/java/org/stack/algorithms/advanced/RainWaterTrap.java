package org.stack.algorithms.advanced;

public class RainWaterTrap {
    public static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, leftMax = 0, rightMax = 0, total = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right];
                right--;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Water: " + trap(height)); // Output: 6
    }
}
