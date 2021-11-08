package br.com.tau.teste1;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TesteOrdenado1 {
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
    @DisplayName("Second method")
    void secondMethod(){
        System.out.println("Segundo método");
    }

    @Test
    @DisplayName("First method")
    void firstMethod(){
        System.out.println("Primeiro método");
    }

}
