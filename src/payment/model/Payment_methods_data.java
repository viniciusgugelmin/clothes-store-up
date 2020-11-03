package payment.model;

import java.io.Serializable;

public class Payment_methods_data implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;

	public Payment_methods_data() {
	}

	public Payment_methods_data(Integer id, String type) {

		this.id = id;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Payment_methods_data other = (Payment_methods_data) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment_methods_data [id=" + id + ", type=" + type + "]";
	}

}