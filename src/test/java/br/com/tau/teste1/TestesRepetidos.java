package br.com.tau.teste1;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class TestesRepetidos {
    @RepeatedTest(10)
    void repeticaoUm(){
        System.out.println("Repetição de teste");
    }

    @RepeatedTest(value = 5, name = "Repetição {currentRepetition} de {totalRepetitions}")
    void repeticaoDois(){
        System.out.println("Repetição de OUTRO teste");
    }

    @Test
    void repeticaoTres(RepetitionInfo repetitionInfo){
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 10,
                () -> System.out.println("Máximo de repetições atingido"));
        System.out.println("Mais uma repetição");
    }
}
