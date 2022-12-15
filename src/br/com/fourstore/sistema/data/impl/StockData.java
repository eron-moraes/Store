package br.com.fourstore.sistema.data.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fourstore.sistema.data.DataInterface;

public class StockData implements DataInterface {

		List<Object>stock = new ArrayList<Object>();
		
		@Override
		public boolean save(Object object) {
			if (stock.add(object)) {
			return true;	
			}
			return false;
		}

		@Override
		public boolean delete(Object object) {
			if (stock.remove(object)) {
				return true;	
			}
			return false;
		}

		@Override
		public boolean edit(Object object, Integer index) {
			stock.set(index, object);
			return true;	
		}

		@Override
		public List<Object> list() {
			// TODO Auto-generated method stub
			return stock;
		}

}
