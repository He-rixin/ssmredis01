import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import redis.clients.jedis.Jedis;

/**
 * @author herixin
 * @create 2022-12-09 15:01
 */
public class test {
    public static void main(String[] args) {
        System.out.println("ssfsaf   ");
//1.读取加载shiro.ini配置文件
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
//2.创建SecurityManager安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        //3.将SecurityManager委托给SecurityUtils管理
        SecurityUtils.setSecurityManager( securityManager);
        //4.获取主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zs", "123");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
        }
    }

    public static void main1(String[] args) {
        String ip = "192.168.230.128";
        Integer port = 6379;
        Jedis jedis = new Jedis(ip, port);
        jedis.auth("123456");//权限认证
        jedis.ping();
        jedis.select(0);//切换数据库
        System.out.println(jedis.ping());
    }
}
