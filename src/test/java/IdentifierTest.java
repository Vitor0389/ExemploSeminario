import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;



public class IdentifierTest {

    private final Identifier identifierTest = new Identifier();

    @ParameterizedTest
    @DisplayName("Testando entradas válida com tamanho menor que 6")
    @ValueSource(strings = {"JJJJJ"})
    public void testingStringLengthLessThanSix(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("Testando entrada válida com tamanho igual a 6")
    @ValueSource(strings = {"JJJJJJ"})
    public void testingStringLengthEqualToSix(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("Testando entrada com tamanho maior que 6")
    @ValueSource(strings = {"JJJJJJJ"})
    public void testingStringLengthBiggerThanSix(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("Testando entrada vazia")
    @ValueSource(strings = {""})
    public void testingEmptyString(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("Testando strings que começam com número")
    @ValueSource(strings = {"543J"})
    public void testingStartWithNumberString(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(false);


    }

    @ParameterizedTest
    @DisplayName("Testando string nula")
    @NullSource
    public void testingIfNullThrowsException(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("Testando entrada válida")
    @ValueSource(strings = {"A43BJK"})
    public void testingValidInput(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("Testando String que começa com espaço vazio e contém espaços dentro")
    @ValueSource(strings = {" A43BJK", " A 43BJK"})
    public void testingIfHasEmptySpaces(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(false);

    }
    
    @ParameterizedTest
    @DisplayName("Testando csv")
    @CsvSource({"' A43BJK '","' A 43BJK'"})
    public void testingIfHasEmptySpacesCsv(String stringTeste){
        assertThat(identifierTest.isValidIdentifier(stringTeste)).isEqualTo(false);

    }




}
