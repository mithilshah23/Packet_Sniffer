import java.io.IOException;

class AttackTraffic {
    AttackTraffic() throws IOException, InterruptedException {
        for (int i = 0; i < 1050; i++) {
            new SinglePacketSender();
            Thread.sleep(10);
        }
    }
}
