package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features"},
		glue = {"steps"},
		//name = {"logo"}//Solo correra los escenarios que coincidan con una parte
		//del nombre del escenario es case sensitive y acepta regex
		
		tags = "@AdvancedSearch", //Sirve para correr escenarios especificos este tag debe coincidir 
		//con los tags puestos en los features, estos tags pueden tener el nombre que sea,
		//pueden estar arriba de Feature Scenario y Scenario Outline
		//Para agregar multiples tags puede ser {"tag1", "tag2"} o "tag1 and tag2"
		
		dryRun = false,
		
		monochrome = true, //Despliega la informacion en un mejor formato en la consola
		//strict = true //Cuando es true trata como exceptiones si falta 
		//los step definitions que falten DEPRECADO true es el comportamiento por defecto
		
		//dryRun = true //Cuando es true no ejecuta las pruebas solo verifica que todos 
		//los escenarios tengan las step definitions agregados
		
		//plugin = {"pretty","junit:Report3"}
		plugin = {"pretty","json:target/json-report/cucumber.json"}
		//plugin = {"pretty","html:Report1"}//Esto nos entrega un informe en el formato especificado
		
		
)
public class TestRunner {

}
//Repo del curso https://github.com/dezlearn/dezinnia-cucumber