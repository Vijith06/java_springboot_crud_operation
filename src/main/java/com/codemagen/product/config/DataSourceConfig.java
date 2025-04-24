package com.codemagen.product.config;

import com.codemagen.product.contants.ApplicationConstants;
import com.codemagen.product.property.DataSourceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Map;


@Configuration
public class DataSourceConfig {

        @Value("${spring.profiles.active}")
        private String domain;

        @Value("${swagger.profile}")
        private String swaggerLibSwitch;

        @Value("${common.service.url}")
        private String commonServiceUrl;

        @Autowired
        private Docket swaggerDocket;

        @Bean
        public synchronized DataSourceModel getDataSource() {
            DataSourceModel dataSourceModel;
            if ("dev".equalsIgnoreCase(domain) || "test".equalsIgnoreCase(domain)) {
                dataSourceModel = getDevelopmentDataSource();
            } else {
                dataSourceModel = getProductionDataSource();
            }
            return dataSourceModel;
        }

        private DataSourceModel getDevelopmentDataSource() {
            DataSourceModel dataSourceModel = new DataSourceModel();
            dataSourceModel.setCommonServiceUrl(commonServiceUrl);
            if ("false".equalsIgnoreCase(swaggerLibSwitch)) {
                swaggerDocket.enable(false);
            }
            return dataSourceModel;
        }

        private DataSourceModel getProductionDataSource() {
            DataSourceModel dataSourceModel = new DataSourceModel();
            Map<String, String> env = System.getenv();
            dataSourceModel.setCommonServiceUrl(env.get(ApplicationConstants.COMMON_SERVICE_URL));
            swaggerLibSwitch = env.get(ApplicationConstants.SWAGGER_PROFILE);
            if ("false".equalsIgnoreCase(swaggerLibSwitch)) {
                swaggerDocket.enable(false);
            }
            return dataSourceModel;
        }

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
