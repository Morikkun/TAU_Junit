package br.com.tau.teste1;

import br.com.tau.listener.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
public class EnableDisableTest {
    @Test
    @Disabled("Mensagem de exemplo")
    void primeiroMetodo() {
        System.out.println("Primeiro método");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Demonstrando desabilitação por OS")
    void segundoMetodo() {
        System.out.println("Segundo método");
    }

    @Test
    @DisabledIfSystemProperty(named = "Denv", matches = "Staging")
    void terceiroMetodo() {
        System.out.println("Terceiro método");
    }

    @Test
    @DisabledIf(value = "diaDaSemana", disabledReason = "Só um teste")
    void quartoMetodo(){
        System.out.println("Quarto método");
    }

    @Test
    void quintoMetodo(){
        System.out.println("Quinto método");
    }

    boolean diaDaSemana(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }
}