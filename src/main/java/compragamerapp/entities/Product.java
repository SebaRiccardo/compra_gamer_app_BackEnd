package compragamerapp.entities;

import javax.persistence.*;
import javax.websocket.Encoder.Binary;
import java.sql.Blob;



@Entity 
@Table(name= "products", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Product {
    
    @Id
 	@GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
       
    @Column(name = "type")
    private String type;
        
    @Column(name = "stock_Status")
    private String stockStatus;
    
    @Column(name = "product_image")
    private Blob productImage;
        
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="purchase_id",nullable = false)
    private Purchase purchase;
        
    public Product(String title, String type, String stockStatus, Blob productImage, int quantity) {
              
                this.title = title;
                this.type = type;
                this.stockStatus = stockStatus;
                this.productImage = productImage;
                this.quantity = quantity;  
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
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    public Purchase getPurchase() {
            return purchase;
    }

    public void setPurchase(Purchase purchase) {
            this.purchase = purchase;
    }

    public Blob getProductImage() {
        return productImage;
    }

    public void setProductImage(Blob productImage) {
        this.productImage = productImage;
    }
    

}
		