package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FetchGoogleAddr {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.360kb.com/kb/2_122.html");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "UTF-8");
        BufferedReader bufReader = new BufferedReader(input);
        String line = "";
        Map<String, String> hostToIpMap = HostUtil.readFromIpHostFile();
        while ((line = bufReader.readLine()) != null) {
            String regex = "^(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);
            while (m.find()) {
                line = (line.replace("&nbsp;", " ").replaceAll("<br />", ""));
                HostUtil.readLine(hostToIpMap, line);
            }
        }
        HostUtil.writeIpHostToReader(hostToIpMap);
    }
}
