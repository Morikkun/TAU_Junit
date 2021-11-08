package br.com.tau.teste1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TesteParametrizado {
    @BeforeEach
    void beforeEach (){
        System.out.println("---------");
    }

    @ParameterizedTest(name = "Run: {index} - Value: {arguments}")
    @ValueSource(ints = {3,5,8})
    void testeInt (int theParam){
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Valor 1", "Valor 2"})
     void testString (String theParam){
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value =  {"asobi,asobase", "kono,suba", "grandblue, dreaming"})
    @DisplayName("Story ABC#4 - Test Case 49")
    void csvStringString (String param1, String param2){
        System.out.println("Parâmetro 1: " + param1 + " Parâmetro 2: " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Asobi,5,false", "Grandblue,2,true", "Kono,92,true"})
    void csvStringIntBool (String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest(name = "Chave: {index} - Valor: {arguments}")
    @CsvSource(value =  {"Asobi Asobase, 'comedia,japonesa'", "Grandblue Dreaming, 'comedia,universitaria'"})
    void csvComVirgula (String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Vtuber|top", "Youtuber|top"}, delimiter = '|')
    void semVirgula (String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/ListaCompras.csv",
            "src/test/resources/params/NovaListaCompras.csv"}, numLinesToSkip = 1, delimiterString = "|")
    void listaCompras (String nome, double preco, double qtd, String unidadeMedida, String origem){
        System.out.println("nome = " + nome + ", preco = " + preco + ", qtd = "
                + qtd + ", unidadeMedida = " + unidadeMedida + ", origem = " + origem);
    }

    @ParameterizedTest
    @MethodSource(value = "br.com.tau.teste1.ParametroSource#stringSource")
    void metodoSource (String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "stringSourceStream")
    void metodoSourceStream (String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "stringArguments")
    void metodoArguments (String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @MethodSource(value = "stringArgumentsStream")
    void metodoArgumentsStream (String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    static List<String> stringSource (){
        return Arrays.asList("Asobi Asobase", "86", "Grand Blue Dreaming");
    }

    static Stream<String> stringSourceStream (){
        return Stream.of("D.Gray-Man", "Re:Zero", "Working!!!");
    }

    static List<Arguments> stringArguments (){
        return Arrays.asList(arguments("Switch OLED", 4999.99),
                arguments("Playstation 5", 5793.99), arguments("Xbox Series X", 5980.99));
    }

    static Stream<Arguments> stringArgumentsStream (){
        return Stream.of(arguments("Switch Lite", 1600.99),
                arguments("Playstation 4 Pro", 3999.99), arguments("Xbox Series S", 2700.99));
    }
}
