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
}