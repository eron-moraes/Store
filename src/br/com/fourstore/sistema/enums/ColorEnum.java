package br.com.fourstore.sistema.enums;

import java.util.HashMap;
import java.util.Map;

public enum ColorEnum {
	
	
	VERDE("GRE"), 
	AZUL("BLU"), 
	VERMELHO("RED"), 
	PRETO("BLA");
	
	String desc;
	
	private static final Map<String, ColorEnum> getColor = new HashMap<>();
	
	static {
		for(ColorEnum color: ColorEnum.values()) {
			getColor.put(color.getDesc(), color);
		}
	}
	
	public static ColorEnum getColorEnum(String desc) {
		return getColor.get(desc);
	}
	
	ColorEnum(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	
}
