import model.dao.RelatorioDao;

public class FileWriteTest {

    public static void main(String[] args) {
        RelatorioDao relatorioDao = new RelatorioDao();
        System.out.println(relatorioDao.getSaldoAnterior());

        //relatorioDao.getEntradaDias("2020-02-13","2020-10-10");
    }

}
