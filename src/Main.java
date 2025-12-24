import BlcokChain.domain.Block;
import BlcokChain.usecase.CalculateHash;
import BlcokChain.usecase.PoW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("작업증명은 1, 권위증명은 2");
		int select = Integer.parseInt(br.readLine());

		if (select == 1) {
			usePow();
		}
	}

	public static void usePow() {
		// 맨 앞 블록 생성
		Block genesisBlock = new Block("the first Block", "0", new Date().getTime());

		// 해시 생성
		CalculateHash calculateHash = new CalculateHash(genesisBlock);
		PoW pow = new PoW(genesisBlock, calculateHash);

		/**
		 * 채굴 시작(PoW)
		 * difficulty가 높을 수록 해시에서 "0"을 더 요구
		 * -> 고성능 요구
		 * -> 맥북이니까 적당한 선에서
		 */

		int difficulty = 2;
		System.out.println("채굴 시작");

		String minedHash = pow.mineBlock(difficulty);

		// 채굴 결과
		System.out.println("최종 Nonce는 다음과 같습니다.\n" + genesisBlock.getNonce());
		System.out.println("최종 Hash는 다음과 같습니다.\n" + minedHash);
	}
}