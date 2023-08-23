package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Author LENOVO
 * @Date 2023/8/23 7:38
 * @Version 1.0
 */
@Data
public class User {
    @ExcelProperty(value = "用户编号",index = 0)
    private int id;

    @ExcelProperty(value = "用户名称",index = 1)
    private String name;
}
