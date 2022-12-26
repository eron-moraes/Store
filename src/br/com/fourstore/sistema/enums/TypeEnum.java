package br.com.fourstore.sistema.enums;

import java.util.HashMap;
import java.util.Map;

public enum TypeEnum {
	
	CALCA("A"),
	CAMISA("B"),
	BLUSA("C"),
	CALCADO("D");

	String typ;
	
private static final Map<String, TypeEnum> getType = new HashMap<>();
	
	static {
		for(TypeEnum type: TypeEnum.values()) {
			getType.put(type.getTyp(), type);
		}
	}
	
	public static TypeEnum getTypeEnum(String typ) {
		return getType.get(typ);
	}
	
	TypeEnum(String typ) {
		this.typ = typ;
	}
	public String getTyp() {
		return typ;
	}
	
	
}
