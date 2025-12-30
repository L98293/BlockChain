package BlockChain.usecase;

import BlockChain.domain.Block;

public class PoW {

	private final Block block;
	private final CalculateHash calculateHash;

	public PoW(Block block, CalculateHash calculateHash) {
		this.block = block;
		this.calculateHash = calculateHash;
	}

	public String mineBlock(int prefix) {
		String prefixString = new String(new char[prefix]).replace("\0", "0");

		if (block.getHash() == null) {
			block.setHash(calculateHash.calculateHash());
		}

		while (block.getHash() != null && !block.getHash().substring(0, prefix).equals(prefixString)) {
			block.setNonce(block.getNonce() + 1);

			String newHash = calculateHash.calculateHash();
			block.setHash(newHash);

			System.out.printf("Nonce: %d | Hash: %s\n", block.getNonce(), newHash);
		}
		return block.getHash();
	}
}
