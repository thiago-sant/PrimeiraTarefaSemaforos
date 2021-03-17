package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCalculos;

public class Principal {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int IdThread = 0; IdThread <= 21; IdThread++) {
			Thread tCalculo = new ThreadCalculos(IdThread, semaforo);
			tCalculo.start();
		}
	}
}
