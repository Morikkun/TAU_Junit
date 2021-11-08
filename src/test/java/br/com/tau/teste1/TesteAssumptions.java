package br.com.tau.teste1;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TesteAssumptions {
    @ParameterizedTest
    @ValueSource(ints = {1,5,7})
    void intStuff (int parametro){
        assumeTrue(parametro > 3);
        System.out.println("parametro = " + parametro);
    }

    @ParameterizedTest
    @CsvSource(value = {"Eighty,Six", "Uramichi,Oniisan", "Records, Altair"})
    void stringStuff (String parametro1, String parametro2){
        assumeFalse(parametro1.equals("Uramichi"), "Valor Uramichi não coincide com " + parametro2);
        System.out.println("parametro1 = " + parametro1 + ", parametro2 = " + parametro2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Yowa,85", "Peda,15", "Kuroko,35"})
    void manyStuff (String parametro1, int parametro2){
        assumingThat(parametro2 > 20, () -> System.out.println("O código foi executado"));
        System.out.println("parametro1 = " + parametro1 + ", parametro2 = " + parametro2);
    }
}
