import java.util.Arrays;

public class Recursao{

    // 1) potencia(base, exp)
    public static long potencia(int base, int exp) {
        // Caso base: qualquer número elevado a 0 vale 1
        if (exp == 0) {
            return 1;
        }
        // Caso recursivo: base^exp = base * base^(exp - 1)
        return base * potencia(base, exp - 1);
    }

    // 2) somaDigitos(n)
    public static int somaDigitos(int n) {
        // Trata negativos somando os dígitos do valor absoluto
        if (n < 0) {
            return somaDigitos(-n);
        }
        // Caso base: não há mais dígitos para somar
        if (n == 0) {
            return 0;
        }
        // Caso recursivo: último dígito + soma dos dígitos restantes
        return n % 10 + somaDigitos(n / 10);
    }

    // 3) inverter(s)
    public static String inverter(String s) {
        // Caso base: String vazia invertida é ela mesma
        if (s.isEmpty()) {
            return "";
        }
        // Caso recursivo: inverte o resto e coloca o primeiro caractere no final
        return inverter(s.substring(1)) + s.charAt(0);
    }

    // 4) ehPalindromo(s)
    public static boolean ehPalindromo(String s) {
        return ehPalindromo(s, 0, s.length() - 1);
    }

    private static boolean ehPalindromo(String s, int inicio, int fim) {
        // Caso base: os índices se encontraram ou se cruzaram -> é palíndromo
        if (inicio >= fim) {
            return true;
        }
        // Caso base: extremidades diferentes -> não é palíndromo
        if (s.charAt(inicio) != s.charAt(fim)) {
            return false;
        }
        // Caso recursivo: verifica a parte interna da String
        return ehPalindromo(s, inicio + 1, fim - 1);
    }

    // 5) maior(v)
    public static int maior(int[] v) {
        if (v.length == 0) {
            throw new IllegalArgumentException("O vetor não pode ser vazio");
        }
        return maior(v, 0);
    }

    private static int maior(int[] v, int i) {
        // Caso base: último elemento é o maior do trecho que resta
        if (i == v.length - 1) {
            return v[i];
        }
        // Caso recursivo: maior entre v[i] e o maior do restante do vetor
        int maiorDoResto = maior(v, i + 1);
        return v[i] > maiorDoResto ? v[i] : maiorDoResto;
    }

    // 6) movimentosHanoi(n)
    public static long movimentosHanoi(int n) {
        // Caso base: nenhum disco, nenhum movimento
        if (n == 0) {
            return 0;
        }
        // Caso recursivo: move n-1 discos duas vezes, mais o movimento do maior disco
        return 2 * movimentosHanoi(n - 1) + 1;
    }

    public static void main(String[] args) {
        System.out.println("=== 1) potencia ===");
        System.out.println("potencia(2, 10) = " + potencia(2, 10));
        System.out.println("potencia(5, 0) = " + potencia(5, 0));
        System.out.println("potencia(7, 1) = " + potencia(7, 1));

        System.out.println("\n=== 2) somaDigitos ===");
        System.out.println("somaDigitos(4721) = " + somaDigitos(4721));
        System.out.println("somaDigitos(0) = " + somaDigitos(0));
        System.out.println("somaDigitos(7) = " + somaDigitos(7));

        System.out.println("\n=== 3) inverter ===");
        System.out.println("inverter(\"recursao\") = \"" + inverter("recursao") + "\"");
        System.out.println("inverter(\"\") = \"" + inverter("") + "\"");
        System.out.println("inverter(\"a\") = \"" + inverter("a") + "\"");

        System.out.println("\n=== 4) ehPalindromo ===");
        System.out.println("ehPalindromo(\"arara\") = " + ehPalindromo("arara"));
        System.out.println("ehPalindromo(\"java\") = " + ehPalindromo("java"));
        System.out.println("ehPalindromo(\"\") = " + ehPalindromo(""));
        System.out.println("ehPalindromo(\"x\") = " + ehPalindromo("x"));

        System.out.println("\n=== 5) maior ===");
        int[] v1 = {3, 17, 8, 42, 5};
        int[] v2 = {9};
        int[] v3 = {-4, -1, -7};
        System.out.println("maior(" + Arrays.toString(v1) + ") = " + maior(v1));
        System.out.println("maior(" + Arrays.toString(v2) + ") = " + maior(v2));
        System.out.println("maior(" + Arrays.toString(v3) + ") = " + maior(v3));

        System.out.println("\n=== 6) movimentosHanoi ===");
        System.out.println("movimentosHanoi(10) = " + movimentosHanoi(10));
        System.out.println("movimentosHanoi(0) = " + movimentosHanoi(0));
        System.out.println("movimentosHanoi(1) = " + movimentosHanoi(1));
    }
}
