/*
 * @Author: your name
 * @Date: 2020-12-03 17:08:16
 * @LastEditTime: 2020-12-03 17:15:24
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /MCI/Users/barrykahn/Career/InsertionSort.java
 */
public class InsertionSort {
    public int[] sort(int[] source) {
        int n = source.length ;

        for ( int i = 1 ; i < n ; i ++ ) {
            int key = source[i] ;
            int j = i - 1 ;

            while ( j >= 0 && source[j] > key) {
                source[j+1] = source[j] ;
                j -- ;
            }

            source[j+1] = key ;
        }

        return source ;
    }
}