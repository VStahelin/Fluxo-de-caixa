package layouts.relatorio;

public class Dates {
    public String getDataAtual(){
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String data = date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
        return data;
    }
}
