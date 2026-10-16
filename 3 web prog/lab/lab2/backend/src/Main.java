import com.fastcgi.FCGIInterface;
import com.google.gson.Gson;
import resources.Point;
import resources.Submittion;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Main {
    private static final Gson gson = new Gson();
    public static void main(String[] args) throws IOException {
        var fcgi = new FCGIInterface();
        while (fcgi.FCGIaccept() >= 0) {
            long start = System.nanoTime();
            String content;
            String method = fcgi.request.params.getProperty("REQUEST_METHOD");
            if (method.equalsIgnoreCase("GET")) {
                String query = fcgi.request.params.getProperty("QUERY_STRING");
                String[] params = query.split("&");
                HashMap<String, String> map = new HashMap<>();
                for (String s : params) {
                    map.put(s.split("=")[0], s.split("=")[1]);
                }
                if (map.containsKey("x") && map.containsKey("y") && map.containsKey("r")) {
                    content = processRequest(start, new Point(Integer.valueOf(map.get("x")), Float.parseFloat(map.get("y")), Integer.valueOf(map.get("r"))));
                    var httpResponse = """
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: %d

%s
""".formatted(content.getBytes(StandardCharsets.UTF_8).length, content);
                    System.out.println(httpResponse);
                } else {
                    var httpResponse = """
HTTP/1.1 409 BAD REQUEST
Content-Type: application/json
Content-Length: %d

""".formatted(0);
                    System.out.println(httpResponse);
                }
            } else if (method.equalsIgnoreCase("POST")) {
                content = processRequest(start, gson.fromJson(readRequestBody(), Point.class));
                var httpResponse = """
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: %d

%s
""".formatted(content.getBytes(StandardCharsets.UTF_8).length, content);
                System.out.println(httpResponse);
            } else if (method.equalsIgnoreCase("OPTIONS")){
                var httpResponse = """
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: %d

""".formatted(0);
                System.out.println(httpResponse);
            }
            else {
                var httpResponse = """
HTTP/1.1 405 METHOD NOT ALLOWED
Content-Type: application/json
Content-Length: %d

""".formatted(0);
                System.out.println(httpResponse);
            }
        }
    }
    private static String readRequestBody() throws IOException {
        FCGIInterface.request.inStream.fill();
        var contentLength = FCGIInterface.request.inStream.available();
        var buffer = ByteBuffer.allocate(contentLength);
        var readBytes =
                FCGIInterface.request.inStream.read(buffer.array(), 0,
                        contentLength);
        var requestBodyRaw = new byte[readBytes];
        buffer.get(requestBodyRaw);
        buffer.clear();
        return new String(requestBodyRaw, StandardCharsets.UTF_8);
    }

    static String processRequest(long start, Point point){
        return gson.toJson(new Submittion(start, point));
    }
}

