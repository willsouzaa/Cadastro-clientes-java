package br.com.java.model;

import java.io.Serializable;
// classe PessoaJuridica herdando de Pessoa
public class PessoaJuridica extends Pessoa implements Serializable{
    private String cnpj;

    // construtor herdando atributos de Pessoa e adicionando atributos


    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    //geters e seters de PessoaJuridica

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    // Metodo exibir herdando polimorfico de Pessoa
    public void exibir(){
        super.exibir();
        System.out.println("CNPJ :" + cnpj);
    }
}
