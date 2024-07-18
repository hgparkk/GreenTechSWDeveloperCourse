package ch16_network;

public class Medicine {
	private String itemSeq; // 의약품 번호
	private String entpName; // 회사명
	private String itemName; // 의약품 이름
	private String efcyQesitm; // 증상

	public Medicine() {
	}

	public Medicine(String itemSeq, String entpName, String itemName, String efcyQuesitm) {
		this.itemSeq = itemSeq;
		this.entpName = entpName;
		this.itemName = itemName;
		this.efcyQesitm = efcyQuesitm;
	}

	public String getItemSeq() {
		return itemSeq;
	}

	public void setItemSeq(String itemSeq) {
		this.itemSeq = itemSeq;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getEfcyQesitm() {
		return efcyQesitm;
	}

	public void setEfcyQesitm(String efcyQesitm) {
		this.efcyQesitm = efcyQesitm;
	}

	@Override
	public String toString() {
		return "Medicine [itemSeq=" + itemSeq + ", entpName=" + entpName + ", itemName=" + itemName + ", efcyQuesitm="
				+ efcyQesitm + "]";
	}
}