
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static boolean contains(Set<Integer> set, int x) {
        return set.contains(x);
    }


    public static Set<Integer> sum(Set<Integer> A, Set<Integer> B) {
        Set<Integer> rs = new HashSet<>(A);
        rs.addAll(B);
        return rs;
    }


    public static Set<Integer> intersect(Set<Integer> A, Set<Integer> B) {
        Set<Integer> rs = new HashSet<>(A);
        rs.retainAll(B);
        return rs;
    }


    public static Set<Integer> subtract(Set<Integer> A, Set<Integer> B) {
        Set<Integer> rs = new HashSet<>(A);
        rs.removeAll(B);
        return rs;
    }


    public static Set<String> Descartes(Set<Integer> A, Set<Integer> B) {
        Set<String> rs = new HashSet<>();
        for (int a : A) {
            for (int b : B) {
                rs.add("(" + a + ", " + b + ")");
            }
        }
        return rs;
    }


    public static boolean isReflex(Set<Integer> A, Set<String> R) {
        for (int a : A) {
            if (!R.contains("(" + a + ", " + a + ")")) {
                return false;
            }
        }
        return true;
    }


    public static boolean isSymmetry(Set<String> R) {
        for (String ab : R) {
            String[] elements = ab.replaceAll("[()]", "").split(", ");
            String ba = "(" + elements[1] + ", " + elements[0] + ")";
            if (!R.contains(ba)) {
                return false;
            }
        }
        return true;
    }


    public static boolean isTransite(Set<String> R) {
        for (String ab : R) {
            String[] elements1 = ab.replaceAll("[()]", "").split(", ");
            for (String bc : R) {
                String[] elements2 = bc.replaceAll("[()]", "").split(", ");
                if (elements1[1].equals(elements2[0])) {
                    String ac = "(" + elements1[0] + ", " + elements2[1] + ")";
                    if (!R.contains(ac)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Tạo các tập hợp A và B
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        A.addAll(Arrays.asList(1,2,3));
        B.addAll(Arrays.asList(2,3,4,5));
        Set<String> R = new HashSet<>(Arrays.asList("(1, 1)", "(2, 2)", "(3, 3)", "(1, 2)", "(2, 3)"));
        int x = 2;

        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("R = " + R);
        System.out.println("X = " + x);

        System.out.println(contains(A, x) ? "x ∈ A " : "x ∉ A " );

        // A ∪ B

        System.out.println("A ∪ B: " + sum(A, B));

        // A ∩ B

        System.out.println("A ∩ B: " + intersect(A, B));

        // A / B

        System.out.println("A / B: " + subtract(A, B));

        // A x B

        System.out.println("A x B: " + Descartes(A, B));




        // Kiểm tra R có phản xạ
        System.out.println(isReflex(A, R) ? "R co phan xa" : "R khong phan xa" );

        // Kiểm tra R có đối xứng
        System.out.println( isSymmetry(R) ?"R co doi xung" : "R khong doi xung");

        // Kiểm tra R có bắc cầu
        System.out.println(isTransite(R) ? "R co bac cau " : "R khong bac cau " );
    }
}
