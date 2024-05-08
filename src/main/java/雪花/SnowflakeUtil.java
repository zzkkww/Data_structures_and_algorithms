package 雪花;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import xyz.downgoon.snowflake.Snowflake;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @author Kevin
 * @date 2024-02-21
 **/
public class SnowflakeUtil {

    private static Snowflake snowflake;

    static {
        Long workerId = getWorkId();
        Long datacenterId = getDatacenterId();
        snowflake = new Snowflake(datacenterId, workerId);
    }

    /**
     * 生成雪花算法ID
     * generateId
     * @return
     */
    public static long genId() {
        return snowflake.nextId();
    }

    private static Long getWorkId(){
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            int[] ints = StringUtils.toCodePoints(hostAddress);
            int sums = 0;
            for(int b : ints){
                sums += b;
            }
            return (long)(sums % 32);
        } catch (UnknownHostException e) {
            // 如果获取失败，则使用随机数备用
            return RandomUtils.nextLong(0,31);
        }
    }

    private static Long getDatacenterId(){
        int[] ints = StringUtils.toCodePoints(SystemUtils.getHostName());
        System.out.println(ints);
        int sums = 0;
        for (int i: ints) {
            sums += i;
        }
        return (long)(sums % 32);
    }

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
//        System.out.println(System.getenv("COMPUTERNAME"));
//        System.out.println(System.getenv("HOSTNAME"));
        System.out.println(SystemUtils.getHostName());

        System.out.println(SnowflakeUtil.genId());

    }

}

