package uz.learn.core.entity;

import java.math.BigDecimal;
import java.util.List;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Cacheable
@Table(name = "orders",schema = "dbo")
public class Order extends PanacheEntity {
	public String userName;
	public BigDecimal totalPrice;

	// BillingAddress
	public String firstName;
	public String lastName;
	public String rmailAddress;
	public String addressLine;
	public String country;
	public String state;
	public String zipCode;

	// Payment
	public String cardName;
	public String cardNumber;
	public String expiration;
	public String CVV;
	public PaymentMethod paymentMethod;
	
	public static Uni<List<Order>> findByUserName(String userName){
		return list("userName", userName);
	}
}

enum PaymentMethod {
	CREDIT_CARD, DEBIT_CARD, PAYPAL
}

