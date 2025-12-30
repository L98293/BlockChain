package BlockChain.service;

import BlockChain.domain.Block;
import BlockChain.usecase.CalculateHash;
import BlockChain.usecase.PoW;

import java.util.Date;

public class PoWService {

	// PoW(작업증명 방식)
	public static void usePow() {
		// 맨 앞 블록 생성
		Block genesisBlock = new Block("I send 1 BTC to you", "0", new Date().getTime());

		// 해시 생성
		CalculateHash calculateHash = new CalculateHash(genesisBlock);
		PoW pow = new PoW(genesisBlock, calculateHash);

		int difficulty = 1;


		String minedHash = pow.mineBlock(difficulty);
		System.out.println("채굴 시작");
		// 채굴 결과
		System.out.println("최종 Nonce는 다음과 같습니다.\n" + genesisBlock.getNonce());
		System.out.println("최종 Hash는 다음과 같습니다.\n" + minedHash);
	}
}
