
public class Livraria{
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;
    private String preco;
    
    public Livraria() {
	}
	
	public Livraria(final String titulo, final String autor, final int isbn, final String genero, final float preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.genero = genero;
		this.preco = preco;
	}
        public String getAutor() {
            return Autor;
        }
        public String getGenero() {
            return Genero;
        }
        public String getIsbn() {
            return Isbn;
        }
        public String getPreco() {
            return preco;
        }
        public String getTitulo() {
            return Titulo;
        }
        public void setAutor(String autor) {
            Autor = autor;
        }
        public void setGenero(String genero) {
            Genero = genero;
        }
        public void setIsbn(String isbn) {
            Isbn = isbn;
        }
        public void setPreco(String preco) {
            this.preco = preco;
        }
        public void setTitulo(String titulo) {
            Titulo = titulo;
        }
        @Override
	public String toString() {		
		return "Titulo: "+titulo+"\r\n"
				+"Autor: "+autor+"\r\n"
				+"Isbn: "+isbn+"\r\n"
				+"G�nero: "+genero+"\r\n"
				+String.format("Pre�o R$ 2.f%", preco);
	}

}
