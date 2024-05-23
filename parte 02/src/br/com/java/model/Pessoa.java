/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.java.model;

import java.io.Serializable;
// class Pessoa
public class Pessoa implements Serializable{
    private int id;
    private String nome;

    // Construtor da classe Pessoa
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Geters e Seters dos Atributos da Classe Pessoa


    public int getId(int i) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Metodo Exibir para os Atributos id e nome
    public void exibir(){
        System.out.println("ID :" + id);
        System.out.printf("NOME :" + nome);
    }
}