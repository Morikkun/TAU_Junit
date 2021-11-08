package br.com.tau.teste1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("Exemplo")
@DisplayName("Batata")
public @interface MinhaAnotacao {
}
