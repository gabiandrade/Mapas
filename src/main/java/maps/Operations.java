package maps;

public enum Operations {

    SALVAR("Salvar"),
    RECUPERAR("Recuperar"),
    ATUALIZAR("Atualizar"),
    REMOVER("Remover"),
    TAMANHO("Tamanho"),
    VAZIO("Vazio");

    private String operation;

    Operations(String operation) {
        this.operation = operation;
    }
}
