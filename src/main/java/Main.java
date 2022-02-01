import data.AlunosDataSet;
import maps.AlunoHashMap;
import models.Aluno;

import java.util.HashMap;

public class Main {

    private static AlunoHashMap alunoHashMap;

    public static void main(String[] args) {

        alunoHashMap = new AlunoHashMap(new HashMap<>(), (operations, saida, map)
                -> alunoHashMap.mostrarStatusMap(operations, saida, map));


        alunoHashMap.mostrarCabecalho();
        alunoHashMap.estaVazio();
        alunoHashMap.salvarAluno(AlunosDataSet.getDataSetAlunos());
        alunoHashMap.atualizarAluno(AlunosDataSet.getDataSetAlunos().get(0).getIdentificador(),
                new Aluno("1", "Maria", "25", "SANTANDER 808"));
        alunoHashMap.removerAluno(AlunosDataSet.getDataSetAlunos().get(1).getIdentificador());
        alunoHashMap.recuperarAlunoIdentificador(AlunosDataSet.getDataSetAlunos().get(3).getIdentificador());
        alunoHashMap.recuperarAlunoIdentificador("32");
        alunoHashMap.recuperarTamanho();


    }
}
