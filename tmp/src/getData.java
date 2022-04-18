import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class getData {

    public static void main(String[] args) {
        File file = new File("D:\\code\\idea-project\\algorithm\\tmp\\src\\1.txt");
        FileReader f = null;  // 文件读取对象
        BufferedReader f1 = null;  // 字符流对象

        int lineCnt = 0;

        try {
            f = new FileReader(file);
            f1 = new BufferedReader(f);
            String str = null;
            int k = 0;
            int cnt = 0;
            while ((str = f1.readLine()) != null) {
                lineCnt++;
            }

        } catch (Exception e) {

        } finally {
            try {
                f1.close();
                f.close();
            } catch (Exception e2) {

            }
        }

        System.out.println("行数：" + lineCnt);

        try {
            f = new FileReader(file);
            f1 = new BufferedReader(f);
            String str = null;
            int k = lineCnt / 10;
            int cnt = 0;
            int i = 0;
            while (cnt < 10 &&(str = f1.readLine()) != null) {
                i++;
                if (i == 1 || i % k == 0) {
                    cnt++;
                    System.out.println(str);
                }
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
