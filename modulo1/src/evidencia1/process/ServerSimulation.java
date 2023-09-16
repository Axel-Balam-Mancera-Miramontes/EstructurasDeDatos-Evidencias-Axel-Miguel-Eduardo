package evidencia1.process;

import evidencia1.utils.Cola;

import java.util.Optional;
import java.util.Random;

public class ServerSimulation{
    private Random random;

    public static int getNumberOfProcesses(){
        return 60;
    }

    public static <E> void loadServer(Cola<E> server, E data) {
        server.push(data);
    }

    public static <E> Optional<E> processProcess(Cola<E> serverA, Cola<E> serverB, double probability) {
        if (probability <= 0.3) {
            if (!serverA.isEmpty()) {
                return serverA.pop();
            }
        }
        if (!serverB.isEmpty()) {
            return serverB.pop();
        }
        return null;
    }
}
