package BlockChain.usecase;

import BlockChain.domain.Block;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculateHash {

	private final Block block;

	public CalculateHash(Block block) {
		this.block = block;
	}

	// 해싱하기 위환 과정
	public String calculateHash() {
		String dataToHash = block.getPreviousHash() // 이전 해시값
				+ Long.toString(block.getTimeStamp()) // 타임스탬프 값
				+ Integer.toString(block.getNonce()) // 논스
				+ block.getData(); // 데이터 값들을 합쳐서 하나의 긴 문자열로 변경

		MessageDigest digest = null; // 자바에서 지원되는 암호화 클래스
		byte[] bytes = null;

		try {
			digest = MessageDigest.getInstance("SHA-256"); // SHA-256 해시 사용
			bytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) { // 예외 처리
			throw new RuntimeException(e);
		}

		StringBuffer buffer = new StringBuffer();
		for (byte b : bytes) {
			buffer.append(String.format("%02x", b)); // %02x -> 바이트를 2자리 소문자 16진수로 포멧팅
		}
		return buffer.toString();
	}
}
