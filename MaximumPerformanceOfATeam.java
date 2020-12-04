import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @Author: your name
 * @Date: 2020-12-04 13:29:54
 * @LastEditTime: 2020-12-04 14:09:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /MCI/Users/barrykahn/Career/MaximumPerformanceOfATeam.java
 */
/**
 * MaximumPerformanceOfATeam
 */
public class MaximumPerformanceOfATeam {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // to store the members' info
        int[][] members = new int[n][2] ;
        
        // get a working copy
        for (int i = 0; i < n; i++) {
            members[i][0] = speed[i] ;
            members[i][1] = efficiency[i] ;
        }

        // sort the item by descending order of efficiency
        Arrays.sort(members, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1] - a[1] ;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>() ;
        long res = 0, sum = 0 ;
        for (int i = 0; i < n; i++) {
            if ( queue.size() > k - 1 ) {
                sum -= queue.poll() ;
            }
            res = Math.max(res, (sum + members[i][0]) * members[i][1]) ;

            // make sure the sum stores the members with current maximum speeds
            queue.add(members[i][0]) ;
            sum += members[i][0] ;
        }

        return (int)(res % ((int)1e9 + 7)) ;
    }
}