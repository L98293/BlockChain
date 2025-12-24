package BlcokChain.usecase;

import BlcokChain.domain.Block;

public class PoA {

	private final Block block;
	private final CalculateHash calculateHash;

	public PoA(Block block, CalculateHash calculateHash) {
		this.block = block;
		this.calculateHash = calculateHash;
	}

	public String mineBlock(int prefix, String adminKey) {
		if (!"DkOGE5v3ZjEDzY/xgsdTyQVPD0cNy47hOr6UQCQsoyE=".equals(adminKey)) {
			System.out.println("승인되지않은 사용자 입니다.");
			return null;
		}

		String prefixString = new String(new char[prefix]).replace("\0", "0");

		if (block.getHash() == null) {
			block.setHash(calculateHash.calculateHash());
		}

		System.out.println("작업 중");

		while (!block.getHash().substring(0, prefix).equals(prefixString)) {
			block.setNonce(block.getNonce() + 1);

			String newHash = calculateHash.calculateHash();
			block.setHash(newHash);

			System.out.printf("현재 Nonce: %d\n", block.getNonce());
		}
		System.out.println("작업이 완료되었습니다.");
		return block.getHash();
	}
}
