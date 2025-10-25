import java.util.*;

class PrimesGenerator implements Iterator<Integer> {
    private int count;
    private int current = 2;
    private int generated = 0;
    
    public PrimesGenerator(int count) {
        this.count = count;
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public boolean hasNext() {
        return generated < count;
    }
    
    public Integer next() {
        while (!isPrime(current)) {
            current++;
        }
        int prime = current;
        current++;
        generated++;
        return prime;
    }
}

class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10;
        PrimesGenerator generator = new PrimesGenerator(N);
        List<Integer> primes = new ArrayList<>();
        
        while (generator.hasNext()) {
            primes.add(generator.next());
        }
        
        System.out.println("Прямой порядок: " + primes);
        Collections.reverse(primes);
        System.out.println("Обратный порядок: " + primes);
    }
}