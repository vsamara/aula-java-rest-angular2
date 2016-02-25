package utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		EntityManagerUtils.criarConexao();
		System.out.println("-- Conexão criada. --");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		EntityManagerUtils.fechaConexao();
		System.out.println("-- Conexão encerrada. --");
	}

}
