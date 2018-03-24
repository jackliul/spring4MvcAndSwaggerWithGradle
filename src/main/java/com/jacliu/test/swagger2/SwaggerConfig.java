package com.jacliu.test.swagger2;  
  
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
  
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	private SwaggerEnvConfig swaggerEnvConfig;

	@Bean
	public Docket createRestUserApi() {
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		tokenPar.name("x-access-token").description("签名").defaultValue("user").modelRef(new ModelRef("string"))
				.parameterType("header").required(false).build();
		pars.add(tokenPar.build());

		return new Docket(DocumentationType.SWAGGER_2).enable(swaggerEnvConfig.isEnableSwagger()) //
				.globalOperationParameters(pars).apiInfo(apiInfo()).groupName("user").select()
				.apis(RequestHandlerSelectors.basePackage("com.jacliu.test.web")).paths(PathSelectors.ant("/user/**"))
				.build();
	}

	@Bean
	public Docket createRestOrderApi() {

		return new Docket(DocumentationType.SWAGGER_2).enable(swaggerEnvConfig.isEnableSwagger()) //
				.apiInfo(apiInfo()).groupName("order").select()
				.apis(RequestHandlerSelectors.basePackage("com.jacliu.test.web"))
				.paths(PathSelectors.ant("/order/**")).build();
	}

	@Bean
	public Docket createRestGlobalApi() {
		
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		tokenPar.name("x-access-token").description("签名").defaultValue("token00001").modelRef(new ModelRef("string"))
				.parameterType("header").required(false).build();
		pars.add(tokenPar.build());
		
		return new Docket(DocumentationType.SWAGGER_2).enable(swaggerEnvConfig.isEnableSwagger())
				// .genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false)
				// .forCodeGeneration(false)
				.apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.jacliu.test.web"))
				.paths(PathSelectors.any()).build();
    }

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
				.title("oms订单列表v1.1.0").description("oms接口").termsOfServiceUrl("http://localhost:8089/")
				.contact("jacliu").version("1.0.0")
                .build();
    }
}