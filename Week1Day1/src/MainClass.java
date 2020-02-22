import java.math.BigInteger;

import javax.xml.bind.DatatypeConverter;

public class MainClass {

	public static void main(String[] args){
		
		String ly = "4c6f6f6b2c0a496620796f7520686"
				+ "1642c0a4f6e6520636f757273652c20"
				+ "6f6e65206f70706f7274756e6974792"
				+ "00a546f207365697a65206576657279"
				+ "7468696e6720796f752065766572207"
				+ "7616e74656420696e206f6e65207365"
				+ "6d65737465720a576f756c6420796f7"
				+ "5206c6561726e2069740a4f72206a75"
				+ "7374206c657420697420736c6970206"
				+ "279206368656174696e67";

		System.out.println(new String(DatatypeConverter.parseHexBinary(ly)));
	}

}
