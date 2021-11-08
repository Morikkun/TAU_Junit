package br.com.tau.teste1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

public class Miscellaneous {
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void timeoutMethod() throws InterruptedException {
        System.out.println("Esse método resulta em um timeout");
        Thread.sleep(6000);
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class Aninhada{
        @BeforeAll
        void beforeAll(){
            System.out.println("Isso vem antes de tudo");
        }

        @BeforeEach
        void beforeEach(){
            System.out.println("Isso vem antes de todos os testes");
        }

        @Test
        void ambiente(){
            System.out.println("Preparando ambiente");
        }

        @ParameterizedTest
        @ValueSource(ints = {5,12,755})
        void operacao(int param){
            System.out.println("param = " + param);
        }

        @AfterEach
        void afterEach(){
            System.out.println("Isso vem depois de cada método");
        }

        @AfterAll
        void afterAll(){
            System.out.println("Isso vem depois de tudo");
        }
    }

    @MinhaAnotacao
    void customAnnotation(){
        System.out.println("Essa é uma anotação customizada");
    }
}
