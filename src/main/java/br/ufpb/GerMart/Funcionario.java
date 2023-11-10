package br.ufpb.GerMart;
import java.util.Objects;
public class Funcionario {
    private String nome;
    private String matricula;
    private String setor;
    private String cargo;

    public Funcionario() {
        this("", "", "", "");
    }

    public Funcionario(String nome, String matricula, String setor, String cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.setor = setor;
        this.cargo = cargo;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;

        if (!Objects.equals(nome, that.nome)) return false;
        return Objects.equals(matricula, that.matricula);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (matricula != null ? matricula.hashCode() : 0);
        return result;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome (String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return this.matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
        }
    public String getSetor() {
        return this.setor;
    }
    public void setSetor (String setor) {
        this.setor = setor;
    }
    public String getCargo (){
        return this.cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String toString (){
        return "Funcionário: "+getNome() + "\nMatrícula: "+ getMatricula() + "\nSetor: "
                + getSetor() + "\nCargo: " + getCargo();
    }
}

