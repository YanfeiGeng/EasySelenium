package com.easyselenium.selenium;

public class Parameter {
	
	private String FieldParameter;
	

	public Parameter(String fieldParameter) {
		super();
		FieldParameter = fieldParameter;
	}

	public String getFieldParameter() {
		return FieldParameter;
	}

	public void setFieldParameter(String fieldParameter) {
		FieldParameter = fieldParameter;
	}

	public boolean isParameterInput(){
		// @TODO check the current parameter type, input or 

		String strParameter = this.FieldParameter;
		if(strParameter.startsWith("$")){
			return true;
		}
		return false;
	}
	
	public boolean isParameterOutput(){
		// @TODO check the current parameter type, input or 

		String strParameter = this.FieldParameter;
		if(strParameter.startsWith("#")){
			return true;
		}
		return false;
	}
	
	public boolean isParameterUseBPCOutput(){
		// @TODO check the current parameter type, input or 

		String strParameter = this.FieldParameter;
		if(strParameter.contains(":")){
			return true;
		}
		return false;
	}
	
	public String getParameterName(){
		
		boolean isInputPara = this.isParameterInput();
		boolean isOutputPara = this.isParameterOutput();
		
		if(isInputPara||isOutputPara){
			return this.FieldParameter.substring(1);
		}
		
		//String msg = "The parameter use other BPC`s output data, please use getParameterNameComplex()";
		return null;
	}
	
	public String[] getParameterNameComplex(){
		
		boolean isBPCOutputPara = this.isParameterUseBPCOutput();
		String names[];
		if(isBPCOutputPara){
			names = this.FieldParameter.split(":");
			names[0] = names[0].substring(1);
			return names;
		}
		return null;
	}
}
