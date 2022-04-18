public class test {
    public static void main(String[] args) {
        String s = new String("SELECT tb1.job, first_year_month, first_year_cnt, second_year_month, second_year_cnt FROM (\n" +
                "\tSELECT job, DATE_FORMAT(date,'%Y-%m') as first_year_month, SUM(num) AS first_year_cnt\n" +
                "\tFROM resume_info \n" +
                "\tWHERE date BETWEEN '2025-01-01' AND '2025-12-31'\n" +
                "\tGROUP BY first_year_month, job\n" +
                "\tORDER BY first_year_month DESC, job DESC\n" +
                ") tb1 INNER JOIN (\n" +
                "\tSELECT job, DATE_FORMAT(date,'%Y-%m') as second_year_month, SUM(num) AS second_year_cnt\n" +
                "\tFROM resume_info \n" +
                "\tWHERE date BETWEEN '2026-01-01' AND '2026-12-31'\n" +
                "\tGROUP BY second_year_month, job\n" +
                "\tORDER BY second_year_month DESC, job DESC\n" +
                ") tb2\n" +
                "ON (SUBSTR(tb2.second_year_month FROM 3 FOR 2) - SUBSTR(tb1.first_year_month FROM 3 FOR 2)) = 1\n" +
                "\tAND SUBSTR(tb2.second_year_month FROM 6 FOR 2) = SUBSTR(tb1.first_year_month FROM 6 FOR 2)\n" +
                "\tAND tb1.job = tb2.job");
        String ans = "";
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            ans = ans + c;
        }
        System.out.println(ans);
    }
}
