package BlcokChain.domain;

public class Block {
	private String hash;
	private String previousHash;
	private String data;
	private long timeStamp;
	private int nonce;

	public Block(String data, String previousHash, long timeStamp) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = timeStamp;
	}

	/**
	 * Getter 영역
	 */
	public String getHash() {
		return hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public String getData() {
		return data;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public int getNonce() {
		return nonce;
	}

	/**
	 * Setter 영역
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
}