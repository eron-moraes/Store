package br.com.fourstore.sistema.data;

import java.util.List;

public interface DataInterface {
	
public boolean save(Object object);
public boolean delete(Object object);
public boolean edit(Object object, Integer index);
public List<Object> list();

	

}
