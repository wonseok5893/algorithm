package standard;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class XBinaryExpression {
    public static void main(String[] args) {
        int a = 10;
        int binA = 0b10;
        int octA = 010;
        int hexA = 0x10;

        //정수 -> 진수로 표현(return 문자열)
        String aBinary = Integer.toBinaryString(a);
        String aOctBinary = Integer.toOctalString(a);
        String aHexBinary = Integer.toHexString(a);
        System.out.println("--------------------");
        //진수 리터럴 -> 정수
        System.out.println(binA);
        System.out.println(octA);
        System.out.println(hexA);
        System.out.println();
        System.out.println("---------------------");
        //음수 표기
        int minusA = -10;
        String minusABinary = Integer.toBinaryString(minusA);
        System.out.println(minusABinary);
        System.out.println("---------------------");
        //음수 a 와 양수 a의 관계
        System.out.println("a: "+aBinary);
        System.out.println("-a: "+ minusABinary);
        System.out.println("a^-a: "+ Integer.toBinaryString(a^minusA));
        System.out.println("a&-a: "+Integer.toBinaryString(a&minusA));
        System.out.println("a|-1: "+Integer.toBinaryString(a|minusA));

        System.out.println("-a에 a&-1를 더하면: a^-a가 된다? ");
        System.out.println(minusA+(a&minusA));
        System.out.println(minusA^a);

        int b = -20;
        Integer.toUnsignedString(a);

    }
}
