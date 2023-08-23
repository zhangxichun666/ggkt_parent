package excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestWrite
 * @Description
 * @Author LENOVO
 * @Date 2023/8/23 7:40
 * @Version 1.0
 */
public class TestWrite {
    public static void main(String[] args) {
        String fileName = "D:\\xxx.xlsx";
        //调用方法
        EasyExcel.write(fileName, User.class)
                .sheet("写操作")
                .doWrite(data());
    }

    //循环设置要添加的数据，最终封装到list集合中
    private static List<User> data() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("lucy"+i);
            list.add(user);
        }
        return list;
    }
}
