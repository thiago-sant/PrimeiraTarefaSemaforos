package controller;

import java.util.concurrent.Semaphore;

public class ThreadCalculos extends Thread {
	
	private int IdThread;
	private int tempoCalc;
	private int tempoTrans;
	private Semaphore semaforo;
	
	public ThreadCalculos (int IdThread, Semaphore semaforo) {
		this.IdThread = IdThread;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		tipoID();
	}

	private void tipoID() {
		if (IdThread % 3 == 1) {
			for (int i = 0; i < 4; i++) {
				tempoCalc = (int)((Math.random() * 801) + 200);
				tempoTrans = 1000;
				calcular(tempoCalc);
				try {
					semaforo.acquire();
					transacao(tempoTrans);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			}
			
		}
		
		if (IdThread % 3 == 2) {
			for (int i = 0; i < 6; i++) {
				tempoCalc= (int)((Math.random() * 1001) + 500);
				tempoTrans = 1500;
				calcular(tempoCalc);
				try {
					semaforo.acquire();
					transacao(tempoTrans);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			}
		}
		
		if (IdThread % 3 == 0) {
			for (int i = 0; i < 6; i++) {
				tempoCalc= (int)((Math.random() * 1001) + 1000);
				tempoTrans = 1500;
				calcular(tempoCalc);
				try {
					semaforo.acquire();
					transacao(tempoTrans);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			}
		}
		
	}

	private void transacao(int tempoTrans) {
		try {
			sleep(tempoTrans);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread #"+IdThread+ " Transação BD...");
		
	}

	private void calcular(int tempoCalc) {
		try {
			sleep(tempoCalc);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread #"+IdThread+ " calculando...");
	}
}