package util;

public class XmlUtils {
    public static String specialCharReplace(String originXml) {
        String resultXml = "";
        // 替换"&"
        while (!originXml.equals(resultXml)) {
            resultXml = originXml;
            originXml = resultXml.replaceAll("(<msg>.*)(&(?!amp;))(.*</msg>)", "$1&amp;$3");
        }
        System.out.println("firstly replace \"&\": " + originXml);

        // 替换“<”
        resultXml = "";
        while (!originXml.equals(resultXml)) {
            resultXml = originXml;
            originXml = resultXml.replaceAll("(<msg>.*)(<)(.*</msg>)", "$1&lt;$3");
        }
        System.out.println("then replace \"<\": " + originXml);

        // 替换“<”
        resultXml = "";
        while (!originXml.equals(resultXml)) {
            resultXml = originXml;
            originXml = resultXml.replaceAll("(<msg>.*)(>)(.*</msg>)", "$1&gt;$3");
        }
        System.out.println("finally replace \">\": " + originXml);
        return resultXml;
    }
}
