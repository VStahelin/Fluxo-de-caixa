package WriterReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Write {
    public void Write(List list,Boolean isAppend){
        if (isAppend == true){
            File file = new File("Arquivo.txt");
            try {
                FileWriter fw = new FileWriter(file,true);
                fw.write(String.valueOf(list)+"\n");
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            File file = new File("Arquivo.txt");
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(String.valueOf(list)+"\n");
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
