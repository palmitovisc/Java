import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class leituraArquivo{
    public static void main(String[] args) {
        try{
        InputStream inputStream = new FileInputStream("c:\\temp\\teste.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        
        String linha = null;
        while((linha = bufferedReader.readLine()) != null){
            System.out.println(linha);
        }
        bufferedReader.close();

        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
