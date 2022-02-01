package maps;

import models.Aluno;

import java.util.List;

public interface AlunoMap<K, V> {

    Object salvarAluno(String identificador, Aluno aluno);

    boolean salvarAluno(List<Aluno> listAluno);

    boolean estaVazio();

    boolean removerAluno(String identificador);

    int recuperarTamanho();

    Aluno atualizarAluno(String identificador, Aluno aluno);

    Aluno recuperarAlunoIdentificador(String identificador);

    List<Aluno> listarAlunos();
}
