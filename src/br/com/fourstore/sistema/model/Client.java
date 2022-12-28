package br.com.fourstore.sistema.model;


	public class Client {

	    private String nomeClient;
	    private String CPF;
	    

	    public Client (String nomeClient, String CPF) {
	        this.nomeClient = nomeClient;
	        this.CPF = CPF;
	    }

	    public String getNomeClient() {
	        return nomeClient;
	    }
	    public void setNomeClient(String nomeClient) {
	        this.nomeClient = nomeClient;
	    }

	    public String getCPF() {
	        return CPF;
	    }
	    public void setCPF(String CPF) {
	        this.CPF = CPF;
	    }

	    public String toString() {
	        return
	                "\nNome: " + this.getNomeClient() +
	                "\nPreço: " + this.getCPF();
	    }
	}

