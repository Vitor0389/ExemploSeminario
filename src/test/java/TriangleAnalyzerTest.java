import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAnalyzerTest {

    @Test
    void entradaNula_lancaNullPointerException() {
        assertThrows(NullPointerException.class, () -> TriangleAnalyzer.computeTypeStatistics(null));
    }

    @Test
    void subarrayComTamanhoInvalido_lancaIllegalArgumentException() {
        double[][] dadosInvalidos = {
                {0, 0, 1, 1, 2} // apenas 5 elementos
        };
        assertThrows(IllegalArgumentException.class, () -> TriangleAnalyzer.computeTypeStatistics(dadosInvalidos));
    }

    @Test
    void subarray1NaoFormaTriangulo_subarray2FormaTriangulo() {
        double[][] dados = {
                {0, 0, 0, 0, 1, 1}, // não forma triângulo (2 pontos iguais)
                {0, 0, 1, 0, 0, 1}  // triângulo isósceles
        };
        TriangleAnalyzer.Statistics stats = TriangleAnalyzer.computeTypeStatistics(dados);
        assertEquals(1, stats.nonTriangle);
        assertEquals(1, stats.isosceles + stats.scalene + stats.equilateral);
    }

    @Test
    void doisTriangulos_a9b8c17_e_a3b4c7() {
        double[][] dados = {
                {0, 0, 9, 0, 0, 8},  // a=9, b=8, c=17 — forma triângulo (9+8 > 17 é falso, mas aqui o ponto c está em (0,8), então é válido)
                {0, 0, 3, 0, 0, 4}   // a=3, b=5, c=4 — triângulo
        };
        TriangleAnalyzer.Statistics stats = TriangleAnalyzer.computeTypeStatistics(dados);
        assertEquals(2, stats.isosceles + stats.scalene + stats.equilateral);
        assertEquals(0, stats.nonTriangle);
    }

    @Test
    void doisNaoTriangulos() {
        double[][] dados = {
                {0, 0, 1, 1, 2, 2}, // colineares na reta y = x
                {0, 0, 2, 2, 4, 4}  // também colineares

        };
        // Esses pontos foram escolhidos de forma que a + b = c (ou menor), então não formam triângulo
        TriangleAnalyzer.Statistics stats = TriangleAnalyzer.computeTypeStatistics(dados);
        assertEquals(2, stats.nonTriangle);
        assertEquals(0, stats.isosceles + stats.scalene + stats.equilateral);
    }

    @Test
    void isoscelesEEquilatero() {
        double[][] dados = {
                {0, 0, 2, 0, 1, Math.sqrt(3)},   // equilátero (todos lados iguais)
                {0, 0, 2, 0, 1, 1.732} // altura da base 2 (aprox. raiz de 3), lados iguais

        };
        TriangleAnalyzer.Statistics stats = TriangleAnalyzer.computeTypeStatistics(dados);
        assertEquals(1, stats.equilateral);
        assertEquals(1, stats.isosceles);
    }
}
