package br.com.tau.teste1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TesteComTag {
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
    @Tag("Functional")
    @DisplayName("Second method")
    void secondMethod(){
        System.out.println("Segundo método");
    }

    @Test
    @Tag("Regression")
    @DisplayName("First method")
    void firstMethod(){
        System.out.println("Primeiro método");
    }

    @ParameterizedTest
    @ValueSource(ints = {5,7,12})
    @Tag("Performance")
    @Tag("Regression")
    void thirdMethod(int param){
        System.out.println("param = " + param);
    }

    @Test
    void forthMethod (){
        System.out.println("Quarto método");
    }

}
