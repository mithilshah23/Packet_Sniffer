import java.io.IOException;

class NormalTraffic {
    NormalTraffic() throws IOException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            new SinglePacketSender();
            Thread.sleep(10);
        }
    }
}