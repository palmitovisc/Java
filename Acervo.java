import java.util.ArrayList;

public class Acervo {

        private static ArrayList<Livraria> listaLivros = new ArrayList<Livraria>();

        public static ArrayList<Livraria> getListaLivros(){
            return listaLivros;
        }

        public static void adicionar(Livraria l){
            listaLivros.add(l);
        }

        public static String listar(){
            String saida ="";

            int i = 1;
            for(Livraria l: listaLivros){
                saida += "\n======== Livro n� "+(i++) +" ====== \n";
			    saida += l.toString()+"\r\n";
            }
            return saida;

        }

        public static int pesquisar(String genero){
            int qtd = 0;
            for(Livraria l: listaLivros){
                if(l.getGenero().equalsIgnoreCase(genero)){
                    qtd++;
                }
            }
            return qtd;
        }

        public static int pesquisar(final double inicio, final double fim){
            int qtd = 0;
            for(Livraria l: listaLivros){
                if(l.getPreco() >= inicio && l.getPreco <= fim){
                    qtd++;
                }
            }
            return qtd;

        }

        public static boolean remover(final String titulo){
            for(Livraria l: listaLivros){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                return listaLivros.remove(Titulo);
            }
        }
        return false;
        }

        public static double calcularTotalAcervo(){
            double total= 0;
            for(Livraria l: listaLivros){
                total = total + l.getPreco();	
            }
            return total;
        }


}
