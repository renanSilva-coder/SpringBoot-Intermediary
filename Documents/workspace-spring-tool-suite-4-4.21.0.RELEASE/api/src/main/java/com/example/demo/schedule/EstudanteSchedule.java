package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EstudanteSchedule {
	
	@Scheduled(fixedDelay = 2000)
	public void executarTarefa() {
		log.info("tarefa executarTarefa executada");
	}
	
	@Scheduled(cron = "0 0 12 1 2 *")
	public void executarTarefaAoMeioDiaTodoDiaPrimeiroFev() {
		log.info("tarefa executarTarefaAoMeioDiaTodoDiaPrimeiroFev executada");
	}
	
	@Scheduled(cron = "0 0 12 * 2 1")
	public void executarTarefaAoMeioDiaTodaSegundaFev() {
		log.info("tarefa executarTarefaAoMeioDiaTodaSegundaFev executada");
	}
}
