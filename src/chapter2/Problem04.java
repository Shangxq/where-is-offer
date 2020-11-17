package chapter2;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/17
 */
public class Problem04 {
    public boolean findNumber(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length&&col>=0){
            int val= matrix[row][col];
            if(val==target) return true;
            else if(val<target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
