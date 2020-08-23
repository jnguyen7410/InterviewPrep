// [ ]
// [-1,0,10]
// [1,|1|,2] => [1,2,|2]
// [0,|0|,1,1,1,2,2,3,3,4]
//  0  1  2 3 4 5 6 7 8 9
// [0,1,2,3,4,5,6,7,|7|,7,7,8,10]

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev = nums[0]; //0
        int replacementIndex = 1; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev && i == replacementIndex) {
                replacementIndex++;
                prev = nums[i];
                continue;
            }
            else if (nums[i] == prev) {
                continue;
            } else if (nums[i] != prev && i != replacementIndex) {
                nums[replacementIndex] = nums[i];
                replacementIndex++;
                prev = nums[i];
            }
        }
        
        return replacementIndex;
    }
}