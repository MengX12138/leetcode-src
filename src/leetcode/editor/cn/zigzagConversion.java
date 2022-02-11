//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1446 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class zigzagConversion{
    //2022-01-19 16:46:33
    //Z 字形变换
    //编号：[6]
    
    public static void main(String[] args) {
        Solution solution = new zigzagConversion().new Solution();
        // TO TEST
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        //当s的长度小于行数时，直接返回s
        //当行数为1时，也直接返回s
        if (s.length() < numRows || numRows == 1){
            return s;
        }
        int segment = 2 * numRows - 2;
        StringBuilder target = new StringBuilder(s.length());
        // 输出头
        for (int i = 0; i * segment < s.length(); i++){
            target.append(s.charAt(i * segment));
        }
        // 输出体
        for (int i = 0; i < numRows - 2; i++){
            for (int j = 0; j * segment  + i + 1 < s.length(); j++ ){
                // 输出一段的第一列
                target.append(s.charAt(j * segment + i + 1));
                // 输出一段的第二列，首先要判断第二列对应位置是否有元素，也就是索引不能超过s的长度
                if (j * segment + (segment - i - 1) < s.length()){
                    target.append(s.charAt(j * segment + (segment - i - 1)));
                }
            }
        }
        // 输出尾
        for (int i = 0; i * segment + numRows - 1 < s.length(); i++){
            target.append(s.charAt(i * segment + numRows - 1));
        }
        return target.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}