import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CronTriggerExample {

	public CronTriggerExample() {

	}

	public void run() throws Exception {
		
		Logger log = LoggerFactory.getLogger(CronTriggerExample.class);
		
		log.info("------- Iniciando -------------------");
		
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		log.info("------- Inicialização completa -----------");
		log.info("------- Agendando job -------------------");		
		
		JobDetail job = JobBuilder.newJob(SimpleJob.class)
				.withIdentity("job1", "group1").build();
		CronTrigger trigger = (CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("trigger7", "group1")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0 15 ? * *"))
				.build();

		Date ft = sched.scheduleJob(job, trigger);

		log.info((new StringBuilder()).append(job.getKey()).append(" foi agendado para executar em: ").append(ft).append(" baseada na expressão: ").append(trigger.getCronExpression()).toString());
	       
		log.info("------- Iniciando o scheduler -------------------");		
		sched.start();

		
		log.info("------- Aguardando 5 minutos -------------------");	
		
		  try
	        {
	            Thread.sleep(0x493e0L);
	        }
	        catch(Exception e) { }
			
		
		log.info("------- Desligando o scheduler -------------------");			
		sched.shutdown(true);
	}

	public static void main(String args[]) throws Exception {
		CronTriggerExample example = new CronTriggerExample();
		example.run();
	}

}
