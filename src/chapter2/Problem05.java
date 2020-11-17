package chapter2;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/17
 */
public class Problem05 {
    public String replaceSpace(String s) {
        if(s==null) return null;
        char[] cs = s.toCharArray();
        int length = cs.length;
        for(char c:cs)
            if(c==' ')length+=2;
        char[] csn = new char[length];
        int index = 0;
        for(char c:cs){
            if(c== ' '){
                csn[index++]='%';
                csn[index++]='2';
                csn[index++]='0';
            }else{
                csn[index++]=c;
            }
        }
        return new String(csn);
    }
}
