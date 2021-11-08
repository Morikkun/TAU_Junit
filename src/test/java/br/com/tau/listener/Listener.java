package br.com.tau.listener;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Teste desabilitado: " + context.getTestMethod() + "Por: " + reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Teste aprovado: " + context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Teste abortado: " + context + "motivo: " + cause.getCause());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Teste falhado: " + context + "motivo: " + cause.getCause());
    }
}
