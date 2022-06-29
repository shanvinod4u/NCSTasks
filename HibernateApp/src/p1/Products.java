package p1;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Products {

	@Column(name="productId")
	@Id 
	private int productId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="price")
	private int price;
	
	@Column(name="reviewRatings")
	private int reviewRatings;
	
	@Column(name="category")
	private String category;

	public Products(int productId, String productName, int price, int reviewRatings, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.reviewRatings = reviewRatings;
		this.category = category;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getReviewRatings() {
		return reviewRatings;
	}

	public void setReviewRatings(int reviewRatings) {
		this.reviewRatings = reviewRatings;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, price, productId, productName, reviewRatings);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(category, other.category) && price == other.price && productId == other.productId
				&& Objects.equals(productName, other.productName) && reviewRatings == other.reviewRatings;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", reviewRatings=" + reviewRatings + ", category=" + category + "]";
	}
	
	
}
