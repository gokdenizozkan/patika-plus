package dev.patika.plus.java.week5;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Book implements Comparable<Book> {
	String name;
	int pageCount;
	String author;
	long publicationDate;
	
	public Book(String name, int pageCount, String author, long publicationDate) {
		this.name = name;
		this.pageCount = pageCount;
		this.author = author;
		this.publicationDate = publicationDate;
	}
	
	@Override
	public int compareTo(Book o) {
		int cycle = Math.min(this.name.length(), o.getName().length());
		
		for (int i = 0; i < cycle; i++) {
			if (this.name.charAt(i) > o.getName().charAt(i)) return 1;
			if (this.name.charAt(i) < o.getName().charAt(i)) return -1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Book b1 = new Book("Masalc", 1, "Ali", 20230920);
		Book b2 = new Book("Masalb", 2, "Ayşe", 20230920);
		Book b3 = new Book("Masala", 3, "Ahmet", 20230920);
		Book b4 = new Book("Ahmetullaha", 4, "Mehmet", 20230920);
		Book b5 = new Book("Ahmetullahb", 5, "Ziya", 20230920);
		
		Set<Book> set = new HashSet<>();
		set.add(b1); set.add(b2); set.add(b3); set.add(b4); set.add(b5);
		
		Set<Book> setSorted = new TreeSet<>(set);
		setSorted.forEach(Book -> System.out.println(Book.getName()));
	}

	public String getName() {
		return name;
	}

	public int getPageCount() {
		return pageCount;
	}

	public String getAuthor() {
		return author;
	}

	public long getPublicationDate() {
		return publicationDate;
	}
}
