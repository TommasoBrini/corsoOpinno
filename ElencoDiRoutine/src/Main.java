import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ElencoDiRoutine elenco = new ElencoDiRoutine();

        Function<String, Integer> f1 = String::length;

        Function<String, Integer> f2 = str -> (int) str.chars().filter(c -> c == 'y').count();

        Function<String, Integer> f3 = Integer::parseInt;

        Function<String, Integer> f4 = str -> str.chars().sum();

        Function<String, Integer> f5 = str -> str.chars().filter(Character::isDigit).map(Character::getNumericValue).sum();

        elenco.addFunction(f1);
        elenco.addFunction(f2);
        elenco.addFunction(f3);
        elenco.addFunction(f4);
        elenco.addFunction(f5);

        elenco.esegui("12345y");
    }

}
