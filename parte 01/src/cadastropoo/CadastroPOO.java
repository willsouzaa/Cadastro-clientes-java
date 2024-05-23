package cadastropoo;

import br.com.java.model.*;

import java.io.IOException;
import java.util.List;

public class CadastroPOO {
    public static void main(String[] args) {
//Instanciar um repositório de pessoas físicas (repo1).

        try {
            //Repositorio de pessoas fisicas
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(
                    1,
                    "Paulo",
                    "083.548.574-65",
                    30));
            repo1.inserir(new PessoaFisica(2,
                    "Maria",
                    "544.532.179-98",
                    26));

            repo1.persistir("PessoasFisicas.dat");

            //Recuperar pessoa
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("PessoasFisicas.dat");
            List<PessoaFisica> todasPf = repo2.obterTodos();
            todasPf.forEach(PessoaFisica::exibir);

            //Repositorio Pessoas Juridicas
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(3, "Agorpecuaria.ltda", "05.852.569/0001-06"));
            repo3.inserir(new PessoaJuridica(4, "SuperMercado.ltda", "54.741.256/0002-05"));
            repo3.persistir("PessoasJuridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("PessoasJuridicas.dat");
            List<PessoaJuridica> todasPj = repo4.obterTodos();
            todasPj.forEach(PessoaJuridica::exibir);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error:" + e.getMessage());
            throw new RuntimeException("Error:" + e.getMessage());
        }
        {

        }
    }


}
