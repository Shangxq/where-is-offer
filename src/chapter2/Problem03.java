package chapter2;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/16
 */
public class Problem03 {
    public int findRepeatNumber(int[] nums) {
        if(nums==null) return -1;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            while(val!=i){
                if(nums[val]==val){
                    return val;
                }
                int temp = nums[val];
                nums[val] = val;
                val = temp;
            }
        }
        return -1;
    }
    
}
