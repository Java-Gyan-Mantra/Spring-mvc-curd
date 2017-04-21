package com.dugu.dev.acc.sr.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FMSApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { FMSHibernateConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { FMSApplicationConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.aspx" };
	}

}
