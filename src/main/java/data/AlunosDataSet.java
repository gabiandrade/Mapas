package data;

import models.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunosDataSet {

    public static List<Aluno> getDataSetAlunos() {
        ArrayList<Aluno> alunosList = new ArrayList<>();
        alunosList.add(new Aluno("1", "Gabriela", "30", "SANTANDER 808"));
        alunosList.add(new Aluno("2", "Diego", "30", "SANTANDER 808"));
        alunosList.add(new Aluno("3", "Aline", "30", "SANTANDER 808"));
        alunosList.add(new Aluno("4", "João", "30", "SANTANDER 808"));
        alunosList.add(new Aluno("5", "Harry Potter", "18", "SANTANDER 808"));
        alunosList.add(new Aluno("6", "Peter Parker", "20", "SANTANDER 808"));
        return alunosList;
    }
}
