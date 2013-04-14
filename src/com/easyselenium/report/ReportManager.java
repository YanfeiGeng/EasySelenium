package com.easyselenium.report;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.easyselenium.model.BPCModel;
import com.easyselenium.model.Step;
import com.easyselenium.model.TestScript;
import com.easyselenium.model.TestScriptItem;
import com.easyselenium.model.TestSuiteItem;
import com.easyselenium.selenium.ConfigurationResource;

public class ReportManager {

	private String stepPrefix = "<div class=\"step\"><fieldset><legend>Detailed Steps</legend>";
		
	private String stepSuffix = "</fieldset></div></div>";
	
	private int passed = 0, failed = 0;
	
	private StringBuffer report = new StringBuffer();
	
	private StringBuffer hideMsg = new StringBuffer();
	
	public void generateReport() throws Exception{
		ConfigurationResource res = ConfigurationResource.instance();
		for(TestSuiteItem item : res.getSuite().getItems()){
			report.append("<fieldset><legend>")
				.append(item.getModule())
				.append("</legend>");
			TestScript ts = res.getScripts().get(item.getTsName());
			for(TestScriptItem script : ts.getScripts()){
				report.append("<div class=\"script\">")
					.append(script.getBPCName());
				BPCModel bpc = res.getBpcs().get(script.getBPCName());
				report.append(this.stepPrefix);
				for(Step step : bpc.getSteps()){
					report.append(nameStyle())
						.append(step.getAction())
						.append(": ")
						.append(step.getStep())
						.append("</div>")
						.append(style(step));
					if(Step.Status.PASS.equals(step.getStatus())){
						passed++;
					} else if(Step.Status.FAIL.equals(step.getStatus())){
						failed++;
					}
				}
				report.append(this.stepSuffix);
			}
			report.append("</fieldset>");
		}
		this.output();
	}
	
	private String nameStyle(){
		if((this.passed + this.failed)%2 == 1){
			return "<div><div class='step_name odd'>";
		} else {
			return "<div><div class='step_name even'>";
		}
	}
	
	private String stepP = "<div class='STATUS'>";
	private String stepS = "</div></div>";
	private String style(Step s){
		if(Step.Status.FAIL.equalsIgnoreCase(s.getStatus())){
			String id = String.valueOf(System.currentTimeMillis());
			String c = "<div class='fail' onclick='error(\"" 
					+ id 
					+ "\")'>" 
					+ s.getStatus() 
					+ "</div></div>"
					+ this.hideMessage(id, s.getReason());
			return c;
		}
		return stepP.replaceAll("STATUS", s.getStatus().toLowerCase()) + s.getStatus() + stepS;
	}
	
	private String hideMessage(String id, String msg){
		return "<div id='" + id + "' style='display:none;'>" + msg + "</div>";
	}
	
	public String template() throws Exception{
		StringBuffer template = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(".\\report\\Template.html"));
		String line = reader.readLine();
		while(null != line){
			template.append(line);
			line = reader.readLine();
		}
		reader.close();
		return template.toString();
	}
	
	public void output() throws Exception{
		String template = this.template();
		File output = new File(".\\report\\Output\\report-" + System.currentTimeMillis() + ".html");
		template = template.replaceAll(Report.BODY, this.report.toString())
				.replaceAll(Report.PASSED_STEPS_NUM, String.valueOf(passed))
				.replaceAll(Report.FAILED_STEPS_NUM, String.valueOf(failed));
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));
		writer.write(template);
		writer.flush();
		writer.close();
	}
	
	
}
