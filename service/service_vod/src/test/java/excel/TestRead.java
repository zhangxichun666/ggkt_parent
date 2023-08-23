package excel;

import com.alibaba.excel.EasyExcel;

/**
 * @ClassName TestRead
 * @Description
 * @Author LENOVO
 * @Date 2023/8/23 7:54
 * @Version 1.0
 */
public class TestRead {
    public static void main(String[] args) {
        //路径设置
        String fileName = "D:\\xxx.xlsx";
        //调用方法进行读操作
        EasyExcel.read(fileName, User.class,new ExcelListener()).sheet().doRead();
    }
}
