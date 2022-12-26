package br.com.fourstore.sistema;


import br.com.fourstore.sistema.model.Product;
import br.com.fourstore.sistema.service.StockService;
import br.com.fourstore.sistemaUtils.Utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Scanner input = new Scanner(System.in);
    private static ArrayList<Product> produtos;
    private static Map<Product, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu() {
        System.out.println("____________________________________________________");
        System.out.println("_______________Bem vindo a FourStore________________");
        System.out.println("____________________________________________________");
        System.out.println("___________*Digite a operacaoo desejada*_____________");
        System.out.println("____________________________________________________");
        System.out.println("|    Option 1 - Cadastrar   |");
        System.out.println("|    Option 2 - Listar      |");
        System.out.println("|    Option 3 - Comprar     |");
        System.out.println("|    Option 4 - Carrinho    |");
        System.out.println("|    Option 0 - Sair        |");

        int option = input.nextInt();

        switch (option) {
            case 1:
            	registerProducts();
                break;

            case 2:
                listProducts();
                break;

            case 3:
                buyProducts();
                break;

            case 4:
            	seeCart();
                break;

            case 0:
                System.out.println("Valeu por escolher a FourStore, melhor loja do planeta! e volte sempre!");
                System.exit(0);

            default:
                System.out.println("Opcao invalida!");
                menu();
                break;

        }
    }

    private static void registerProducts() {
    	
    	
    	System.out.println("Digite o SKU do produto");
    	String sku = input.next();
    	
        System.out.println("Descricaoo do Produto: ");
        String nome = input.next();

        System.out.println("Preco do Produto: ");
        Double preco = input.nextDouble();
        

        Product produto = new Product(sku, nome, preco);
        produtos.add(produto);
         
        System.out.println(produto.getNome() + " cadastrado com sucesso!");
        menu();       
        }

    private static void listProducts() {
        if (produtos.size() > 0) {
            System.out.println("Lista de Produtos: \n");

            for (Product p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto cadastrado!");
        }
        menu();
    }

    private static void buyProducts() {
        if (produtos.size() > 0) {

            System.out.println("******* Produtos disponiveis *******");
            for (Product p : produtos) {
                System.out.println(p + "\n");
            }

            System.out.print("Codigo ID do Produto:");

            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Product p : produtos) {
                if (p.getId() == id) {
                    int qtd = 0;
                    try {
                        qtd = carrinho.get(p); //se já tiver o produto, incrementa a quantidade.
                        carrinho.put(p, qtd + 1);
                    } catch (NullPointerException e) {
                        carrinho.put(p, 1); //se for o 1º produto
                    }
                    System.out.println(p.getNome() + " adicionado no carrinho.");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produto ao carrinho? ");
                        System.out.println("Digite 1 para sim ou 0 para finalizar a compra ou 2 para ver o Carrinho. \n ");
                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                        	buyProducts();
                        }
                        if (option == 2) {
                            seeCart();
                        } else {
                            pay();
                            checkout();
                        }
                    }
                } else {
                    System.out.println("Produto nao encontrado!");
                    menu();
                }
            }
        } else {
            System.out.println("Nao existem produtos cadastrados!");
            menu();
        }
    }

    private static void seeCart() {
        System.out.println("----- Produtos no seu Carrinho! ----- ");
        if (carrinho.size() > 0) {
            for (Product p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
            }
        } else {
            System.out.println("Carrinho vazio!");
        }
        menu();
    }

    private static void pay() {


        System.out.println("CPF do cliente (Apenas Digitos): ");
        String CPF = input.next();
        
        String CPFformatado = CPF.substring(0,3)+"."+CPF.substring(3,6)+"."+CPF.substring(6,9)+"-"+CPF.substring(9,11);

        System.out.println("Nome do cliente: ");
        String nomeClient = input.next();

        System.out.println("____________________________________________________");
        System.out.println("___________*Modo de pagamento desejado*_____________");
        System.out.println("____________________________________________________");
        System.out.println("|    Option 1 - Pagar com Credito   |");
        System.out.println("|    Option 2 - Pagar com Debito    |");
        System.out.println("|    Option 3 - Pagar com Dinheiro  |");

        int optionSale = input.nextInt();

        switch (optionSale) {
            case 1:
                payDebit();
                break;

            case 2:
                payCredit();
                break;

            case 3:
                payCash();
                break;


            default:
                System.out.println("Opcao invalida!");
                pay();
                break;

        }

        System.out.println("***Dados do CLiente***");
        System.out.println("Nome do Cliente: " + nomeClient + 
        		" CPF do Cliente: " + CPFformatado);

    }


    private static void payDebit() {
        System.out.println("Pagamento realizado no Debito");
    }

    private static void payCredit() {
        System.out.println("Pagamento realizado no Credito");
    }

    private static void payCash() {
        System.out.println("Pagamento realizado no Dinheiro");
    }

        private static void checkout() {

            Double valorDaCompra = 0.0;
            System.out.println("***Seus Produtos!***");

            for (Product p : carrinho.keySet()) {
                int qtd = carrinho.get(p);
                valorDaCompra += p.getPreco() * qtd;
                System.out.println(p);
                System.out.println("Quantidade: " + qtd);
                System.out.println("--------------------");
            }
            System.out.println("O valor da sua compra e: " + Utils.doubleToString(valorDaCompra));
            carrinho.clear();

            System.out.println("Obrigado por escolher a FourStore, melhor loja do planeta!");
        }
    }






