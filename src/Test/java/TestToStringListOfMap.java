package Test.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestToStringListOfMap {
    static class Aluno {
        String nome;
        String RA;

        public Aluno(String nome, String RA) {
            this.nome = nome;
            this.RA = RA;
        }

        @Override
        public String toString() {
            return "Printando o tostring do aluno: Aluno{" +
                    "nome='" + nome + '\'' +
                    ", RA='" + RA + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Map<Integer, Aluno>> alunos = new ArrayList<>();
        Map<Integer, Aluno> aluno = new HashMap<>();
        aluno.put(1, new Aluno("Gui", "20543"));
        alunos.add(aluno);

        System.out.println(alunos);
        System.out.println(aluno.get(1));
    }
}
