package DSA_practice.twoPointers;

public class containerwithMostwater {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {

        // Left pointer starts at the first index
        int left = 0;

        // Right pointer starts at the last index
        int right = height.length - 1;

        // Stores the maximum water area found so far
        int maxWater = 0;

        // Keep looping until both pointers meet each other
        // Once left == right, we have checked all possible containers
        while (left < right) {

            // Calculate the width between the two pointers
            // As pointers move inward, width keeps decreasing
            int width = right - left;

            // The water level is limited by the SHORTER wall
            // Taller wall is useless beyond the shorter wall's height
            // because water spills over the shorter side
            int currentHeight = Math.min(height[left], height[right]);

            // Area of water = width × height
            int currentArea = width * currentHeight;

            // Update maxWater if the current container holds more water
            maxWater = Math.max(maxWater, currentArea);

            // KEY DECISION — which pointer to move inward?
            // Moving the taller pointer inward:
            //   → width decreases AND height can't improve (still capped by shorter wall)
            //   → area can only stay same or get worse → pointless move
            // Moving the shorter pointer inward:
            //   → width decreases BUT we might find a taller wall
            //   → only hope of finding a bigger area
            // So ALWAYS move the shorter pointer inward
            if (height[left] < height[right]) {

                // Left wall is shorter, move left pointer to the right
                // hoping to find a taller wall on the left side
                left++;

            } else {

                // Right wall is shorter (or both are equal height),
                // move right pointer to the left
                // hoping to find a taller wall on the right side
                right--;

            }
        }

        // Return the maximum water area found
        return maxWater;
    }
}
