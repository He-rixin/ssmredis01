import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
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
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager( securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zs", "123");
        subject.login(token);
        if (subject.isPermittedAll("delete")) {
            System.out.println("有");
        } else {
            System.out.println("没有");
        }
    }
    public static void main3(String[] args) {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-role.ini");
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager( securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("ls", "123");
        subject.login(token);
        if (subject.hasRole("role1")) {
            System.out.println("正常访问");
        } else {
            System.out.println("没有权限");
        }
    }
    public static void main2(String[] args) {
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
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("账号不存在");
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
