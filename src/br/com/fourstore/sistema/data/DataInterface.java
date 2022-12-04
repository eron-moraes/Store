package br.com.fourstore.sistema.data;

import java.util.List;

public interface DataInterface {
	
	
	void registerProducts(Object object);
	
	void listProduct(Object object);
	
	void buyProducts(Object object);
	
	void seeCart(Object object);
	
	void pay(Object object);
	
	void checkout(Object object);
	
	void menu(Object object);
	
	List<Object> ListItems();
	
	void payDebit(Object object);
	
	void payCredi(Object object);
	
	void payCash(Object object);
	

}
