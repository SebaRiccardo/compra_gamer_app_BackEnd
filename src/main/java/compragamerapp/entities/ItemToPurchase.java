package compragamerapp.entities;

import javax.persistence.*;


@Entity
@Table(name= "itemsToPurchase", uniqueConstraints={@UniqueConstraint(columnNames={"itemId"})})
public class ItemToPurchase{


    @Id
 	@GeneratedValue(strategy= GenerationType.AUTO)
    private long itemId;

    @Column(name="price_Per_Item")
    private float pricePerItem;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="product_id",nullable = false)
    private Product productToPurchase; 

    @ManyToOne
    @JoinColumn(name="puchase_id",nullable =false)
    private Purchase purchase;


    public ItemToPurchase(){

    }
    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public float getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(float pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProductToPurchase() {
        return productToPurchase;
    }

    public void setProductToPurchase(Product productToPurchase) {
        this.productToPurchase = productToPurchase;
    }
/*
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
   */ 
}