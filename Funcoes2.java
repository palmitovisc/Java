import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Funcoes2 {
    String[] nomes;

    public String A_Z(String texto){
        nomes = texto.split("\n");
        mergeSort(nomes);
        return  String.join("\n",nomes);
    }
    private void mergeSort(String[] array){
        if(array.length < 2){
            return;
        }
        int mid = array.length/2;
        String[] left = new String[mid];
        String[] right = new String[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(array,left,right);
    }
    
    private void merge(String[] array, String[] left, String[] right){
        int i = 0, j = 0,k = 0;

        while(i < left.length && j < right.length){
            if(left[i].compareToIgnoreCase(right[j]) <= 0){
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
    public String organizaZ_A(String texto){
        nomes = texto.split("\n");
        mergeSortZ_A(nomes);
        return String.join("\n", nomes);
    }
    private void mergeSortZ_A(String[] array){
        if(array.length < 2){
            return;
        }
        int mid = array.length/2;
        String[] left = new String[mid];
        String[] right = new String[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSortZ_A(left);
        mergeSortZ_A(right);
        mergeZ_A(array,left,right);
    }

    private void mergeZ_A(String[] array, String[] left, String[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareToIgnoreCase(right[j]) >= 0) {
                array[k++] = left[i++];
            } else {
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
    public String Inverter(String texto){
        nomes = texto.split("\n");
        String[] novoNomes = new String[nomes.length];
        int i = nomes.length - 1;
        int k = 0;
        while(i >= 0){
             novoNomes[k++] = nomes[i--];
        }
        nomes = novoNomes;
        return String.join("\n", nomes );
    }
    public String removerDuplicados(String texto){
        nomes = texto.split("\n");
        Set<String> setSemDuplicatas = new LinkedHashSet<>(Arrays.asList(nomes));
        return String.join("\n", setSemDuplicatas);
    }
    public String removerVazios(String texto){
        nomes = texto.split("\n");
        int cont = 0, i = 0 ;
        for(String s: nomes){
            if(s.trim().isEmpty()){
                 cont++;
            } 
        }

        String[] novoVetor = new String[nomes.length - cont];
        for(String s:nomes){
            if(!s.trim().isEmpty()){
                novoVetor[i++] = s;
            }
        }

        return String.join("\n", novoVetor);
    }

    public String aplicaTrim(String texto){
        nomes = texto.split("\n");
        
        for(int i = 0; i < nomes.length; i++){
            nomes[i] = nomes[i].trim();
        }
        return String.join("\n", nomes);
    }

    public String maiusculo(String texto){
        nomes = texto.split("\n");
        for(int i = 0; i < nomes.length; i++){
            nomes[i] = nomes[i].toUpperCase();
        }

        return String.join("\n", nomes);
    }
    public String minusculo(String texto){
        nomes = texto.split("\n");
        for(int i = 0; i < nomes.length; i++){
            nomes[i] = nomes[i].toLowerCase();
        }

        return String.join("\n", nomes);
    }

    public String capitalizar(String texto){
        nomes = texto.split("\n");
        String resultadoFinal = " ";

        for(String linha: nomes){
        String [] palavra = linha.split(" ");
        String resultadoLinha = " ";

        for (int i = 0; i < palavra.length; i++) {
            String palavras = palavra[i];
                resultadoLinha += palavras.substring(0, 1).toUpperCase() + palavras.substring(1).toLowerCase();
                if (i < palavra.length - 1) {
                    resultadoLinha += " ";
                }
            }
        resultadoFinal += resultadoLinha.trim() + "\n";
    }
    return resultadoFinal.trim();
    
}

}
