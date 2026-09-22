package bancohorizonte.org.exception;

public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException(Long id) {
        super("Conta não encontrada com o ID: " + id);
    }
}
