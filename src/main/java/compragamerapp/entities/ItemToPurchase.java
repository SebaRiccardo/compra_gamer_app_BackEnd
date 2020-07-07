package compragamerapp.entities;

import javax.persistence.*;


@Entity
@Table(name= "purchasedProducts", uniqueConstraints={@UniqueConstraint(columnNames={"itemId"})})
public class ItemToPurchase{


    @Id
 	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long itemId;

    @Column(name="price_Per_Item")
    private float pricePerItem;

    @Column(name="quantity")
    private int quantity;

    @Column(name="product_id")
    private long product_id; 

    @Column(name="puchase_id")
    private long purchase_id;


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

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(long purchase_id) {
        this.purchase_id = purchase_id;
    }

}