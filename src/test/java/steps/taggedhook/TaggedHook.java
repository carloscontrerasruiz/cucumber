package steps.taggedhook;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import steps.globalhooks.CommonSteps;

public class TaggedHook {
	
	//De esta forma se usa el driver que se crea en los common hooks
	private WebDriver driver;
	
	public TaggedHook(CommonSteps commonSteps) {
		this.driver = commonSteps.getDriver();
	}
	//Tagged hook, solo se ejecuta en los escenarios que tengan la anotacion
	//@taggedHook el nombre de la anotacion puede ser el que sea
	//LOS TAGGED HOOKS DEBEN ESTAR DESPUES DEL HOOH BEFORE GLOBAL
	//YA QUE SE EJECUTARIA ANTES EL HOOK ESPECIFIC A MENOS QUE ESO SEA LO QUE SE QUIERE
	//Si se quiere hacer con la opcion order 0 es la maxima prioridad
	@Before(value = "@taggedHook", order = 2)
	public void taggedHook() {
		System.out.println("Before especific hook");
	}

	//En el caso de los after el que tenga el numero menor ma cercano a cero sera el ultimo que se ejecute
	@After(value = "@afterTaggedHook", order = 2)
	public void afterTaggedHook() {
		System.out.println("After tagged hook");
	}


}
