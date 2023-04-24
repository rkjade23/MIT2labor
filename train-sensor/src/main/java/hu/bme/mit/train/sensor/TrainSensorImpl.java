package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

import java.util.Timer; 
import java.util.TimerTask; 

import java.time.LocalTime;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	public Table<LocalTime, Integer, Integer> tachograph;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

    @Override
	public void refreshTacho() {
		tachograph = HashBasedTable.create();
		tachograph.put(LocalTime.now(), 2, 3);
	}

	@Override
	public Table<LocalTime, Integer, Integer> getTacho(){
		return tachograph;
	}

}
