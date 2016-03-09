package stoichiometry;

public class Element{
	private int atomicNum;
	private String symbol;
	private String name;
	private String mass;
	private String eConfig;
	private String eNeg;
	private String atomicRad;
	private String ionRad;
	private String vdwRad;
	private String ie;
	private String ea;
	private String oxiStates;
	private String sType;
	private String bType;
	private String mPoint;
	private String bPoint;
	private double density;
	private String metalType;
	
	public int getAtomicNum(){
		return atomicNum;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMass(){
		return mass;
	}
	
	public String getEConfig(){
		return eConfig;
	}
	
	public String getENeg(){
		return eNeg;
	}
	
	public String getAtomicRadius(){
		return atomicRad;
	}
	
	public String getIonRadius(){
		return ionRad;
	}
	
	public String getVDWRad(){
		return vdwRad;
	}
	
	public String getIE(){
		return ie;
	}
	
	public String getEA(){
		return ea;
	}
	
	public String getOxiStates(){
		return oxiStates;
	}
	
	public String getStateType(){
		return sType;
	}
	
	public String getBondingType(){
		return bType;
	}
	
	public String getMeltPoint(){
		return mPoint;
	}

	public String getBoilPoint(){
		return bPoint;
	}

	public double getDensity(){
		return density;
	}

	public String getMetalType(){
		return metalType;
	}
	
	public void setAtomicNum(int val){
		atomicNum=val;
	}
	
	public void setSymbol(String val){
		symbol=val;
	}
	
	public void setName(String val){
		name=val;
	}
	
	public void setMass(String val){
		mass=val;
	}
	
	public void setEConfig(String val){
		eConfig=val;
	}
	
	public void setENeg(String val){
		eNeg=val;
	}
	
	public void setAtomicRadius(String val){
		atomicRad=val;
	}
	
	public void setIonRadius(String val){
		ionRad=val;
	}
	
	public void setVDWRad(String val){
		vdwRad=val;
	}
	
	public void setIE(String val){
		ie=val;
	}
	
	public void setEA(String val){
		ea=val;
	}
	
	public void setOxiStates(String val){
		oxiStates=val;
	}
	
	public void setStateType(String val){
		sType=val;
	}
	
	public void setBondingType(String val){
		bType=val;
	}
	
	public void setMeltPoint(String val){
		mPoint=val;
	}

	public void setBoilPoint(String val){
		bPoint=val;
	}

	public void setDensity(double val){
		density=val;
	}

	public void setMetalType(String val){
		metalType=val;
	}
}

