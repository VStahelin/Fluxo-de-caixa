import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("Escrevendo");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
