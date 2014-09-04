package device.itself.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import net.sf.json.JSONObject;

import device.itself.Delegator;
import device.itself.annotaion.ContextField;
import device.itself.annotaion.ContextMethod;
import device.itself.annotaion.ContextType;
import device.itself.annotaion.ContextParam;
import device.itself.annotaion.SearchEngine;
import device.itself.annotaion.SearchLanguage;



@ContextType(key="AnnotationSample")
public class AnnotationTest {
	
	public @ContextField(key="SensorField1")  String SensorValue1="SensorValue1";
	public @ContextField(key="SensorField2")  String SensorValue2="SensorValue2";
	public @SearchEngine()  String SearchEngine="http://trecruit.jejuair.net";
	public @SearchLanguage()  String SearchLanguage="javascript";
	
	@ContextMethod(key="SensorMethod")
	String Test(@ContextParam(key="localVariable") String testParam)
	{
		@ContextField(key="localVariable")
		String Sensor=testParam;
		SensorValue1="After Value";
		return Sensor;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationTest test=new AnnotationTest();
		String testValue="abc";
		if(testValue.equals("a"))
			System.out.println("a");
		else if(testValue.equals("b"))
			System.out.println("b");
		else
			Delegator.DoItYourself(test);
		
		try {
			throw new Exception();
		}catch(Exception e)
		{
			e.printStackTrace();
			Delegator.DoItYourself(test);
		}

	}
	
}
