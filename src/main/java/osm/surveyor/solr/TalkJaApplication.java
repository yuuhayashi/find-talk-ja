package osm.surveyor.solr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TalkJaApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TalkJaApplication.class, args);
	}

    /**
     * Servletコンテナ起動時の設定クラス認識。
     *
     * <PRE>
     * Servletコンテナで起動したときにどのクラスが設定クラスなのか認識させます。
     * </PRE>
     *
     * @param  SpringApplicationBuilder
     * @return SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TalkJaApplication.class);
    }
}
