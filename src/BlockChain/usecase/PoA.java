package BlockChain.usecase;

import BlockChain.domain.Block;

public class PoA {

	private final Block block;
	private final CalculateHash calculateHash;

	public PoA(Block block, CalculateHash calculateHash) {
		this.block = block;
		this.calculateHash = calculateHash;
	}

	public String mineBlock(String adminKey) {
		if (!"DkOGE5v3ZjEDzY/xgsdTyQVPD0cNy47hOr6UQCQsoyE=".equals(adminKey)) {
			throw new RuntimeException("권한없음");
		}
		block.setHash(calculateHash.calculateHash());

		return block.getHash();
	}
}
