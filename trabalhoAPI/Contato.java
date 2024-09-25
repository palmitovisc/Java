
import java.util.Objects;

public class Contato {
    private String nome;
    private String telefone;
    private String endereco;

    public Contato(String nome, String telefone, String endereco) {
        if (nome.length() > 30 || telefone.length() != 11  || endereco.length() > 100) {
            throw new IllegalArgumentException("Dados inválidos: verifique os tamanhos dos campos.");
        }
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    // Para permitir que o Contato seja utilizado como chave, precisamos sobrescrever equals() e hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && 
               Objects.equals(telefone, contato.telefone) && 
               Objects.equals(endereco, contato.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, endereco);
    }
}
