package br.com.tau.teste1;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TesteOrdenado2 {
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
    void firstMethod(){
        System.out.println("Primeiro método");
    }

    @Test
    @Order(Integer.MAX_VALUE)
    void secondMethod(){
        System.out.println("Segundo método");
    }

    @Test
    @Order(Integer.MIN_VALUE)
    void thirdMethod (){
        System.out.println("Terceiro método");
    }

}
