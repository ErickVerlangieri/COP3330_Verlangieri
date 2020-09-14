
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncrypterTest{

    @Test

    void testEncrypt1234to0189() {

        Encrypter e = new Encrypter();
        Decrypter d = new Decrypter();
        assertEquals("0189", e.encrypt("1234"));
        assertEquals("1234", d.decrypt("0189"));

    }
}

