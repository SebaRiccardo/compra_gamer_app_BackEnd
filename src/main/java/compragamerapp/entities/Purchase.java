package compragamerapp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "purchases", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Purchase {
      
    
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long nro;
  
    @Column(name = "amount")
    private float amount;
    
    @Column(name = "date")
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="client_id",nullable = false)
    private Client client;

    @OneToMany(mappedBy = "purchase",cascade = CascadeType.ALL)
    private List<Product> purchasedProducts;
    
	public Purchase(float amount, Date date) {
		
		this.amount = amount;
		this.date = date;
	}    


	public long getNro() {
		return nro;
	}
	public void setNro(long nro) {
		this.nro = nro;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}