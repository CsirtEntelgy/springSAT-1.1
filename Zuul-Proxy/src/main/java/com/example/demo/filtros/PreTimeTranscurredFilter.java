package com.example.demo.filtros;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTimeTranscurredFilter extends ZuulFilter {
	
	private static Logger log=LoggerFactory.getLogger(PreTimeTranscurredFilter.class);

	@Override
	public boolean shouldFilter() {
		// activa el filtro
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Instrucciones del filtro
		RequestContext contexto=RequestContext.getCurrentContext();
		HttpServletRequest request=contexto.getRequest();
		
		log.info(String.format(" %s request enrutado a %s" , request.getMethod() , request.getRequestURL().toString()  ));
		Long initialTime=System.currentTimeMillis();
		request.setAttribute("initialTime", initialTime);
		
		return null;
	}

	@Override
	public String filterType() {
		// Descripcion del filtro
		return "pre";
	}

	@Override
	public int filterOrder() {
		// orden de acción
		return 1;
	}

}
