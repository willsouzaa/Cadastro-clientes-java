package br.com.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Classe PessoaJuridicaRepo
public class PessoaJuridicaRepo {

// criando ArrayList de PessoaJuridica
private List<PessoaJuridica> listaPessoa;

//cronstrutor de PessoaJuridicaRepo
    public PessoaJuridicaRepo() {
        this.listaPessoa = new ArrayList<>();
    }

    //metodo inserir
    public void inserir(PessoaJuridica pessoa) {
        listaPessoa.add(pessoa);
    }
    //metodo alterar pessoa
    public void alterar(PessoaJuridica pessoa) {
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
    public PessoaJuridica obter(int id){
        for (PessoaJuridica pessoa : listaPessoa){
            if (pessoa.getId(2) == id){
                return pessoa;
            }
        }
        System.out.println("Pessoa com ID " + id + "Nao encontrada.");
        return null;
    }

    //metodo obter todos, para obter todos da lista do Arraylist
    public List<PessoaJuridica> obterTodos(){
        return new ArrayList<>(listaPessoa);
    }

    //Persistencio do arquivo com Serializable
    public void persistir(String pessoaJuridica) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(pessoaJuridica);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(listaPessoa);
            System.out.println("Dados persistidos com sucesso no arquivo:" +pessoaJuridica);
        }catch (IOException e){
            System.out.println("Erro ao persistir dados:" + e.getMessage());
            throw  e;
        }
    }
    // Metodo recuperar com Serialize
    public void recuperar(String pessoaJuridica) throws IOException, ClassNotFoundException{
        try (FileInputStream fis = new FileInputStream(pessoaJuridica);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            listaPessoa = (List<PessoaJuridica>) ois.readObject();
            System.out.println("Dados recuperados com sucesso:" + pessoaJuridica);
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados:"  + e.getMessage());
            throw e;
        }
    }

}
