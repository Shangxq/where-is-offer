package chapter2;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/16
 */
public class Problem02 {
    private Problem02 singleton = null;

    private Problem02() {
    }
    public Problem02 getSingleton(){
        if(singleton==null){
            synchronized (Problem02.class){
                if(singleton==null){
                    singleton = new Problem02();
                }
            }
        }
        return singleton;
    }
}
