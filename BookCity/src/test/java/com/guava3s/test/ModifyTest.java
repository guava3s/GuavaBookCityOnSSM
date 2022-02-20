package com.guava3s.test;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author micolen
 * @version 1.0
 * @ClassName com.guava3s.test.ModifyTest
 * @date 2021/11/25 20:17
 */
public class ModifyTest {

    Map<String, String> map = new HashMap<>(50);


    /**
     * 生成SQL语句
     *
     * @throws Exception
     */
    @Test
    public void createInsertSQLFile() throws Exception {

        String path2 = "static/img/book/";
        List<String> list = new ArrayList<>();
        String name;
        for (int i = 1; i <= 15; i++) {
            name = "罗马人的故事 (" + i + ").jpg";
            String location = path2 + name;
            String path = "insert into book(title,author,price,sales,stock,img_path) value('" + name + "','盐野七生',33.47,140,100,'" + location + "');";
            list.add(path);
        }

        String location = "F:\\SQLStatement\\insert.sql";
        createSQL(list, location);

    }

    @Test
    public void createUpdateSQLFile() throws IOException {
        String path2 = "static/img/book/";
        List<String> list = new ArrayList<>();


        recursion(new File("F:\\Project_Java\\Project_IntelliJ IDAE\\GuavaBookCityOnSSM\\BookCity\\src\\main\\webapp\\static\\img\\book"));
        for (Map.Entry<String, String> m : map.entrySet()) {
            String sql = "update book set img_path = '" + path2 + m.getValue() + "' where title ='" + m.getValue().substring(0, m.getValue().lastIndexOf("."))+"';";
            list.add(sql);
        }

        String location = "F:\\SQLStatement\\batchUpdate.sql";
        createSQL(list, location);
    }


    /**
     * @param list     每一行内容
     * @param filePath 生成的目标文件路径
     */
    private void createSQL(List<String> list, String filePath) throws IOException {
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(filePath));
        for (String line : list) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }


    public void recursion(File f) {
        File[] files = f.listFiles();
        for (File ff : files) {
            if (ff.isDirectory()) {
                recursion(ff);
            } else {
                map.put(ff.getPath(), ff.getName());
            }
        }
    }

    public void append() {

    }
}
