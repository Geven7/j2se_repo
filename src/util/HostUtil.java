package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Geven
 * @version 1.0
 */
public class HostUtil {

    public static final String hostFilePath = "C:\\Windows\\System32\\drivers\\etc\\hosts";

    // public static final String hostFilePath="/etc/hosts";

    // regex of ip and host
    public static final String REGEX_IP_HOST = "^(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s*(\\d|.*)";

    public static void addHostBinding(String ip, String host) {
        Map<String, String> hostToIpMap = readFromIpHostFile();
        hostToIpMap.put(host, ip);
        writeIpHostToReader(hostToIpMap);
    }

    public static void deleteHostBinding(String ip, String host) {
        Map<String, String> hostToIpMap = readFromIpHostFile();
        if (hostToIpMap != null && hostToIpMap.containsKey(host)) {
            hostToIpMap.remove(host);
        }
        writeIpHostToReader(hostToIpMap);
    }

    public static Map<String, String> readLine(Map<String, String> hostToIpMap, String content) {
        content = content.trim();
        Pattern pattern = Pattern.compile(REGEX_IP_HOST);
        Matcher matcher = pattern.matcher(content);
        if (matcher.matches()) {
            hostToIpMap.put(matcher.group(2), matcher.group(1));
        }
        return hostToIpMap;
    }

    public static Map<String, String> readFromIpHostFile() {
        Map<String, String> hostToIpMap = new LinkedHashMap<String, String>();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(hostFilePath));
            String str = null;
            while ((str = bufferReader.readLine()) != null) {
                if (str != null) {
                    readLine(hostToIpMap, str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferReader.close();
            } catch (Exception e) {

            }
        }
        return hostToIpMap;
    }

    public static void writeIpHostToReader(Map<String, String> hostToIpMap) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(hostFilePath));
            Iterator<Entry<String, String>> iter = hostToIpMap.entrySet().iterator();
            while (iter.hasNext()) {
                Entry<String, String> entry = iter.next();
                bufferedWriter.write(entry.getValue() + "   " + entry.getKey() + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (Exception e) {

            }
        }
    }

    public static void test() throws IOException, InterruptedException {
        Map<String, String> readFromIpHostFile = readFromIpHostFile();
        readFromIpHostFile.put("www.baidu.com", "127.0.0.1");
        writeIpHostToReader(readFromIpHostFile);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        test();
        // updateDNS();

    }

}
