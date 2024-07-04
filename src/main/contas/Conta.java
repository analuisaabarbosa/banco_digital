package main.contas;

import java.util.Locale;
import java.util.Scanner;
import main.clientes.Cliente;

public class Conta {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar() {
        System.out.println("Digite o valor a ser sacado: ");
        double valor = scanner.nextDouble();
        if (saldo >= valor && valor > 0) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else if (valor == 0) {
            throw new Error("É necessário mencionar o valor.");
        } else {
            throw new Error("Saldo insuficiente.");
        }
    }

    public void depositar() {
        System.out.println("Digite o valor a ser depositado: ");
        Double valor = scanner.nextDouble();
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            throw new Error("É necessário mencionar o valor.");
        }

    }

    public void transferir(Conta contaDestino) {
        System.out.println("Digite o valor a ser transferido: ");
        double valor = scanner.nextDouble();
        if (saldo >= valor && valor > 0) {
            saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência realizada com sucesso!");
        } else if (valor == 0) {
            throw new Error("É necessário mencionar o valor.");
        } else {
            throw new Error("Saldo insuficiente.");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular da conta: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero da conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
