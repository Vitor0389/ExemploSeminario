import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveTest {

    private static List<Object> list = new ArrayList<>();
    @Test
    @DisplayName("Testando remover objeto nulo de lista não vazia")
    public void testingRemovingNullObjectFromValidList(){

        Object dummy = new Object();
        Object dummy2 = null;
        Object dummy3 = null;

        list.add(dummy);
        list.add(dummy2);
        list.add(dummy3);

        assertThat(list.remove(dummy2)).isTrue();
        assertThat(list.remove(dummy3)).isTrue();
    }

    @Test
    @DisplayName("Testando remover objeto nulo de lista vazia")
    public void testingRemovingNullObjectFromEmptyList(){

        assertThat(list.remove(null)).isFalse();

    }

    @Test
    @DisplayName("Testando remover objeto válido de lista vazia")
    public void testingRemovingValidObjectFromEmptyList(){

        Object dummy = new Object();


        assertThat(list.remove(dummy)).isFalse();
    }

    @Test
    @DisplayName("Testando remover objeto válido de lista não vazia")
    public void testingRemovingValidObjectFromValidList(){

        Object dummy = new Object();
        Object dummy2 = new Object();
        Object dummy3 = new Object();

        list.add(dummy);
        list.add(dummy2);
        list.add(dummy3);

        assertThat(list.remove(dummy2)).isTrue();
        assertThat(list.remove(dummy3)).isTrue();

    }




}
