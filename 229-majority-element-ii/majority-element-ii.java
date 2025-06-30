// Optimized Solution (Boyer-Moore Voting Algorithm for n/3 Majority)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // There can be at most 2 elements > n/3 times
        Integer cand1 = null, cand2 = null;
        int count1 = 0, count2 = 0;
        // First pass: find potential candidates
        for (int num : nums) {
            if (cand1 != null && num == cand1) {
                count1++;
            } else if (cand2 != null && num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // Second pass: verify if candidates appear > n/3 times
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (cand1 != null && num == cand1) count1++;
            else if (cand2 != null && num == cand2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(cand1);
        if (count2 > threshold) result.add(cand2);
        return result;
    }
}