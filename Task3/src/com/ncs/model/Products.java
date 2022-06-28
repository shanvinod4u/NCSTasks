package com.ncs.model;



public class Products  {

		private int productId;
		private String productName;
		private int productPrice;
		private int purchasedBy;
		
		public Products(String productName, int productPrice) {
			super();
			this.productName = productName;
			this.productPrice = productPrice;
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

		public int getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		

		public int getPurchasedBy() {
			return purchasedBy;
		}

		public void setPurchasedBy(int purchasedBy) {
			this.purchasedBy = purchasedBy;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + productId;
			result = prime * result + ((productName == null) ? 0 : productName.hashCode());
			result = prime * result + productPrice;
			result = prime * result + purchasedBy;
			return result;
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
			if (productId != other.productId)
				return false;
			if (productName == null) {
				if (other.productName != null)
					return false;
			} else if (!productName.equals(other.productName))
				return false;
			if (productPrice != other.productPrice)
				return false;
			if (purchasedBy != other.purchasedBy)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Products [productId=" + productId + ", productName=" + productName + ", productPrice="
					+ productPrice + ", purchasedBy=" + purchasedBy + "]";
		}
		
		


						
	
}
