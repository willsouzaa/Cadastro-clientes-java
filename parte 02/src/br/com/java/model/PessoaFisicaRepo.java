package br.com.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
// classe PessoaFisicaRepo
public class PessoaFisicaRepo{
    // Criando ArrayList de PessoaFisica
    private List<PessoaFisica> listaPessoa;

//Construtor da Arraylist de PessoaFisica

    public PessoaFisicaRepo() {
        this.listaPessoa = new ArrayList<>();
    }


//Criando metodos publicos inserir, alterar, excluir, obter e obterTodos

    //metodo inserir
    public void inserir(PessoaFisica pessoa) {
        listaPessoa.add(pessoa);
    }

    //metodo alterar pessoa
    public void alterar(PessoaFisica pessoa) {
        for (int i = 0; i < listaPessoa.size(); i++) {
            if (listaPessoa.get(i).getId(1) == pessoa.getId(1)) {
                listaPessoa.set(i, pessoa);
                return;
            }
        }
        System.out.println("Pessoa com ID" + pessoa.getId(1) + "Nao encontrada");

    }
    //metodo excluir
    public void excluir(int id){
        listaPessoa.removeIf(p ->  p.getId(1) == id);
    }

    //metodo obter
    public PessoaFisica obter(int id){
        for (PessoaFisica pessoa : listaPessoa){
            if (pessoa.getId(2) == id){
                return pessoa;
            }
        }
        System.out.println("Pessoa com ID " + id + "Nao encontrada.");
        return null;
    }

    //metodo obter todos, para obter todos da lista do Arraylist
    public List<PessoaFisica> obterTodos(){
        return new ArrayList<>(listaPessoa);
    }

    //Persistencio do arquivo com Serializable
    public void persistir(String pessoaFisica) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(pessoaFisica);
        ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(listaPessoa);
            System.out.println("Dados persistidos com sucesso no arquivo:" +pessoaFisica);
        }catch (IOException e){
            System.out.println("Erro ao persistir dados:" + e.getMessage());
            throw  e;
        }
    }
   // Metodo recuperar com Serialize
    public void recuperar(String pessoaFisica) throws IOException, ClassNotFoundException{
        try (FileInputStream fis = new FileInputStream(pessoaFisica);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            listaPessoa = (List<PessoaFisica>) ois.readObject();
            System.out.println("Dados recuperados com sucesso:" + pessoaFisica);
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados:"  + e.getMessage());
            throw e;
        }
    }
}