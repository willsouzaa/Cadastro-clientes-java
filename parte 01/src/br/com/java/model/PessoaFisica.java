/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.java.model;


import java.io.Serializable;
// classe Pessoa Fisica erdando atributos da classe Pessoa
public class PessoaFisica extends Pessoa implements Serializable{
    //Atributos de pessoa fisica
    private String cpf;
    private int idade;

//construtor herdando atributos da Classe Pessoa Polimorfico com (super)
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
// Metodo Exibir Polimorfico com (super) e adicionando atributos cpf e idade
    public void exibir(){
        super.exibir();
        System.out.printf("CPF:" + cpf + " ");
        System.out.printf("IDADE:" + idade + " ");


    }
}