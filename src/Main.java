import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static BlockChain.service.PoAService.usePoa;
import static BlockChain.service.PoWService.usePow;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("작업증명은 1, 권위증명은 2를 입력해주세요: ");
		int select = Integer.parseInt(br.readLine());

		if (select == 1) {
			usePow();
		} else if (select == 2) {
			System.out.printf("시크릿키를 입력해주세요: ");
			String secretKey = br.readLine();
			usePoa(secretKey);
		}
	}

	// PoW(작업증명 방식)
	public static void usePow() {
		// 맨 앞 블록 생성
		Block genesisBlock = new Block("the first Block", "0", new Date().getTime());

		// 해시 생성
		CalculateHash calculateHash = new CalculateHash(genesisBlock);
		PoW pow = new PoW(genesisBlock, calculateHash);

		int difficulty = 3;
		System.out.println("채굴 시작");

		String minedHash = pow.mineBlock(difficulty);

		// 채굴 결과
		System.out.println("최종 Nonce는 다음과 같습니다.\n" + genesisBlock.getNonce());
		System.out.println("최종 Hash는 다음과 같습니다.\n" + minedHash);
	}

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