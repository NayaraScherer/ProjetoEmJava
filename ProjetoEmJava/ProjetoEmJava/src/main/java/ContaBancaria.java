/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nayar
 */
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private String nomeTitular;
    private String numeroConta;
    private double saldo;
    private List<String> extrato;

    public ContaBancaria(String nomeTitular, String numeroConta, double depositoInicial) {
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.saldo = depositoInicial;
        this.extrato = new ArrayList<>();
        extrato.add("Depósito inicial: " + depositoInicial);
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Depósito: " + valor);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            extrato.add("Saque: " + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void extrato() {
        System.out.println("Extrato da conta de " + nomeTitular);
        for (String transacao : extrato) {
            System.out.println(transacao);
        }
        System.out.println("Saldo atual: " + saldo);
    }

    public void cancelarConta() {
        nomeTitular = null;
        numeroConta = null;
        saldo = 0;
        extrato.clear();
        System.out.println("Conta cancelada com sucesso.");
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Nayara", "12345-9", 4000.0);

        conta.depositar(800.0);
        conta.sacar(100.0);
        conta.extrato();

        conta.cancelarConta();
    }
}
