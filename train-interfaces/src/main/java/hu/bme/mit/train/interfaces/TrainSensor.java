package hu.bme.mit.train.interfaces;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

import java.time.LocalTime;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

    Table<LocalTime, Integer, Integer> getTacho();

	void refreshTacho();

	void trainTimer();

	class Timer implements Runnable {
		TrainController controller;

		public Timer(TrainController controller){
			this.controller = controller;
		}

		private long currentTime = 0;

		@Override
		public void run(){
			int time = 0;
			while (time < 7){
				try{
					Thread.sleep(1000);

				}
				catch (InerruptedException e){
					throw new RuntimeException(e);				
				}
			}
			controller.followSpeed();
			currentTime++;
			time++;
		}

		public void getTime(){
			return currentTime;
		}

	}
}
