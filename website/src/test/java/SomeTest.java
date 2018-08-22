import com.alibaba.fastjson.JSONObject;
import com.xk.p2p.base.domain.Logininfo;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/6/21.
 */
public class SomeTest {

    @Test
    public void testStartWith(){
       // String a = "89860012016040000001";
       // String startStr = "898600120";
       // System.out.println(a.substring(startStr.length(),a.length()));
        StringBuilder sb = new StringBuilder();
        sb.append("a").append(",").append("b").append(",");
        System.out.println(sb.substring(0,sb.length()-1));
    }

    @Test
    public void testIndexOf(){
        String a = "补差价-北京地区顺丰顺丰顺丰顺丰顺丰顺丰";
        System.out.println(a.indexOf("顺丰"));
    }

    @Test
    public void test(){
//        String a = new String();
//        System.out.println(a == null);
        JSONObject object = new JSONObject();
        Logininfo info = new Logininfo();
        object.put("a",info);
        System.out.println(object.toString());
        info.setUsername("xxx");
        info.setPassword("bbb");
        object.put("a",info);
        System.out.println(object.toString());
    }

    @Test
    public void test1(){
        Map<String,Object> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        System.out.println(map.containsKey("1"));
    }

}
