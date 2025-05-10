import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RsWordCounterTest {

    @Test
    @DisplayName("Should cover part of all vertices")
    void shouldCoverPartOfAllVertices() {
        final RSWordCounter sut = new RSWordCounter();
        final int obtained = sut.count("error case");
        assertThat(obtained).isOne();
    }

}
