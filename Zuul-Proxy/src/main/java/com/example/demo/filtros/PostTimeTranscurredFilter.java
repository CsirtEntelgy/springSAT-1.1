package com.example.demo.filtros;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTimeTranscurredFilter extends ZuulFilter {
	
	private static Logger log=LoggerFactory.getLogger(PostTimeTranscurredFilter.class);

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
		
		log.info("Entrando a POST FILTER");
		
		Long timeINITIAL=(Long) request.getAttribute("initialTime");
		Long passedTIME=System.currentTimeMillis();
		Long finalTIME = timeINITIAL - passedTIME;
		
		log.info(String.format("Tiempo inicial %s mili",  timeINITIAL.doubleValue()  ));
		log.info(String.format("Tiempo pasado %s mili",  passedTIME.doubleValue() ));
		
		log.info(String.format("Tiempo transcurrido en segundo %s seg",  finalTIME.doubleValue()/1000.00  ));
		log.info(String.format("Tiempo transcurrido en milisegundos %s  mili",  finalTIME.doubleValue()  ));
		
		
		return null;
	}

	@Override
	public String filterType() {
		// Descripcion del filtro
		return "post";
	}

	@Override
	public int filterOrder() {
		// orden de acción
		return 1;
	}

}
