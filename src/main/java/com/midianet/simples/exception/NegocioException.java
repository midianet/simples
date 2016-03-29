package com.midianet.simples.exception;

public class NegocioException extends RuntimeException {

    public NegocioException(final String mensagem) {
        super(mensagem);
    }

    public NegocioException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
    }

    public NegocioException(final Throwable causa) {
        super(causa);
    }

    public NegocioException(final String mensagem, final Throwable causa, boolean suprimido, boolean gravaTrilha) {
        super(mensagem, causa, suprimido, gravaTrilha);
    }

}