// 정렬
import java.util.*;
import java.io.*;

public class Main {

    static class Person implements Comparable<Person> {
        int age;
        String name;
        int index;

        Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age < o.age) return -1;
            else if (this.age > o.age) return 1;
            else {
                if (this.index > o.index) return 1;
                else return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Person> q = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            q.add(new Person(age, name, i));
        }
        for (int i=1; i<=N; i++) {
            Person person = q.poll();
            System.out.println(person.age + " " + person.name);
        }
    }
}