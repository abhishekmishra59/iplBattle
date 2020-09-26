package com.ipl.iplbattle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is used for Swagger2 documentation configuration.
 * @author DEP Developer
 */
@Configuration
@EnableSwagger2  // can be used to disable swagger
public class SwaggerConfig {
    /**
     * @return Docket object
     */
    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
        .pathProvider(new RelativePathProvider(null) {
            /*
             * (non-Javadoc)
             * @see springfox.documentation.spring.web.paths.
             * AbstractPathProvider#getApplicationBasePath()
             */
            /**
             * @Override getApplicationBasePath
             */
            @Override
            public String getApplicationBasePath() {
                return "";
            }
        }).select()
        .apis(
        RequestHandlerSelectors.basePackage("com.ipl.iplbattle"))
        .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    /**
     * @return ApiInfo object.
     */
    private static ApiInfo apiInfo() {
        final Contact contact = new Contact("CONTACTTEAM",
        "", "CONTACTMAIL");

        return new ApiInfo("IPL Services",
        "Dev Host IP:" + "DEVHOSTIP" + " <br> JIT Host IP:"
        +"SITHOSTIP" + " <br> UAT Host IP:"
        + "UATHOSTIP" + " <br> Prod Host IP:"
        + "PRODHOSTIP", "", "", contact, "", "");

    }
}
