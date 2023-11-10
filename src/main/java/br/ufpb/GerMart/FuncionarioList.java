package br.ufpb.GerMart;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioList implements FuncionarioInterface {
    private List<Funcionario>funcionarios;
    public FuncionarioList() {
        this.funcionarios = new ArrayList<>();
    }
    public FuncionarioList(List<Funcionario> funcionarios){
        this.funcionarios = funcionarios;
    }
    @Override
    public boolean existeFuncionario(String matricula){
        for (Funcionario fc: funcionarios){
            if(fc.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }
    public void cadastrarFuncionario (Funcionario funcionario) throws FuncionarioJaExisteException {
        if (existeFuncionario(funcionario.getMatricula())) {
            JOptionPane.showMessageDialog(null, "Funcionário não cadastrado! Pois já existe um funcionário com a mesma matrícula!");
        } else {
            funcionarios.add(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");
        }
    }
    public boolean apagarFuncionario(String matricula) throws FuncionarioNaoExisteException{
        if (existeFuncionario(matricula)) {
            for (Funcionario f : funcionarios) {
                if (f.getMatricula().equals(matricula)) {
                    funcionarios.remove(f);
                    return true;
                }
            }
        }
        throw new FuncionarioNaoExisteException("Funcionário não existe, por isso, não foi possível apagá-lo.");
    }
    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    @Override
    public Funcionario pesquisarFuncionario(String matricula) throws FuncionarioNaoExisteException {
        for (Funcionario f : this.funcionarios){
            if (f.getMatricula().equals(matricula)){
                return f;
            }
        }
        throw new FuncionarioNaoExisteException("O funcionário pesquisado não existe");
    }

}
