package BlockChain.service;

import BlockChain.domain.Block;
import BlockChain.usecase.CalculateHash;
import BlockChain.usecase.PoA;

import java.util.Date;

public class PoAService {

	public static void usePoa(String inputKey) {
		Block attendanceBlock = new Block("You received 1 BTC from unknown user", "0", new Date().getTime());

		CalculateHash calculateHash = new CalculateHash(attendanceBlock);
		PoA poA = new PoA(attendanceBlock, calculateHash);

		String authorizeHash = poA.mineBlock(inputKey);

		if (authorizeHash != null) {
			System.out.printf("최종 Hash는 다음과 같습니다: " + authorizeHash);
		}
	}
}
