package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class Aluno {

    private String identificador;
    private String nome;
    private String idade;
    private String turma;

    @Override
    public String toString() {
        return this.getNome();
    }
}
