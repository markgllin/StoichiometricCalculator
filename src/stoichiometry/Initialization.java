package stoichiometry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Initialization {
	private static List<Element> allElements = new ArrayList<Element>();
	private static String dataFile = "C:\\Users\\Mark.Lin\\Desktop\\pt-data2.txt";
	
	public static void main(String args[]) throws IOException{
		double mass, percentMass;
		Compound compound;
		
		/*
		initializeElems();
		
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter Compound");
	    String userCompound = in.nextLine();
	    in.close();
	    
		compound = setCompoundInfo(userCompound);
		
		System.out.println("formula:" + compound.getFormula());
		System.out.println("Total mass: "+ compound.getMass());
		
		for(List<String> element:compound.getParsedFormula()){
			mass = Calculator.calcElementMass(element, compound.getElementList());
			percentMass = Calculator.calcPercentMass(compound.getMass(), mass);
			
			System.out.println(element.get(0)+": "+percentMass+"%" + " or "+mass+"g");
		}
		*/

		for (String s:Parser.splitEquation("AlSO4 + Gl6")){
			System.out.println(s.trim());
		}
		
	}
	

	/* reads the datafile and instantiates all 118 elements.
	 * uses setElementInfo.
	 */
	public static void initializeElems() throws IOException{
		String[] elementInfo = new String[18];
		int k=0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
			//assign information for each element
			for(String line; (line = br.readLine()) != null;) {
		        elementInfo = line.split("%");   
		        setElementInfo(k, elementInfo);
		        k++;
			}
		} catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}
	
	/* takes in a chemical formula and instantiates a new 'compound'
	 * variable for use later on. Sets the compound formula, parsed
	 * formula, list of elements, and mass. 
	 */
	public static Compound setCompoundInfo(String compoundFormula){
		double mass;
		Compound compound = new Compound();
		
		compound.setFormula(compoundFormula);
		compound.setParsedFormula(Parser.parseFormula(compoundFormula));
		compound.setElementList(elementList(compound.getParsedFormula()));
		mass = Calculator.calcCompoundMass(compound.getParsedFormula(), compound.getElementList());
		compound.setMass(mass);
		
		return compound;
	}
	
	/* sets the element info. 
	 * used by readfile()
	 */
	public static void setElementInfo(int atomicNum, String[] temp){
        Element tempEl = new Element();
        tempEl.setAtomicNum(Integer.parseInt(temp[0]));
        tempEl.setSymbol(temp[1]);
        tempEl.setName(temp[2]);
        tempEl.setMass(temp[3]);
        tempEl.setEConfig(temp[4]);
        tempEl.setENeg(temp[5]);
        tempEl.setAtomicRadius(temp[6]);
        tempEl.setIonRadius(temp[7]);
        tempEl.setVDWRad(temp[8]);
        tempEl.setIE(temp[9]);
        tempEl.setEA(temp[10]);
        tempEl.setStateType(temp[11]);
        tempEl.setBondingType(temp[12]);
        tempEl.setMeltPoint(temp[13]);
        tempEl.setBoilPoint(temp[14]);
        tempEl.setDensity(Double.parseDouble(temp[15]));
        tempEl.setMetalType(temp[16]);
      //tempEl.setOxiStates(temp[17]);
        
        allElements.add(tempEl);
	}
	
	/* takes in an element as a string, iterates through all
	 * stored elements, and returns if found. Returns null if
	 * not. Searches using symbol
	 */
	public static Element findElementInfo(String element){
		for (Element elem:allElements)
			if (elem.getSymbol().equals(element))
				return elem;

		System.out.println("Element '" + element + "' was not found.");
		System.exit(0);
		return null;
	}
	
	/* takes in a list of list corresponding to the parsed compound (see
	 * parseFormula() for return type and order) and checks to see if
	 * element exists. If it does, the element is appended and full
	 * list of elements is returned.
	*/
	public static List<Element> elementList(List<List<String>> listCompound){
		int ELEM_SYM=0;
		List<Element> allElements = new ArrayList<Element>();
		Element elem = new Element();
		
		//check if elements in compound exist
		for (List<String> curElement:listCompound){
			elem = findElementInfo(curElement.get(ELEM_SYM));
			
			//check if element exists. If not, print to results and exit. Otherwise, append to list.
			if (elem == null){
				System.out.println("The element '" + curElement.get(ELEM_SYM) + "' does not appear to exist.");
				System.exit(0);
			}else
				allElements.add(elem);
		}
		
		return allElements;
	}
	
 	//////////////////////////neccessary?////////////////////////////////////////
 	
	/* takes in an array of elements ending with a multiplier, 
	 * and combines all elements into 1 string with multiplier
	 * in second index (e.g. {"", "Al", "SO4", "2"} -> {"AlSO4", "2"}
	 */
	public static String[] combineCompounds(String[] compound){
		String[] ion = new String[2];
		
		for (int i=0; i<compound.length; i++){
			
			if (compound[i].equals(""))
				ion[0]=compound[i];
			else if(Character.isDigit(compound[i].charAt(0)))
				ion[1] = compound[i];
			else
				ion[0]+= compound[i];
		}
		
		return ion;
	}
}
