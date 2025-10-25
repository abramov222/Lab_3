import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("\n\t===\tЗадание 1\t===\n");
		
        int N = 10;
        int[] array = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("Массив: " + Arrays.toString(array));
        
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println("Список: " + list);
        
        Collections.sort(list);
        System.out.println("Отсортированный: " + list);
        
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Обратный порядок: " + list);
        
        Collections.shuffle(list);
        System.out.println("Перемешанный: " + list);
        
        Collections.rotate(list, 1);
        System.out.println("Циклический сдвиг: " + list);
        
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("Уникальные: " + uniqueList);
        
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (Integer num : list) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Дубликаты: " + duplicates);
        
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("Массив из списка: " + Arrays.toString(newArray));
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Частота: " + frequencyMap);
    }
}