package br.com.tau.teste1;

import org.junit.jupiter.api.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TesteBasico {
    @BeforeAll
    void beforeAll(){
        System.out.println("-- Before all");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("--------- Before each");
    }

    @AfterAll()
    void afterAff(){
        System.out.println("-- After all");
    }

    @AfterEach
    void afterEach(){
        System.out.println("--------- After each");
    }

    @Test
    @DisplayName("Story 1001 - TC 42")
    void testeAritimetico(){
        int a = 1;
        int b = 3;
        int soma = a + b;
        int valorEsperado = 4;
        if (soma == valorEsperado){
            System.out.println("Teste aprovado");
        }
        else {
            throw new ArithmeticException("Resultado incorreto");
        }
    }

    @Test
    @DisplayName("Story 1002 - TC 46")
    void testeString(){
        System.out.println("Teste aprovado");
    }

}
