package br.com.fourstore.sistema.service;

import java.util.List;

import br.com.fourstore.sistema.data.impl.StockData;
import br.com.fourstore.sistema.model.Product;

public class StockService {
	
	StockData stockData = new StockData();
	
	public int registerProducts(Product product) {
		if (stockData.save(product)) {
			return 1;
		}
		return 0;
	}
	
	public List<Object> listStock() {
		
		return stockData.list();
	}

	public boolean cadProduct(String sku) {
		// TODO Auto-generated method stub
		return false;
	}



	
	//public int deleteProducts(String sku) {
		
	//}
	//public Product searchBySku(String sku) {
	//	for(int x=0; x<listStock().size();x++) {
    //		Product product = (Product) listStock().get(x);
    //		System.out.println(product.toString());
    //	}
	//}
}
