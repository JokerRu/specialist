package ru.specialist.springdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		House house = context.getBean("houseBean", House.class);
		
		house.buildWall();
		house.installDoors();
		house.view();
		
		System.out.println(house);
		System.out.println(context.getBean("houseBean"));
		
		MainWindow mainWindow = context.getBean(MainWindow.class);
		
		mainWindow.show();
		
		System.out.println(context.getBean("brickBean"));
		System.out.println(context.getBean("brickBean"));
		
		context.close();
    }
}
