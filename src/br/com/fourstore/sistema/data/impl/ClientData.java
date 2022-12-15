package br.com.fourstore.sistema.data.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fourstore.sistema.data.DataInterface;

public class ClientData implements DataInterface {

List<Object>historico = new ArrayList<Object>();
	
	@Override
	public boolean save(Object object) {
		if (historico.add(object)) {
		return true;	
		}
		return false;
	}

	@Override
	public boolean delete(Object object) {
		if (historico.remove(object)) {
			return true;	
		}
		return false;
	}

	@Override
	public boolean edit(Object object, Integer index) {
		historico.set(index, object);
		return true;	
	}

	@Override
	public List<Object> list() {
		// TODO Auto-generated method stub
		return historico;
	}
}

	

