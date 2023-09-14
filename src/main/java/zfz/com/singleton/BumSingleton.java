package zfz.com.singleton;

/***
 * 懒汉式单例模式
 * @Author zhufanzhi
 * @Date 2023/9/14
 * @Description 
 * @Since version-1.0
 */

public class BumSingleton {
    private static  BumSingleton bumSingleton =new BumSingleton();

    private BumSingleton(){
        // 防止实例化
        System.out.println("创建了一个实例");
    }

    public  static BumSingleton getInstance() {
        return bumSingleton;
    }
}
