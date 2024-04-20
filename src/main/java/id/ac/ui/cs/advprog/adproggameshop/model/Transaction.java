package id.ac.ui.cs.advprog.adproggameshop.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "userId")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "userId")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Game product;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "total", nullable = false, scale = 2)
    private double total;

    public Transaction() {}

    public Transaction(User buyer, User seller, Game product, Date date, int amount, double total) {}

    public Transaction(User buyer, User seller, Game product, Date date) {
        this.buyer = buyer;
        this.seller = seller;
        this.product = product;
        this.date = date;
        this.amount = amount;
        this.total = total;
    }
}