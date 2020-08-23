// https://leetcode.com/problems/non-overlapping-intervals/
import java.util.ArrayList;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<int[]> previousIntervals = new ArrayList<>();
        previousIntervals.add(intervals[0]);
        int removed = 0;
        for (int[] interval : intervals) {
            ListIterator<int[]> iterator = previousIntervals.listIterator();
            while (iterator.hasNext()) {
                int[] previousInterval = iterator.next();
                if (previousInterval == interval) {
                    removed++;
                    break;
                }
                else if (previousInterval[1] <= interval[0] 
                    || previousInterval[0] >= interval[1]
                    || interval[1] <= previousInterval[0] 
                    || interval[0] >= previousInterval[1]) {
                    //not overlapping
                    previousIntervals.add(interval);
                }
            }
        }
        
        return removed;
    }
}

/*
// ------------------------------------------
        +---------|------+=========| // check this later

// [[1,3],[0,5],[3,4],[1,2],[2,3]]

// [[1,10], [2,3], [3,4], [4,5], [5,8]]

// [[-100, 49058732905]]

// [0,1] [1,2]  [2,3]

// if right num (prev) <= left num (new) => okay (AND?)
// if left num (prev) >= right num (new) => okay
// if whole range (prev) == whole range (new) => dupe
// if left num (prev) == left num (new) => overlapping
// if left num (prev) == left num (new)
// AND right num (prev) != right num (new) => overlapping
// if right num (prev) == right num (new)
// AND left num (prev) != left num (new) => overlapping
// if left num (prev) < left num(new) 
// AND right num (prev) > right num (new) => overlap (major)

    
// detect an overlap (across all ranges)
// determine which overlap to remove (bigger difference)

// O(1) access time => Set,  Map
*/