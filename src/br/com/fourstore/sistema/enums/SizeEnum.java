package br.com.fourstore.sistema.enums;

import java.util.HashMap;
import java.util.Map;

public enum SizeEnum {
	
	P("10"),
	M("20"),
	G("30"),
	GG("40");
	
	String siz;
	
private static final Map<String, SizeEnum> getSize = new HashMap<>();
	
	static {
		for(SizeEnum size: SizeEnum.values()) {
			getSize.put(size.getSiz(), size);
		}
	}
	
	public static SizeEnum getSizeEnum(String siz) {
		return getSize.get(siz);
	}
	

	SizeEnum(String siz) {
		this.siz = siz;
	}

	public String getSiz() {
		return siz;
	}
	
	
}
