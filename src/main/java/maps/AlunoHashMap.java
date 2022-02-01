package maps;

import models.Aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AlunoHashMap implements AlunoMap<String, Aluno> {

    private HashMap<String, Aluno> alunosHashMap;
    private OperationsObserver operationsObserver;

    public AlunoHashMap(HashMap<String, Aluno> hashMap, OperationsObserver operationsObserver) {
        setAlunosHashMap(hashMap);
        setOperationsObserver(operationsObserver);
    }


    public void setOperationsObserver(OperationsObserver operationsObserver) {
        this.operationsObserver = operationsObserver;
    }

    public void setAlunosHashMap(HashMap<String, Aluno> alunoHashMap) {
        this.alunosHashMap = alunoHashMap;
    }

    @Override
    public Object salvarAluno(String identificador, Aluno aluno) {
        return this.alunosHashMap.put(identificador, aluno) == null ? null :
                this.alunosHashMap.get(identificador);
    }

    @Override
    public boolean salvarAluno(List<Aluno> listAluno) {
        List<Object> saidas = new ArrayList<>();
        List<StringBuilder> representacaoMap = new ArrayList<>();
        int count = 0;
        for (Aluno aluno : listAluno) {
            saidas.add(salvarAluno(aluno.getIdentificador(), aluno));
            representacaoMap.add(representacaoMapa());
            operationsObserver.notifyDataSet(Operations.SALVAR, saidas.get(count),
                    representacaoMap.get(count));
            count++;
        }

        return true;
    }

    @Override
    public boolean estaVazio() {
        boolean result = alunosHashMap.isEmpty();
        operationsObserver.notifyDataSet(Operations.VAZIO, result, representacaoVazio());
        return result;
    }

    @Override
    public boolean removerAluno(String identificador) {
        boolean result = this.alunosHashMap.remove(identificador) != null;
        operationsObserver.notifyDataSet(Operations.REMOVER, result, representacaoMapa());
        return result;
    }

    @Override
    public int recuperarTamanho() {
        int sizeMap = alunosHashMap.size();
        operationsObserver.notifyDataSet(Operations.TAMANHO, sizeMap, representacaoMapa());
        return sizeMap;
    }

    @Override
    public Aluno atualizarAluno(String identificador, Aluno aluno) {
        Aluno alunoAtualizado = this.alunosHashMap.put(identificador, aluno);
        operationsObserver.notifyDataSet(Operations.ATUALIZAR, alunoAtualizado, representacaoMapa());
        return alunoAtualizado;
    }

    @Override
    public Aluno recuperarAlunoIdentificador(String identificador) {
        Aluno result = this.alunosHashMap.get(identificador);
        operationsObserver.notifyDataSet(Operations.RECUPERAR, result, representacaoMapa());
        return result;
    }

    @Override
    public List<Aluno> listarAlunos() {
        return (List<Aluno>) this.alunosHashMap.values();
    }


    public void mostrarCabecalho() {
        System.out.println("########################## HashMap Alunos #############################");
        System.out.printf("%10s %20s %20s", "[OPERAÇÃO]", "[SAÍDA]", "[MAPA]");
        System.out.println();
    }

    private StringBuilder representacaoMapa() {
        Set<String> keySet = this.alunosHashMap.keySet();
        StringBuilder s1 = new StringBuilder("{");
        String s2 = "}";
        for (String key : keySet) {
            String mapString = "[" + key + "," + this.alunosHashMap.get(key).getNome() + "]";
            s1.append(mapString);
        }

        return s1.append(s2);
    }

    public void mostrarStatusMap(Operations operation, Object saida, StringBuilder representacaoMap) {
        if (saida == null) {
            System.out.format("%10s %20s %20s", operation, "null", representacaoMap);
            System.out.println();
        } else {
            System.out.format("%10s %20s %20s", operation, saida, representacaoMap);
            System.out.println();
        }
    }

    private StringBuilder representacaoVazio() {
        return new StringBuilder("{[0]}");
    }


}
