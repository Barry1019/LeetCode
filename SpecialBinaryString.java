import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @Author: your name
 * @Date: 2020-12-04 10:45:54
 * @LastEditTime: 2020-12-04 11:00:25
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class SpecialBinaryString {
     
 }
 
 * @FilePath: /MCI/Users/barrykahn/Career/SpecialBinaryString.java
 */
/**
 * SpecialBinaryString
 */
public class SpecialBinaryString {

    public String makeLargestSpecial(String S){
        StringBuilder sb = new StringBuilder() ;
        List<String> list = new ArrayList<>() ;

        int start = 0 ;
        int countOne = 0 ;

        for ( int i = 0 ; i < S.length() ; ++i ) {
            countOne += S.charAt(i) == '1' ? 1 : -1 ;
            if ( countOne == 0 ) {
                String temp = S.substring(start + 1, i) ;
                list.add("1" + makeLargestSpecial(temp) + "0") ;
                start = i + 1 ;
            }
        }

        Collections.sort(list) ;
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)) ;
        }

        return sb.toString() ;
    }
}