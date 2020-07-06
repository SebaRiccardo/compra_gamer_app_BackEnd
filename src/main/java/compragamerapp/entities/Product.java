package compragamerapp.entities;

import javax.persistence.*;
import javax.websocket.Encoder.Binary;
import java.sql.Blob;
import java.util.List;



@Entity 
@Table(name= "products", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Product {
    
    @Id
 	@GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;

    @Column(name="price")
    private float price;
       
    @Column(name = "type")
    private String type;
        
    @Column(name = "stock_Status")
    private String stockStatus;
    
    @Column(name = "product_image")
    private Blob productImage;

    @OneToMany(mappedBy = "productToPurchase",cascade = CascadeType.ALL)
    private List<ItemToPurchase> item;

    public Product(){

    }

    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
                this.type = type;
        }
	public String getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}
	
    public Blob getProductImage() {
        return productImage;
    }

    public void setProductImage(Blob productImage) {
        this.productImage = productImage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    

}
		