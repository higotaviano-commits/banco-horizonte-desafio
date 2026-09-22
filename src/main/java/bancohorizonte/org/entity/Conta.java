package bancohorizonte.org.entity;


import jakarta.persistence.*;


@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long agencia;
    private Long numero;
    private TipoConta tipo;
    private Double saldo = 0.0;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private static long numeroContaCounter = 10000L;


    public static synchronized Long gerarNumeroConta() {
        return numeroContaCounter++;
    }

    public void depositar(Double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void sacar(Double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque.");
        }
        this.saldo -= valor;
    }


    public Long getId() {
        return id;
    }


    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public Long getNumero() {
        return numero;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return saldo;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
