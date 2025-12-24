package BlcokChain.service;

import BlcokChain.domain.Block;
import BlcokChain.usecase.CalculateHash;
import BlcokChain.usecase.PoA;

import java.util.Date;

public class PoAService {

	public static void usePoa(String inputKey) {
		Block attendanceBlock = new Block("1 BTC", "0", new Date().getTime());

		CalculateHash calculateHash = new CalculateHash(attendanceBlock);
		PoA poA = new PoA(attendanceBlock, calculateHash);

		System.out.println("증명 시작");

		String authorizeHash = poA.mineBlock(0, inputKey);

		if (authorizeHash != null) {
			System.out.println("최종 Hash는 다음과 같습니다.\n" + authorizeHash);
		}
	}
}
