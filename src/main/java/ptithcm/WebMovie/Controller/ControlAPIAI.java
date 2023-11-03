package ptithcm.WebMovie.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@RestController
public class ControlAPIAI {
    @GetMapping("/connect-use-socket")
    public String random() throws IOException {
        Socket socket = new Socket("localhost", 8081);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("Hello from Java!"); // Gửi dữ liệu đến máy chủ Python
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String receivedJson = in.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        String name = null;
        try {
            JsonNode jsonNode = objectMapper.readTree(receivedJson);
            name = jsonNode.get("name").asText();
            String classj = jsonNode.get("class").asText();
            System.out.println(name);
            System.out.println(classj);
        } catch (Exception e){
            e.printStackTrace();
        }
        socket.close();
        return name;
    }
}
