package simple;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class HashmapSample {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Set<Book> set = new HashSet<>();

        for (int i = 0; i < 10_000; i++) {

            Book book = new Book(i);
            set.add(book);
        }

        long stop = System.currentTimeMillis();

        System.out.println("Took " + (stop - start));
    }
}

@AllArgsConstructor
@Getter
class Book {

    private int counter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return counter == book.counter;
    }

    @Override
    public int hashCode() {
        return counter;
    }
}
