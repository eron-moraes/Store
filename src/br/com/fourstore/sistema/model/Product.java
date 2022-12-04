package br.com.fourstore.sistema.model;

import br.com.fourstore.sistemaUtils.Utils;

public class Product {
    private static int count = 1;

    private int id;
    private String nome;
    private Double preco;
    private String tamanho;

    public Product(String nome, Double preco, String tamanho) {
        this.id = count;
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
        Product.count += 1;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

    public String toString() {
        return"Id " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nTamanho: " + this.getTamanho() +
                "\nPreco: " + Utils.doubleToString(this.getPreco());
    }


}
