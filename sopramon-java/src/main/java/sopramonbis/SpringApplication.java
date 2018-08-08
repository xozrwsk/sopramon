package sopramonbis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		myContext.getBeanFactory().createBean(Affichage.class).run(args);
		myContext.close();
	}

}
