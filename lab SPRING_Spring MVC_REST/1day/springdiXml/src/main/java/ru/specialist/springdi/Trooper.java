package ru.specialist.springdi;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable("trooper")
public class Trooper {
	
	private String instrument;
	private String song;
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	
	public void song() {
		System.out.printf("Play %s with %s\n", getSong(), getInstrument());
	}
	
	

}
