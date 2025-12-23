package BlcokChain.usecase;

import BlcokChain.domain.Block;

public class PoW {

	private final Block block;
	private final CalculateHash calculateHash;

	public PoW(Block block, CalculateHash calculateHash) {
		this.block = block;
		this.calculateHash = calculateHash;
	}

	public String mineBlock(int prefix) {
		String prefixString = new String(new char[prefix]).replace("\0", "0");
		while (block.getHash() != null ||!block.getHash().substring(0, prefix).equals(prefixString)) {
			block.setNonce(block.getNonce() + 1);

			String newHash = calculateHash.calculateHash();
			block.setHash(newHash);

		}
		return block.getHash();
	}
}
