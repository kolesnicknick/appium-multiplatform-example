import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class BrowserProxxyTest {
    WebDriver webDriver;
    BrowserMobProxyServer server;

    @Before
    public void setup() {
        server = new BrowserMobProxyServer();
        server.start();

        ChromeOptions options = new ChromeOptions();
        options.setProxy(ClientUtil.createSeleniumProxy(server));
        webDriver = new ChromeDriver(options);

        webDriver.get("https://google.com");

    }


    @Test
    public void saveHar() {
        server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        server.start();

        server.newHar("wix");

        webDriver.get("https://www.wix.com");

        Har har = server.getHar();
        try {
            har.writeTo(new File(System.getProperty("user.dir") + "/src/main/logs/hw2.har"));
        } catch (IOException ign) {
            System.out.println("Failed to write to file");
        }
    }

    @Test
    public void saveConsoleLogsToFile() {
        server.start();
        webDriver.get("https://www.wix.com");
        Har har = server.getHar();

        Set<String> logs = webDriver.manage().logs().getAvailableLogTypes();

        String pathToFile = System.getProperty("user.dir") + "/src/main/logs/hw2logs.txt";
        try {
            new File(System.getProperty("user.dir") + "/src/main/logs/hw2logs.txt");

            String str = "World";
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile, true));
            for (String log : logs) {
                writer.append('\n');
                writer.append(str);
            }
            writer.close();

        } catch (IOException ign) {
            System.out.println("Failed to write to file");
        }
    }

    @Test
    public void mobileUserAgentTest() {
        server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().add("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4");
            return null;
        });

        webDriver.get("https://www.wix.com");
    }


    @Test
    public void interceptRequest() {
        server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");

            request.headers().add("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4");
            request.headers().add("Accept-Language", "es");
            request.headers().add("Content-Language", "es_es");


            return null;
        });

        webDriver.get("http://www.fr.wix.com");
    }

    @Test
    public void saveConsoleLogs() {

    }


    @After
    public void tearDown() {
        webDriver.quit();
        server.stop();
    }
}
