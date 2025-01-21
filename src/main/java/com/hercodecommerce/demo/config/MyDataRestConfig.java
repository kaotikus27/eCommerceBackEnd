package com.hercodecommerce.demo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.util.pattern.PathPattern;

import com.hercodecommerce.demo.entity.Country;
import com.hercodecommerce.demo.entity.Product;
import com.hercodecommerce.demo.entity.ProductCategory;
import com.hercodecommerce.demo.entity.State;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	
	@Value("${allowed.origins}")
	private String[] theAllowedOrigins;
	
	private EntityManager entityManager;
	
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	public void configureRepositoryRestConfiguration
	(RepositoryRestConfiguration config, CorsRegistry cors) {
		
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		
		HttpMethod[] theUnsuppportedActionsHttpMethods = {
				HttpMethod.PUT, 
				HttpMethod.POST, 
				HttpMethod.DELETE,
				HttpMethod.PATCH
		};
		
		
		// -disable HTTP methods for Product: PUT,POST and DELETE
		disableHttpMethods(Product.class, config, theUnsuppportedActionsHttpMethods);
		//config.getExposureConfiguration()
		//.forDomainType(Product.class)
		//.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuppportedActionsHttpMethods))
		//.withCollectionExposure((metdata, httpMethods)-> httpMethods.disable(theUnsuppportedActionsHttpMethods));
	
		// -disable HTTP methods for ProductCategory: PUT,POST and DELETE
		disableHttpMethods(ProductCategory.class, config, theUnsuppportedActionsHttpMethods);
			
		// disable the States and Country HTTP
		disableHttpMethods(Country.class, config, theUnsuppportedActionsHttpMethods);
		disableHttpMethods(State.class, config, theUnsuppportedActionsHttpMethods);
		
		// -call an internal helper method
		exposedId(config);
		
	    //config cors mapping
		cors.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrigins);
	}


	private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
			HttpMethod[] theUnsuppportedActionsHttpMethods) {
		config.getExposureConfiguration()
		.forDomainType(theClass)
		.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuppportedActionsHttpMethods))
		.withCollectionExposure((metdata, httpMethods)-> httpMethods.disable(theUnsuppportedActionsHttpMethods));
	}


	private void exposedId(RepositoryRestConfiguration config) {
		// -expose entity ids
		//
		
		// -get a list of all entity class from the entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();	
		
		// -create array to entities types
		List<Class> entityClasses = new ArrayList<>();
		
		// -get the entity types for the entities
		for(EntityType tempEntityType: entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		// -expose the entity ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}

	
	
	
}
