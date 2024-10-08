
import java.util.Collections;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
public class Funcoes {
    ArrayList<String>  nomes = new ArrayList<String>();

    public String Inverter(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
        Collections.reverse(nomes);
        return nomes.stream().collect(Collectors.joining("\n"));
    }

    public String organizaZ_A(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
        Collections.sort(nomes);
        Collections.reverse(nomes);
        return nomes.stream().collect(Collectors.joining("\n"));
}

    public String organizaA_Z(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
            String[] arrayNomes = texto.split("\n");
            mergeSort(arrayNomes);

            nomes.clear();
            nomes.addAll(Arrays.asList(arrayNomes));

            return nomes.stream().collect(Collectors.joining("\n"));
    }
    private void mergeSort(String[] array){
        if(array.length < 2){
            return;
        }
        int mid = array.length/2;
        String[] left = new String[mid];
        String[] right = new String[array.length - mid];

        System.arraycopy(array,0 , left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        
        mergeSort(left);
        mergeSort(right);
        mergeA_Z(array, left, right);
        
    }

    private void mergeA_Z(String[] array, String[] left, String[] right){
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length ){
            if(left[i].compareToIgnoreCase(right[j])<=0){
                array[k++] = left[i++];
            }
            else{
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
    //quando isso ocorre nao deixa vazios
     public String removerDuplicados(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
        return nomes.stream().distinct().collect(Collectors.joining("\n"));
    }
    //problema com quebra de linhas em branco
    public String removerVazios(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
        
        return nomes.stream().filter(linha -> !linha.trim().isEmpty()).collect(Collectors.joining("\n"));
    }
    //pode usar o metodo trim fornecido pelo java?
    public String trim(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
        return nomes.stream().map(String::trim).collect(Collectors.joining("\n"));
    }
    
    public String Maiusculo(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
        nomes.replaceAll(e -> e.toUpperCase());
        return nomes.stream().collect(Collectors.joining("\n"));
    }

    public String Minusculo(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
        nomes.replaceAll(e -> e.toLowerCase());
        return nomes.stream().collect(Collectors.joining("\n"));
    }

    public String capitalizar(String texto){
        nomes.clear();
        nomes.addAll(Arrays.asList(texto.split("\n")));
        return nomes.stream().map(s -> Arrays.stream(s.split(" ")) 
        .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
        .collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n")); 
    }


    }

