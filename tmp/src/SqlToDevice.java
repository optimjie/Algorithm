import javafx.util.Pair;

import java.io.*;

public class SqlToDevice {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\code\\idea-project\\algorithm\\tmp\\src\\SqlToDeviceData.txt");
        FileReader f = null;  // 文件读取对象
        BufferedReader f1 = null;  // 字符流对象

        String[] s = new String[]{"id","status" ,"name" ,"manufacturer" ,"location" ,"category" ,"model" ,
                "range" ,"accuracy" ,"serialNumber", "principal" ,"activationDate",
                "inspectionDate" ,"verificationCategory", "certificateNumber" ,"verificationDate" ,
                "verificationPeriod", "effectiveDate" ,"verifier", "shipId" ,"glbq", "jybq" , "jybg", "abc" ,"menuId"};


        try {
            f = new FileReader(file);
            f1 = new BufferedReader(f);
            String str = null;

            while ((str = f1.readLine()) != null) {
                str = str.substring(0, str.length() - 2);
                String[] strs = str.split(",");
                String res = "Device(";
                for (int i = 0; i < strs.length; i++) {
                    String v = strs[i];
                    v = v.trim();
                    if (i > 0 && !v.equals("NULL") && v.charAt(0) != '\'') {
                        v = "'" + v + "'";
                    }
                    if (i > 0 && v.equals(("NULL"))) {
                        v = "''";
                    }
                    if (i == 0) {
                        res = res + s[i] + ": " + v;
                    } else {
                        res = res + ", " + s[i] + ": " + v;
                    }
                }
                res = res + "),";
                System.out.println(res);
            }


        } catch (Exception e) {

        } finally {
            try {
                f1.close();
                f.close();
            } catch (Exception e2) {

            }
        }
    }


}
