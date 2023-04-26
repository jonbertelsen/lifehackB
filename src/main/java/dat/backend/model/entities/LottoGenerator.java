package dat.backend.model.entities;

import java.util.Random;

public class LottoGenerator {

    private Random random;

    public LottoGenerator (){
        random = new Random();
    }

    public int generateRandomNumber() {
        return random.nextInt(35) + 1;
    }
}
