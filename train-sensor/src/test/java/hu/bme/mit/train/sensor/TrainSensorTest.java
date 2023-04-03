package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorTest {

    private TrainController traincontroller;
    private TrainUser trainuser;

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void TachographTest(){
        TrainSensorImpl sensor = new TrainSensorImpl(traincontroller, trainuser);
        sensor.refreshTacho();

        assertFalse(sensor.getTacho().isEmpty());

    }
}
