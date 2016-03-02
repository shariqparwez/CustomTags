package com.training.tags;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ForEachTag extends TagSupport {
	private String items;

	public ForEachTag() {
		super();
	}
	


	public void setItems(String items) {
		this.items = items;
	}



	@Override
	public int doStartTag() throws JspException {
		ArrayList<String> list = new ArrayList<>();
		HttpServletRequest resp = (HttpServletRequest) pageContext.getRequest();
		list = (ArrayList<String>) resp.getAttribute("names");
		int i=1;
		// TODO Auto-generated method stub
		try{
			JspWriter out = pageContext.getOut();
			for(String name:list){
				out.println(i + " " + name);
				i++;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return Tag.SKIP_BODY;
	}
	
	
	
	
}
