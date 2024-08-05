// Time - Nlog(n)
//Space -O(N)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a max-heap (priority queue) with custom comparator to maintain the largest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Initialize result to store the kth largest element, initially set to the maximum possible integer value
        int result = Integer.MAX_VALUE;

        // Iterate through each element in the nums array
        for (int i : nums) {
            // Add the current element to the max-heap
            maxHeap.add(i);

            // If the size of the max-heap exceeds nums.length - k, maintain the kth largest element
            if (maxHeap.size() > nums.length - k) {
                // Update result with the smallest value seen so far in the range of the kth largest elements
                result = Math.min(result, maxHeap.poll());
            }
        }

        // The result variable holds the kth largest element after processing all elements
        return result;
    }
}
