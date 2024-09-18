import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class escritaArquivo {
    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream("saida.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            try {
                bufferedWriter.write("testando escrita");
                bufferedWriter.newLine();
                bufferedWriter.write("testando escrita");
                bufferedWriter.newLine();
                bufferedWriter.write("testando escrita");
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
