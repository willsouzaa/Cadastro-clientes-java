    package cadastropoo;

    import br.com.java.model.*;

    import java.io.IOException;
    import java.util.List;
    import java.util.Scanner;

    public class CadastroPOO {
        public static void main(String[] args) {
            // uso da biblioteca Scanner para fazer a captura do cliente
            Scanner scanner = new Scanner(System.in);
            // criando objetos das classes que irao se comunicar
            PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
            PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
            //variavel para receber dados do scanner
            int opcao;

            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Incluir Pessoa");
                System.out.println("2 - Alterar Pessoa");
                System.out.println("3 - Excluir Pessoa");
                System.out.println("4 - Exibir Pessoa pelo ID");
                System.out.println("5 - Exibir Todas as Pessoas");
                System.out.println("6 - Salvar Dados");
                System.out.println("7 - Recuperar Dados");
                System.out.println("0 - Sair");


                opcao = scanner.nextInt();
                //switch para fazer as opçoes de escolha
                switch (opcao) {
                    case 1:
                        System.out.println("Escolha a opcao desejada:");
                        System.out.println("1 - Pessoa fisica");
                        System.out.println("2 - Pessoa Juridica");
                        int tipoPessoa = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o id");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        // Condiçao para opcoes
                        if (tipoPessoa == 1) {
                            System.out.println("Digite o CPF:");
                            String cpf = scanner.nextLine();
                            System.out.println("Digite a idade:");
                            int idade = scanner.nextInt();
                            pessoaFisicaRepo.inserir(new PessoaFisica(id, nome, cpf, idade));
                        } else if (tipoPessoa == 2) {
                            System.out.println("Digite o CNPJ");
                            String cnpj = scanner.nextLine();
                            pessoaJuridicaRepo.inserir(new PessoaJuridica(id, nome, cnpj));
                        } else {

                            System.out.println("Opçao invalida");
                        }
                        break;
                    case 2:
                        System.out.println("Escolha a opçao desejada:");
                        System.out.println("1 - Pessoa fisica");
                        System.out.println("2 - Pessoa juridica");
                        int tipoAlterar = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o ID da pessoa que deja alterar");
                        int idAlterar = scanner.nextInt();
                        if (tipoAlterar == 1) {
                            PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(idAlterar);
                            if (pessoaFisica != null) {
                                System.out.println("Digite o novo nome");
                                String novoNome = scanner.nextLine();
                                System.out.println("Digite o nome cpf");
                                String novoCpf = scanner.nextLine();
                                System.out.println("Digite a nova idade");
                                int novaIdade = scanner.nextInt();
                                scanner.nextLine();
                                pessoaFisica.setNome(novoNome);
                                pessoaFisica.setCpf(novoCpf);
                                pessoaFisica.setIdade(novaIdade);
                                pessoaFisicaRepo.alterar(pessoaFisica);
                            } else {
                                System.out.println("Pessoa com ID" + idAlterar + "nao encontrada");
                            }

                        } else if (tipoAlterar == 2) {
                            PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(idAlterar);
                            if (pessoaJuridica != null) {
                                System.out.println("Digite o novo nome:");
                                String novoNome = scanner.nextLine();
                                System.out.println("Digite o novo CNPJ:");
                                String novoCnpj = scanner.nextLine();
                                pessoaJuridica.setNome(novoNome);
                                pessoaJuridica.setCnpj(novoCnpj);
                                pessoaJuridicaRepo.alterar(pessoaJuridica);
                            } else {
                                System.out.println("Pessoa com ID " + idAlterar + " não encontrada.");
                            }
                        } else {
                            System.out.println("Opção inválida");
                        }
                        break;

                    case 3:
                        System.out.println("Escolha o tipo de pessoa para excluir:");
                        System.out.println("1 - Pessoa Física");
                        System.out.println("2 - Pessoa Jurídica");
                        int tipoExclusao = scanner.nextInt();
                        System.out.println("Digite o ID da pessoa que deseja excluir:");
                        int idExclusao = scanner.nextInt();
                        if (tipoExclusao == 1) {
                            pessoaFisicaRepo.excluir(idExclusao);
                        } else if (tipoExclusao == 2) {
                            pessoaJuridicaRepo.excluir(idExclusao);
                        } else {
                            System.out.println("Opção inválida");
                        }
                        break;
                    case 4:
                        System.out.println("Escolha o tipo de pessoa para exibir pelo ID:");
                        System.out.println("1 - Pessoa Física");
                        System.out.println("2 - Pessoa Jurídica");
                        int tipoExibicaoId = scanner.nextInt();
                        System.out.println("Digite o ID da pessoa que deseja exibir:");
                        int idExibicao = scanner.nextInt();
                        if (tipoExibicaoId == 1) {
                            PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(idExibicao);
                            if (pessoaFisica != null) {
                                pessoaFisica.exibir();
                            } else {
                                System.out.println("Pessoa com ID " + idExibicao + " não encontrada.");
                            }
                        } else if (tipoExibicaoId == 2) {
                            PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(idExibicao);
                            if (pessoaJuridica != null) {
                                pessoaJuridica.exibir();
                            } else {
                                System.out.println("Pessoa com ID " + idExibicao + " não encontrada.");
                            }
                        } else {
                            System.out.println("Opção inválida");
                        }
                        break;
                    case 5:
                        System.out.println("Escolha o tipo de pessoa para exibir todas:");
                        System.out.println("1 - Pessoa Física");
                        System.out.println("2 - Pessoa Jurídica");
                        int tipoExibicaoTodos = scanner.nextInt();
                        if (tipoExibicaoTodos == 1) {
                            List<PessoaFisica> pessoasFisicas = pessoaFisicaRepo.obterTodos();
                            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                                pessoaFisica.exibir();
                            }
                        } else if (tipoExibicaoTodos == 2) {
                            List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaRepo.obterTodos();
                            for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                                pessoaJuridica.exibir();
                            }
                        } else {
                            System.out.println("Opção inválida");
                        }
                        break;

                    case 6:
                        System.out.println("Digite o prefixo dos arquivos para salvar:");
                        String prefixoSalvar = scanner.next();
                        try {
                            pessoaFisicaRepo.persistir(prefixoSalvar + ".fisica.bin");
                            pessoaJuridicaRepo.persistir(prefixoSalvar + ".juridica.bin");
                            System.out.println("Dados salvos com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar dados: " + e.getMessage());
                        }
                        break;

                    case 7:
                        System.out.println("Digite o prefixo dos arquivos para recuperar:");
                        String prefixoRecuperar = scanner.next();
                        try {
                            pessoaFisicaRepo.recuperar(prefixoRecuperar + ".fisica.bin");
                            pessoaJuridicaRepo.recuperar(prefixoRecuperar + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar dados: " + e.getMessage());
                        }
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida");

                }

            }while (opcao != 0) ;
        }
    }






