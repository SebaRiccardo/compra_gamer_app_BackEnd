package compragamerapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity 
@Table(name= "Product", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Product {
    
        @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
        private long id;

        private String title;
        private String type;
        private String stockStatus;
        private String productImage;
        private int quantity;
        private Purchase purchase;
        
        public Product(String title, String type, String stockStatus, String productImage, int quantity,Client c) {
              
                this.title = title;
                this.type = type;
                this.stockStatus = stockStatus;
                this.productImage = productImage;
                this.quantity = quantity;
                this.client =c;
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
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
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

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }
}
		