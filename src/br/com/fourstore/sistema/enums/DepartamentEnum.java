package br.com.fourstore.sistema.enums;

import java.util.HashMap;
import java.util.Map;

public enum DepartamentEnum {
	
	VESTUARIO("100"),
	CALÇADO("200"),
	ACESSÓRIO("300"),
	PERFUMARIA("400");
	
	String cod;
	
	private static final Map<String, DepartamentEnum> getDepartament = new HashMap<>();
	
	static {
		for(DepartamentEnum departament: DepartamentEnum.values()) {
			getDepartament.put(departament.getCod(), departament);
		}
	}
	
	public static DepartamentEnum getDepartamentEnum(String cod) {
		return getDepartament.get(cod);
	}

	DepartamentEnum(String cod) {
		this.cod = cod;
	}

	public String getCod() {
		return cod;
	}
	
	
}
