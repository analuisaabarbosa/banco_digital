package main;

import main.clientes.Cliente;
import main.contas.ContaCorrente;
import main.contas.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Cliente analu = new Cliente(null);
        analu.setNome("Ana Luisa");

        ContaCorrente contaCorrente = new ContaCorrente(analu);
        ContaPoupanca contaPoupanca = new ContaPoupanca(analu);

        contaCorrente.depositar();
        contaCorrente.sacar();
        contaCorrente.transferir(contaPoupanca);
        contaCorrente.imprimirExtrato();

        contaPoupanca.depositar();
        contaPoupanca.imprimirExtrato();
    }
}
