package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
	private List<Song> list = new ArrayList<Song>();

	public List<Song> getAllSongs() {
   		return list;
	}

	public Song getSongById(Integer id) {
		return list.stream()
				.filter(song -> song.getId().equals(id))
				.findFirst()
				.get();
	}

	public void addSong(Song s) {
		list.add(s);
	}

	public void updateSong(Song s) {
		list.set(s.getId() - 1, s);
	}

	public void removeSong(Song s) {
		list.remove(s);
	}
	
	public SongRepository() {
		Song song1 = new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975");
		Song song2 = new Song(2, "Imagine", "John Lennon", "Imagine", "1971");
		list.add(song1);
		list.add(song2);
	}
}
