package com.logicmaster63.flux_led;

import com.logicmaster63.flux_led.BulbScanner;
import com.logicmaster63.flux_led.LedTimer;
import com.logicmaster63.flux_led.WifiLedBulb;
import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PySystemState;

/**
 * Jython Object Factory using PySystemState
 */
public class FluxLed {

    private Class interfaceType;
    private PyObject klass;

    public static void main(String[] args) {
        // Only used in ide
        /*if(!JythonObjectFactory.class.getResource("JythonObjectFactory.class").toString().startsWith("jar:")) {
            PythonInterpreter pi = new PythonInterpreter();
            pi.exec("import sys");
            pi.exec("sys.path.append('C:/Programming/ServerSystem/src/main/resources/Lib')");
        }*/

        // Create object factories
        System.out.println("Loading modules");
        FluxLed scannerFactory = new FluxLed(BulbScanner.class, "flux_led_java", "BulbScanner");
        FluxLed ledBulbFactory = new FluxLed(WifiLedBulb.class, "flux_led_java", "WifiLedBulb");
        FluxLed timerFactory = new FluxLed(LedTimer.class, "flux_led_java", "LedTimer");

        BulbScanner scanner = (BulbScanner) scannerFactory.createObject();
        scanner.scan(0);
        //scanner.scan();
        System.out.println(scanner.getBulbInfo().length + " bulbs found");
        System.out.println(scanner.getBulbInfoByID("840D8E40219B"));

        WifiLedBulb bulb = (WifiLedBulb) ledBulbFactory.createObject("192.168.1.82");
        //System.out.println(bulb.getBrightness());
        //System.out.println(bulb.getWarmWhite());
        //System.out.println(bulb.getClock());
        //System.out.println(bulb.getColdWhite());
        System.out.println(bulb);
        //System.out.println(bulb.getRgb());
        //System.out.println(bulb.getRgbw());
        //System.out.println(bulb.getRgbww());
        //System.out.println(bulb.getSpeed());
        //System.out.println(Arrays.asList(bulb.getTimers()));
        //System.out.println(bulb.isOn());
        //System.out.println(bulb.getWarmWhite255());
        //System.out.println(bulb.getMode());
        //Exception in thread "MainThread" TypeError: can't convert bytearray(b'\x81D#a\x01\x05\x1e\x1e\x1e\x00\x08\x00\xf0\xa1') to [B
        //System.out.println(Arrays.asList(bulb.queryState()));
        //System.out.println(Arrays.asList(bulb.queryState(1, "LEDENET_ORIGINAL")));
        //bulb.queryState();
        //bulb.updateState();
        //bulb.updateState();
        //bulb.updateState(1);
        //bulb.turnOff(1);
        //bulb.turnOff();
        //bulb.turnOn(1);
        //bulb.turnOn();
        //bulb.connect(1);
        //bulb.connect();
        //bulb.setClock();
        //bulb.setWarmWhite(50, true, 1);
        //bulb.setColdWhite(100, true, 1);
        //bulb.setWhiteTemperature(3000, 199);
        //bulb.justSetBrightness(true, 255, 0);
        //bulb.close();
        //bulb.setRgb(0, 100, 0, true, 255, 0);
        LedTimer timer = (LedTimer) timerFactory.createObject();

    }

    // Constructor obtains a reference to the importer, module, and the class name
    public FluxLed(PySystemState state, Class interfaceType, String moduleName, String className) {
        try {
            this.interfaceType = interfaceType;
            PyObject importer = state.getBuiltins().__getitem__(Py.newString("__import__"));
            PyObject module = importer.__call__(Py.newString(moduleName));
            klass = module.__getattr__(className);
            System.out.println("Loaded class '" + className + "' from module '" + moduleName + "'");
        } catch (Exception e) {
            System.err.println("Failed to load module '" + moduleName + "': " + e);
        }
    }

    // This constructor passes through to the other constructor
    public FluxLed(Class interfaceType, String moduleName, String className) {
        this(new PySystemState(), interfaceType, moduleName, className);
    }

    // All of the followng methods return
    // a coerced Jython object based upon the pieces of information
    // that were passed into the factory. The differences are
    // between them are the number of arguments that can be passed
    // in as arguents to the object.

    public Object createObject() {
        return klass.__call__().__tojava__(interfaceType);
    }


    public Object createObject(Object arg1) {
        return klass.__call__(Py.java2py(arg1)).__tojava__(interfaceType);
    }

    public Object createObject(Object arg1, Object arg2) {
        return klass.__call__(Py.java2py(arg1), Py.java2py(arg2)).__tojava__(interfaceType);
    }

    public Object createObject(Object arg1, Object arg2, Object arg3)
    {
        return klass.__call__(Py.java2py(arg1), Py.java2py(arg2),
                Py.java2py(arg3)).__tojava__(interfaceType);
    }

    public Object createObject(Object args[], String keywords[]) {
        PyObject convertedArgs[] = new PyObject[args.length];
        for (int i = 0; i < args.length; i++) {
            convertedArgs[i] = Py.java2py(args[i]);
        }

        return klass.__call__(convertedArgs, keywords).__tojava__(interfaceType);
    }

    public Object createObject(Object... args) {
        return createObject(args, Py.NoKeywords);
    }

}
