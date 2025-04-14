import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {

    private String str;
    private String open;
    private String close;


    @Test
    @DisplayName("Testando str null")
    public void testingNullStr(){
       assertThat(StringUtils.substringsBetween(str = null, open = "a", close = "c")).isNull();
    }

    @Test
    @DisplayName("Testando str vazio")
    public void testingEmptyStr(){
        assertThat(StringUtils.substringsBetween(str = "", open = "a", close = "c")).isEmpty();
    }

    @Test
    @DisplayName("Testando open null")
    public void testingNullOpen(){
        assertThatThrownBy(() -> StringUtils.substringsBetween(str = "abc", open = null, close = "c"));
    }
}
