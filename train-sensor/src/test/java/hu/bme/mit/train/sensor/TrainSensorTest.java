package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainController trainController;
    private TrainUser trainUser;
    private TrainSensorImpl trainSensor;

    @Before
    public void before() {
        trainController = mock(TrainController.class);
        trainUser = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(trainController, trainUser);

    }

    @Test
    public void speedLimitMinTest(){
        trainSensor.overrideSpeedLimit(-1);
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void speedLimitMaxTest(){
        trainSensor.overrideSpeedLimit(501);
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void speedLimitMarginTest(){
        trainSensor.overrideSpeedLimit(4);
        verify(trainUser, times(0)).setAlarmState(true);
    }

    @Test
    public void speedLimitBetweenTest(){
        trainSensor.overrideSpeedLimit(300);
        verify(trainUser, times(0)).setAlarmState(true);
    }

    @Test
    public void sensorOverrideRelativeSpeedLimit(){
        when(trainController.getReferenceSpeed()).thenReturn(151);
        trainSensor.overrideSpeedLimit(100);
        verify(trainUser, times(0)).setAlarmState(true);
    }



    

    @Test
    public void TachographTest(){
        TrainSensorImpl sensor = new TrainSensorImpl(trainController, trainUser);
        sensor.refreshTacho();

        assertFalse(sensor.getTacho().isEmpty());

    }
}
