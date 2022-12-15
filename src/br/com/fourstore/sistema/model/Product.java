package br.com.fourstore.sistema.model;


import br.com.fourstore.sistema.enums.ColorEnum;
import br.com.fourstore.sistema.enums.DepartamentEnum;
import br.com.fourstore.sistema.enums.SizeEnum;
import br.com.fourstore.sistema.enums.TypeEnum;
import br.com.fourstore.sistemaUtils.Utils;

public class Product {
    private static int count = 1;

    private int id;
    private String nome;
    private Double preco;

    public void setId(int id) {
		this.id = id;
	}

	private String sku;
   
    private SizeEnum size;
    private TypeEnum type;
    private ColorEnum color;
    private DepartamentEnum departament;

    public Product(String sku, String nome, Double preco) {
    	
        this.id = count;
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
    
        Product.count += 1;
        parseSku();
    }

    public Product(String sku) {
	
	}

	public int getId() {
        return id;
    }
	

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
	
	
	public static int getCount() {
		return count;
	}

	public String getSku() {
		return sku;
	}

	public SizeEnum getSize() {
		return size;
	}

	public TypeEnum getType() {
		return type;
	}

	public ColorEnum getColor() {
		return color;
	}

	public DepartamentEnum getDepartament() {
		return departament;
	}
	
    public static void setCount(int count) {
		Product.count = count;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setSize(SizeEnum size) {
		this.size = size;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public void setColor(ColorEnum color) {
		this.color = color;
	}

	public void setDepartament(DepartamentEnum departament) {
		this.departament = departament;
	}

	public String toString() {
        return"Id " + this.getId() +
        		"\nSKU: " + this.getSku() +
        		"\nDescricao: " + this.getNome() +
        		"\nTamanho: " + this.getSize() +
        		"\nTipo: " + this.getType() +
        		"\nCor: " + this.getColor() +
                "\nDepartamento: " + this.getDepartament() +
                "\nPreco: " + Utils.doubleToString(this.getPreco());
    }
	
	private void parseSku() {
		
		this.size = SizeEnum.getSizeEnum(sku.substring(0,2));
		this.type = TypeEnum.getTypeEnum(sku.substring(2,3));
		this.color = ColorEnum.getColorEnum(sku.substring(3,6));
		this.departament = DepartamentEnum.getDepartamentEnum(sku.substring(6));

	}
   
}


